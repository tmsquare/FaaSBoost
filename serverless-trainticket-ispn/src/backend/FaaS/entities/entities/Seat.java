package entities;

import java.util.Date;


import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class Seat {

    @ProtoField(number = 1)
    private Date travelDate;

    @ProtoField(number = 2)
    private String trainNumber;

    @ProtoField(number = 3)
    private String startStation;

    @ProtoField(number = 4)
    private String destStation;

    @ProtoField(number = 5, required=true)
    private int seatType;

    public Seat(){
        //Default Constructor
        this.travelDate = new Date();
        this.trainNumber = "";
        this.startStation = "";
        this.destStation = "";
        this.seatType = 0;
    }

    public Date getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(Date travelDate) {
        this.travelDate = travelDate;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getDestStation() {
        return destStation;
    }

    public void setDestStation(String destStation) {
        this.destStation = destStation;
    }

    public int getSeatType() {
        return seatType;
    }

    public void setSeatType(int seatType) {
        this.seatType = seatType;
    }
}
