package entities;

import java.util.Date;


import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class TripAllDetailInfo {

    @ProtoField(number = 1)
    private String tripId;

    @ProtoField(number = 2)
    private Date travelDate;

    @ProtoField(number = 3)
    private String from;

    @ProtoField(number = 4)
    private String to;

    public TripAllDetailInfo() {
        //Default Constructor
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
