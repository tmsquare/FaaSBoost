package com.openfaas.function.service;

import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;
import com.openfaas.function.entity.*;

import java.util.HashMap;

//import okhttp3.OkHttpClient;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class BasicServiceImpl implements BasicService {
    //private OkHttpClient client = new OkHttpClient();
    private HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    private String function03_URI = "gateway.openfaas:8080/function/get-route-by-routeid.openfaas-fn";
    private String function04_URI = "gateway.openfaas:8080/function/get-traintype-by-traintypeid.openfaas-fn";
    private String function05_URI = "gateway.openfaas:8080/function/get-price-by-routeid-and-traintype.openfaas-fn";
    private String function07_URI = "gateway.openfaas:8080/function/query-for-station-id-by-station-name.openfaas-fn";


    @Override
    public mResponse queryForTravel(Travel info) {

        mResponse response = new mResponse<>();
        TravelResult result = new TravelResult();
        result.setStatus(true);
        response.setStatus(1);
        response.setMsg("Success");
        boolean startingPlaceExist = checkStationExists(info.getStartingPlace());
        boolean endPlaceExist = checkStationExists(info.getEndPlace());

        if (!startingPlaceExist || !endPlaceExist) {
            result.setStatus(false);
            response.setStatus(0);
            response.setMsg("Start place or end place not exist!");
        }

        TrainType trainType = queryTrainType(info.getTrip().getTrainTypeId());
        if (trainType == null) {
            // BasicServiceImpl.LOGGER.info("traintype doesn't exist");
            result.setStatus(false);
            response.setStatus(0);
            response.setMsg("Train type doesn't exist");
        } else {
            result.setTrainType(trainType);
        }

        String routeId = info.getTrip().getRouteId();
        String trainTypeString = null;
        if (trainType != null) {
            trainTypeString = trainType.getId();
        }
        Route route = getRouteByRouteId(routeId);
        PriceConfig priceConfig = queryPriceConfigByRouteIdAndTrainType(routeId, trainTypeString);

        String startingPlaceId = queryForStationId(info.getStartingPlace());
        String endPlaceId = queryForStationId(info.getEndPlace());

        //  log.info("startingPlaceId : " + startingPlaceId + "endPlaceId : " + endPlaceId);

        int indexStart = 0;
        int indexEnd = 0;
        if (route != null) {
            indexStart = route.getStations().indexOf(startingPlaceId);
            indexEnd = route.getStations().indexOf(endPlaceId);
        }

        // log.info("indexStart : " + indexStart + " __ " + "indexEnd : " + indexEnd);
        if (route != null) {
            //     log.info("route.getDistances().size : " + route.getDistances().size());
        }
        HashMap<String, String> prices = new HashMap<>();
        try {
            int distance = 0;
            if (route != null) {
                distance = route.getDistances().get(indexEnd) - route.getDistances().get(indexStart);
            }

            /**
             * We need the price Rate and distance (starting station).
             */
            double priceForEconomyClass = distance * priceConfig.getBasicPriceRate();
            double priceForConfortClass = distance * priceConfig.getFirstClassPriceRate();
            prices.put("economyClass", "" + priceForEconomyClass);
            prices.put("confortClass", "" + priceForConfortClass);
        } catch (Exception e) {
            prices.put("economyClass", "95.0");
            prices.put("confortClass", "120.0");
        }
        result.setPrices(prices);
        result.setPercent(1.0);
        response.setData(result);
        return response;
    }

    private String queryForStationId(String stationName) {
        String ret = "";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("http://"+function07_URI + "/stationName/" + stationName))
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

    private boolean checkStationExists(String stationName) {
        String ret = "";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("http://"+function07_URI + "/stationName/" + stationName))
                    .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ret = response.body();

        } catch (Exception e) {
            e.printStackTrace();
        }
        mResponse stationIDRes = JsonUtils.json2Object(ret, mResponse.class);
        return stationIDRes.getStatus() == 1;
    }

    private TrainType queryTrainType(String trainTypeId) {
        String ret = "";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("http://"+function04_URI + "/trainTypeId/" + trainTypeId))
                    .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ret = response.body();

        } catch (Exception e) {
            e.printStackTrace();
        }
        mResponse TrainTypeRes = JsonUtils.json2Object(ret, mResponse.class);

        TrainType trainType = null;
        if (TrainTypeRes.getStatus() == 1) {
            trainType = JsonUtils.conveterObject(TrainTypeRes.getData(), TrainType.class);
        }
        return trainType;
    }

    private Route getRouteByRouteId(String routeId) {
        String ret = "";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("http://"+function03_URI + "/routeId/" + routeId))
                    .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ret = response.body();

        } catch (Exception e) {
            e.printStackTrace();
        }
        mResponse routeRes = JsonUtils.json2Object(ret, mResponse.class);

        Route route = null;
        if (routeRes.getStatus() == 1) {
            route = JsonUtils.conveterObject(routeRes.getData(), Route.class);

        }
        return route;
    }

    private PriceConfig queryPriceConfigByRouteIdAndTrainType(String routeId, String trainType) {
        String ret = "";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("http://"+function05_URI + "/routeId/" + routeId + "/trainType/" + trainType))
                    .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            ret = response.body();

        } catch (Exception e) {
            e.printStackTrace();
        }
        mResponse priceConfigRes = JsonUtils.json2Object(ret, mResponse.class);

        PriceConfig priceConfig = null;
        if (priceConfigRes.getStatus() == 1) {
            priceConfig = JsonUtils.conveterObject(priceConfigRes.getData(), PriceConfig.class);
        }
        return priceConfig;
    }

}
