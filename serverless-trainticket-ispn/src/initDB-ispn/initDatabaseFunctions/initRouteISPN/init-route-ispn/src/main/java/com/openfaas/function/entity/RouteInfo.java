package com.openfaas.function.entity;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

/**
 * @author fdse
 */
public class RouteInfo {
    private String id;

    private String startStation;

    private String endStation;

    private String stationList;

    private String distanceList;

    public RouteInfo() {
        //Default Constructor
    }

    @ProtoField(number = 1)
    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    @ProtoField(number = 2)
    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    @ProtoField(number = 3)
    public String getStationList() {
        return stationList;
    }

    public void setStationList(String stationList) {
        this.stationList = stationList;
    }

    @ProtoField(number = 4)
    public String getDistanceList() {
        return distanceList;
    }

    public void setDistanceList(String distanceList) {
        this.distanceList = distanceList;
    }

    @ProtoField(number = 5)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
