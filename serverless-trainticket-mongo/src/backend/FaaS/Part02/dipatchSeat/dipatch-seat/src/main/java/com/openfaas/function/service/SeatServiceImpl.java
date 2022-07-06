package com.openfaas.function.service;

import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @author fdse
 */
public class SeatServiceImpl implements SeatService {

    //private OkHttpClient client = new OkHttpClient();
    private HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    private String function09_URI = "gateway.openfaas:8080/function/get-route-by-tripid.openfaas-fn";
    private String function10_URI = "gateway.openfaas:8080/function/get-sold-tickets.openfaas-fn";
    private String function11_URI = "gateway.openfaas:8080/function/get-traintype-by-tripid.openfaas-fn";

    @Override
    public mResponse distributeSeat(Seat seatRequest) {
        mResponse<Route> routeResult;

        LeftTicketInfo leftTicketInfo;
        TrainType trainTypeResult = null;


        //Distinguish G\D from other trains
        String trainNumber = seatRequest.getTrainNumber();


        //Call the microservice to query all the station information for the train
        //func09
        String ret = "";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("http://" + function09_URI + "/tripId/" + trainNumber))
                    .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ret = response.body();

        } catch (Exception e) {
            e.printStackTrace();
        }
        routeResult = JsonUtils.json2Object(ret, mResponse.class);


        //Call the microservice to query for residual Ticket information: the set of the Ticket sold for the specified seat type
        //func10
        String json = JsonUtils.object2Json(seatRequest);
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .uri(URI.create("http://" + function10_URI))
                    .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                    .header("Content-Type", "application/json")
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ret = response.body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mResponse mRes = JsonUtils.json2Object(ret, mResponse.class);
        leftTicketInfo = JsonUtils.conveterObject(mRes.getData(), LeftTicketInfo.class);

        //Calls the microservice to query the total number of seats specified for that vehicle
        //func11
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("http://" + function11_URI + "/tripId/" + seatRequest.getTrainNumber()))
                    .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ret = response.body();

        } catch (Exception e) {
            e.printStackTrace();
        }
        mRes = JsonUtils.json2Object(ret, mResponse.class);
        trainTypeResult = JsonUtils.conveterObject(mRes.getData(), TrainType.class);


        //Assign seats
        List<String> stationList = JsonUtils.conveterObject(routeResult.getData(), Route.class).getStations();
        int seatTotalNum = 0;
        if (seatRequest.getSeatType() == SeatClass.FIRSTCLASS.getCode()) {
            seatTotalNum = trainTypeResult.getConfortClass();
            //SeatServiceImpl.LOGGER.info("[SeatService distributeSeat] The request seat type is confortClass and the total num is {}", seatTotalNum);
        } else {
            seatTotalNum = trainTypeResult.getEconomyClass();
            //SeatServiceImpl.LOGGER.info("[SeatService distributeSeat] The request seat type is economyClass and the total num is {}", seatTotalNum);
        }
        String startStation = seatRequest.getStartStation();
        Ticket ticket = new Ticket();
        ticket.setStartStation(startStation);
        ticket.setDestStation(seatRequest.getDestStation());

        //Assign new tickets
        Random rand = new Random();
        int range = seatTotalNum;
        int seat = rand.nextInt(range) + 1;

        if (leftTicketInfo != null) {
            Set<Ticket> soldTickets = leftTicketInfo.getSoldTickets();
            //Give priority to tickets already sold
            for (Ticket soldTicket : soldTickets) {
                String soldTicketDestStation = soldTicket.getDestStation();
                //Tickets can be allocated if the sold ticket's end station before the start station of the request
                if (stationList.indexOf(soldTicketDestStation) < stationList.indexOf(startStation)) {
                    ticket.setSeatNo(soldTicket.getSeatNo());
                    //SeatServiceImpl.LOGGER.info("[SeatService distributeSeat] Use the previous distributed seat number! {}", soldTicket.getSeatNo());
                    return new mResponse<>(1, "Use the previous distributed seat number!", ticket);
                }
            }
            while (isContained(soldTickets, seat)) {
                seat = rand.nextInt(range) + 1;
            }
        }
        ticket.setSeatNo(String.valueOf(seat));
        //SeatServiceImpl.LOGGER.info("[SeatService distributeSeat] Use a new seat number! {}", seat);
        return new mResponse<>(1, "Use a new seat number!", ticket);
    }

    private boolean isContained(Set<Ticket> soldTickets, int seat) {
        //Check that the seat number has been used
        boolean result = false;
        for (Ticket soldTicket : soldTickets) {
            if (soldTicket.getSeatNo() == String.valueOf(seat)) {
                return true;
            }
        }
        return result;
    }

}