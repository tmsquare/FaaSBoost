package entities;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class TripAllDetail {

    @ProtoField(number = 1)
    private TripResponse tripResponse;

    @ProtoField(number = 2)
    private Trip trip;

    public TripAllDetail() {
        //Default Constructor
    }

    public TripResponse getTripResponse() {
        return tripResponse;
    }

    public void setTripResponse(TripResponse tripResponse) {
        this.tripResponse = tripResponse;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

}
