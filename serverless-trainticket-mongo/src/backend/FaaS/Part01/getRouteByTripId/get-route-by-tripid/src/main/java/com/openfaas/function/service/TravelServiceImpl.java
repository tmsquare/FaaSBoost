package com.openfaas.function.service;

import com.openfaas.function.repository.TripRepositoryImpl;
import edu.fudan.common.util.JsonUtils;
import edu.fudan.common.util.mResponse;

import com.openfaas.function.entity.*;

import com.openfaas.function.repository.TripRepository;
//import okhttp3.OkHttpClient;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


/**
 * @author fdse
 */
public class TravelServiceImpl implements TravelService {

    private TripRepository repository = new TripRepositoryImpl();

    //private OkHttpClient client = new OkHttpClient();
    private HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    private String function03_URI = "gateway.openfaas:8080/function/get-route-by-routeid.openfaas-fn";
    String success = "Success";
    String noContent = "No Content";


    @Override
    public mResponse getRouteByTripId(String tripId) {
        Route route = null;
        if (null != tripId && tripId.length() >= 2) {
            TripId tripId1 = new TripId(tripId);
            Trip trip = repository.findByTripId(tripId1);
            if (trip != null) {
                route = getRouteByRouteId(trip.getRouteId());
            }
        }
        if (route != null) {
            return new mResponse<>(1, success, route);
        } else {
            return new mResponse<>(0, noContent, null);
        }
    }

    private Route getRouteByRouteId(String routeId) {
    	System.out.println("http://" + function03_URI + "/routeId/" + routeId);
        String ret = "";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create("http://" + function03_URI + "/routeId/" + routeId))
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

}
