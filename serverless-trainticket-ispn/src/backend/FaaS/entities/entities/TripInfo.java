package entities;

import java.util.Date;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class TripInfo {

    @ProtoField(number = 1)
    private String startingPlace;

    @ProtoField(number = 2)
    private String endPlace;

    @ProtoField(number = 3)
    private Date departureTime;

    public TripInfo(){
        //Default Constructor
        this.startingPlace = "";
        this.endPlace = "";
        this.departureTime = new Date();
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
