package com.openfaas.function.service;

import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;

import com.openfaas.function.entity.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.Date;
import java.util.UUID;

/**
 * @author fdse
 */

public class PreserveServiceImpl implements PreserveService {

    //private OkHttpClient client = new OkHttpClient();
    private HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    String function02_URI = "gateway.openfaas:8080/function/query-for-travel.openfaas-fn";
    String function07_URI = "gateway.openfaas:8080/function/query-for-station-id-by-station-name.openfaas-fn";

    String function14_URI = "gateway.openfaas:8080/function/check-security.openfaas-fn";
    String function15_URI = "gateway.openfaas:8080/function/get-user-by-userid.openfaas-fn";
    String function16_URI = "gateway.openfaas:8080/function/dipatch-seat.openfaas-fn";
    String function17_URI = "127.0.0.1:8098";
    String function18_URI = "gateway.openfaas:8080/function/get-trip-all-detai-info.openfaas-fn";
    String function19_URI = "gateway.openfaas:8080/function/get-contacts-by-contactsid.openfaas-fn";
    String function20_URI = "gateway.openfaas:8080/function/create-order.openfaas-fn";


    @Override
    public mResponse preserve(OrderTicketsInfo oti) {

        //1.detect ticket scalper

        mResponse result = checkSecurity(oti.getAccountId());
        if (result.getStatus() == 0) {
            return new mResponse<>(0, result.getMsg(), null);
        }
        //2.Querying contact information -- modification, mediated by the underlying information micro service

        mResponse<Contacts> gcr = getContactsById(oti.getContactsId());
        if (gcr.getStatus() == 0) {
            return new mResponse<>(0, gcr.getMsg(), null);
        }

        //3.Check the info of train and the number of remaining tickets
        TripAllDetailInfo gtdi = new TripAllDetailInfo();

        gtdi.setFrom(oti.getFrom());
        gtdi.setTo(oti.getTo());

        gtdi.setTravelDate(oti.getDate());
        gtdi.setTripId(oti.getTripId());
        mResponse<TripAllDetail> response = getTripAllDetailInformation(gtdi);
        TripAllDetail gtdr=JsonUtils.conveterObject(response.getData(), TripAllDetail.class);

        if (response.getStatus() == 0) {
            return new mResponse<>(0, response.getMsg(), null);
        } else {
            TripResponse tripResponse = gtdr.getTripResponse();
            if (oti.getSeatType() == SeatClass.FIRSTCLASS.getCode()) {
                if (tripResponse.getConfortClass() == 0) {
                    return new mResponse<>(0, "Seat Not Enough", null);
                }
            } else {
                if (tripResponse.getEconomyClass() == SeatClass.SECONDCLASS.getCode() && tripResponse.getConfortClass() == 0) {
                    return new mResponse<>(0, "Seat Not Enough", null);
                }
            }
        }
        Trip trip = gtdr.getTrip();


        //4.send the order request and set the order information
        Contacts contacts = JsonUtils.conveterObject(gcr.getData(), Contacts.class);
        Order order = new Order();
        UUID orderId = UUID.randomUUID();
        order.setId(orderId);
        order.setTrainNumber(oti.getTripId());
        order.setAccountId(UUID.fromString(oti.getAccountId()));

        String fromStationId = queryForStationId(oti.getFrom());
        String toStationId = queryForStationId(oti.getTo());

        order.setFrom(fromStationId);
        order.setTo(toStationId);
        order.setBoughtDate(new Date());
        order.setStatus(OrderStatus.NOTPAID.getCode());
        order.setContactsDocumentNumber(contacts.getDocumentNumber());
        order.setContactsName(contacts.getName());
        order.setDocumentType(contacts.getDocumentType());

        Travel query = new Travel();
        query.setTrip(trip);
        query.setStartingPlace(oti.getFrom());
        query.setEndPlace(oti.getTo());
        query.setDepartureTime(new Date());

        String ret = "";
        String json = JsonUtils.object2Json(query);
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .uri(URI.create("http://" + function02_URI))
                    .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                    .header("Content-Type", "application/json")
                    .build();

            HttpResponse<String> resp = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ret = resp.body();

        } catch (Exception e) {
            e.printStackTrace();
        }
        mResponse mRes = JsonUtils.json2Object(ret, mResponse.class);
        TravelResult resultForTravel = JsonUtils.conveterObject(mRes.getData(), TravelResult.class);


        order.setSeatClass(oti.getSeatType());
        order.setTravelDate(oti.getDate());
        order.setTravelTime(gtdr.getTripResponse().getStartingTime());

        //Dispatch the seat
        if (oti.getSeatType() == SeatClass.FIRSTCLASS.getCode()) {
            Ticket ticket =
                    dipatchSeat(oti.getDate(),
                            order.getTrainNumber(), fromStationId, toStationId,
                            SeatClass.FIRSTCLASS.getCode());
            order.setSeatNumber("" + ticket.getSeatNo());
            order.setSeatClass(SeatClass.FIRSTCLASS.getCode());
            order.setPrice(resultForTravel.getPrices().get("confortClass"));
        } else {
            Ticket ticket =
                    dipatchSeat(oti.getDate(),
                            order.getTrainNumber(), fromStationId, toStationId,
                            SeatClass.SECONDCLASS.getCode());
            order.setSeatClass(SeatClass.SECONDCLASS.getCode());
            order.setSeatNumber("" + ticket.getSeatNo());
            order.setPrice(resultForTravel.getPrices().get("economyClass"));
        }

        mResponse<Order> cor = createOrder(order);
        if (cor.getStatus() == 0) {
            return new mResponse<>(0, cor.getMsg(), null);
        }

        Order orderCreated=JsonUtils.conveterObject(cor.getData(),Order.class);
        mResponse returnResponse = new mResponse<>(1, "Success.", orderCreated.getId().toString());


        return returnResponse;
    }

    public Ticket dipatchSeat(Date date, String tripId, String startStationId, String endStataionId, int seatType) {
        Seat seatRequest = new Seat();
        seatRequest.setTravelDate(date);
        seatRequest.setTrainNumber(tripId);
        seatRequest.setStartStation(startStationId);
        seatRequest.setDestStation(endStataionId);
        seatRequest.setSeatType(seatType);

        String ret = "";
        String json = JsonUtils.object2Json(seatRequest);
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .uri(URI.create("http://" + function16_URI))
                    .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                    .header("Content-Type", "application/json")
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ret = response.body();

        } catch (Exception e) {
            e.printStackTrace();
        }
        mResponse mRes = JsonUtils.json2Object(ret, mResponse.class);
        return JsonUtils.conveterObject(mRes.getData(), Ticket.class);
    }

    public boolean sendEmail(NotifyInfo notifyInfo) {
        String ret = "";
        String json = JsonUtils.object2Json(notifyInfo);
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .uri(URI.create("http://" + function17_URI))
                    .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                    .header("Content-Type", "application/json")
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ret = response.body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mResponse mRes = JsonUtils.json2Object(ret, mResponse.class);
//        TravelResult resultForTravel = JsonUtils.conveterObject(mRes.getData(), TravelResult.class);
        return true;
    }

    public User getAccount(String accountId) {
        String ret = "";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("http://" + function15_URI + "/accountId/" + accountId))
                    .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ret = response.body();

        } catch (Exception e) {
            e.printStackTrace();
        }

        mResponse mRes = JsonUtils.json2Object(ret, mResponse.class);
        return JsonUtils.conveterObject(mRes.getData(), User.class);
    }

//    private Response addAssuranceForOrder(int assuranceType, String orderId, HttpHeaders httpHeaders) {
//        HttpEntity requestAddAssuranceResult = new HttpEntity(httpHeaders);
//        ResponseEntity<Response> reAddAssuranceResult = restTemplate.exchange(
//                "http://ts-assurance-service:18888/api/v1/assuranceservice/assurances/" + assuranceType + "/" + orderId,
//                HttpMethod.GET,
//                requestAddAssuranceResult,
//                Response.class);
//
//        return reAddAssuranceResult.getBody();
//    }

    private String queryForStationId(String stationName) {
        String ret = "";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("http://" + function07_URI + "/stationName/" + stationName))
                    .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ret = response.body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mResponse stationIDRes = JsonUtils.json2Object(ret, mResponse.class);

        String stationID = "";
        if (stationIDRes.getStatus() == 1) {
            stationID = (String) stationIDRes.getData();
        }
        return stationID;
    }

    private mResponse checkSecurity(String accountId) {
        String ret = "";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("http://" + function14_URI + "/accountId/" + accountId))
                    .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ret = response.body();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return JsonUtils.json2Object(ret, mResponse.class);
    }

    private mResponse<TripAllDetail> getTripAllDetailInformation(TripAllDetailInfo gtdi) {
        String ret = "";
        String json = JsonUtils.object2Json(gtdi);
        System.out.println(json);
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .uri(URI.create("http://" + function18_URI))
                    .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                    .header("Content-Type", "application/json")
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ret = response.body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtils.json2Object(ret, mResponse.class);
    }

    private mResponse<Contacts> getContactsById(String contactsId) {
        String ret = "";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("http://" + function19_URI + "/contactsId/" + contactsId))
                    .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ret = response.body();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtils.json2Object(ret, mResponse.class);
    }

    private mResponse createOrder(Order coi) {
        String ret = "";
        String json = JsonUtils.object2Json(coi);
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .uri(URI.create("http://" + function20_URI))
                    .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                    .header("Content-Type", "application/json")
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ret = response.body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonUtils.json2Object(ret, mResponse.class);
    }

//    private Response createFoodOrder(FoodOrder afi, HttpHeaders httpHeaders) {
//
//        HttpEntity requestEntityAddFoodOrderResult = new HttpEntity(afi, httpHeaders);
//        ResponseEntity<Response> reAddFoodOrderResult = restTemplate.exchange(
//                "http://ts-food-service:18856/api/v1/foodservice/orders",
//                HttpMethod.POST,
//                requestEntityAddFoodOrderResult,
//                Response.class);
//
//        return reAddFoodOrderResult.getBody();
//    }

//    private Response createConsign(Consign cr, HttpHeaders httpHeaders) {
//
//        HttpEntity requestEntityResultForTravel = new HttpEntity(cr, httpHeaders);
//        ResponseEntity<Response> reResultForTravel = restTemplate.exchange(
//                "http://ts-consign-service:16111/api/v1/consignservice/consigns",
//                HttpMethod.POST,
//                requestEntityResultForTravel,
//                Response.class);
//        return reResultForTravel.getBody();
//    }

}
