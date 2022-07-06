package entities;

import java.util.Date;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class Trip {

    @ProtoField(number = 1)
    public TripId tripId;

    @ProtoField(number = 2)
    public String trainTypeId;

    @ProtoField(number = 3)
    public String routeId;

    @ProtoField(number = 4)
    public String startingStationId;

    @ProtoField(number = 5)
    public String stationsId;

    @ProtoField(number = 6)
    public String terminalStationId;

    @ProtoField(number = 7)
    public Date startingTime;

    @ProtoField(number = 8)
    public Date endTime;

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
        this.startingTime = new Date();
        this.endTime = new Date();
    }

    public Trip(){
        //Default Constructor
        this.trainTypeId = "";
        this.startingStationId = "";
        this.terminalStationId = "";
        this.startingTime = new Date();
        this.endTime = new Date();
    }

    public TripId getTripId() {
        return tripId;
    }

    public void setTripId(TripId tripId) {
        this.tripId = tripId;
    }

    public String getTrainTypeId() {
        return trainTypeId;
    }

    public void setTrainTypeId(String trainTypeId) {
        this.trainTypeId = trainTypeId;
    }

    public String getStartingStationId() {
        return startingStationId;
    }

    public void setStartingStationId(String startingStationId) {
        this.startingStationId = startingStationId;
    }

    public String getStationsId() {
        return stationsId;
    }

    public void setStationsId(String stationsId) {
        this.stationsId = stationsId;
    }

    public String getTerminalStationId() {
        return terminalStationId;
    }

    public void setTerminalStationId(String terminalStationId) {
        this.terminalStationId = terminalStationId;
    }

    public Date getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Date startingTime) {
        this.startingTime = startingTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }
}
