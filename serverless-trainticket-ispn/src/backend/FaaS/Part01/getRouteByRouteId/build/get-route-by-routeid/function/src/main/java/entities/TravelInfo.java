package entities;

import java.util.Date;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class TravelInfo {

    @ProtoField(number = 1)
    private String tripId;

    @ProtoField(number = 2)
    private String trainTypeId;

    @ProtoField(number = 3)
    private String routeId;

    @ProtoField(number = 4)
    private String startingStationId;

    @ProtoField(number = 5)
    private String stationsId;

    @ProtoField(number = 6)
    private String terminalStationId;

    @ProtoField(number = 7)
    private Date startingTime;

    @ProtoField(number = 8)
    private Date endTime;

    public TravelInfo() {
        //Default Constructor
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
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
