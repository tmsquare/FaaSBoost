package entities;

import java.util.Date;


import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class Travel {

    @ProtoField(number = 1)
    private Trip trip;

    @ProtoField(number = 2)
    private String startingPlace;

    @ProtoField(number = 3)
    private String endPlace;

    @ProtoField(number = 4)
    private Date departureTime;

    public Travel(){
        //Default Constructor
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public String getStartingPlace() {
        return startingPlace;
    }

    public void setStartingPlace(String startingPlace) {
        this.startingPlace = startingPlace;
    }

    public String getEndPlace() {
        return endPlace;
    }

    public void setEndPlace(String endPlace) {
        this.endPlace = endPlace;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }
}
