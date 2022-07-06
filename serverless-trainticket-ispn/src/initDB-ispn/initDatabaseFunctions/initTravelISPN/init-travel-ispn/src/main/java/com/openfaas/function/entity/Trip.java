package com.openfaas.function.entity;

import java.util.Date;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class Trip {

    private TripId tripId;

    private String trainTypeId;

    private String routeId;

    private Date startingTime;

    private String startingStationId;

    private String stationsId;


    private String terminalStationId;

    private Date endTime;

    //@ProtoFactory
    public Trip(TripId tripId, String trainTypeId, String startingStationId, String stationsId, String terminalStationId, Date startingTime, Date endTime) {
        this.tripId = tripId;
        this.trainTypeId = trainTypeId;
        this.startingStationId = startingStationId;
        this.stationsId = stationsId;
        this.terminalStationId = terminalStationId;
        this.startingTime = startingTime;
        this.endTime = endTime;
    }

    public Trip(TripId tripId, String trainTypeId, String routeId) {
        this.tripId = tripId;
        this.trainTypeId = trainTypeId;
        this.routeId = routeId;
        this.startingStationId = "";
        this.terminalStationId = "";
        this.endTime = new Date();
    }

    public Trip(){
        //Default Constructor
        this.trainTypeId = "";
        this.startingStationId = "";
        this.terminalStationId = "";
        this.endTime = new Date();
    }

    @ProtoField(number = 1)
    public TripId getTripId() {
        return tripId;
    }

    public void setTripId(TripId tripId) {
        this.tripId = tripId;
    }

    @ProtoField(number = 2)
    public String getTrainTypeId() {
        return trainTypeId;
    }

    public void setTrainTypeId(String trainTypeId) {
        this.trainTypeId = trainTypeId;
    }

    @ProtoField(number = 3)
    public String getStartingStationId() {
        return startingStationId;
    }

    public void setStartingStationId(String startingStationId) {
        this.startingStationId = startingStationId;
    }

    @ProtoField(number = 4)
    public String getStationsId() {
        return stationsId;
    }

    public void setStationsId(String stationsId) {
        this.stationsId = stationsId;
    }

    @ProtoField(number = 5)
    public String getTerminalStationId() {
        return terminalStationId;
    }

    public void setTerminalStationId(String terminalStationId) {
        this.terminalStationId = terminalStationId;
    }

    @ProtoField(number = 6)
    public Date getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Date startingTime) {
        this.startingTime = startingTime;
    }

    @ProtoField(number = 7)
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @ProtoField(number = 8)
    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }
}
