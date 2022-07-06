package entities;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class AdminTrip {
    private Trip trip;
    private TrainType trainType;
    private Route route;

    public AdminTrip(){
        //Default Constructor
    }

    @ProtoField(number = 1)
    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    @ProtoField(number = 2)
    public TrainType getTrainType() {
        return trainType;
    }

    public void setTrainType(TrainType trainType) {
        this.trainType = trainType;
    }

    @ProtoField(number = 3)
    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
