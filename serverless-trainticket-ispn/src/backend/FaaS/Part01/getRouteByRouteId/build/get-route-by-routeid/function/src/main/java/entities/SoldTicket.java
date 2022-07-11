package entities;

import java.util.Date;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class SoldTicket {

    @ProtoField(number = 1)
    private Date travelDate;

    @ProtoField(number = 2)
    private String trainNumber;

    @ProtoField(number = 3, required=true)
    private int noSeat;

    @ProtoField(number = 4, required=true)
    private int businessSeat;

    @ProtoField(number = 5, required=true)
    private int firstClassSeat;

    @ProtoField(number = 6, required=true)
    private int secondClassSeat;

    @ProtoField(number = 7, required=true)
    private int hardSeat;

    @ProtoField(number = 8, required=true)
    private int softSeat;

    @ProtoField(number = 9, required=true)
    private int hardBed;

    @ProtoField(number = 10, required=true)
    private int softBed;

    @ProtoField(number = 11, required=true)
    private int highSoftBed;


    public SoldTicket(){
        noSeat = 0;
        businessSeat = 0;
        firstClassSeat = 0;
        secondClassSeat = 0;
        hardSeat = 0;
        softSeat = 0;
        hardBed = 0;
        softBed = 0;
        highSoftBed = 0;
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

    public int getNoSeat() {
        return noSeat;
    }

    public void setNoSeat(int noSeat) {
        this.noSeat = noSeat;
    }

    public int getBusinessSeat() {
        return businessSeat;
    }

    public void setBusinessSeat(int businessSeat) {
        this.businessSeat = businessSeat;
    }

    public int getFirstClassSeat() {
        return firstClassSeat;
    }

    public void setFirstClassSeat(int firstClassSeat) {
        this.firstClassSeat = firstClassSeat;
    }

    public int getSecondClassSeat() {
        return secondClassSeat;
    }

    public void setSecondClassSeat(int secondClassSeat) {
        this.secondClassSeat = secondClassSeat;
    }

    public int getHardSeat() {
        return hardSeat;
    }

    public void setHardSeat(int hardSeat) {
        this.hardSeat = hardSeat;
    }

    public int getSoftSeat() {
        return softSeat;
    }

    public void setSoftSeat(int softSeat) {
        this.softSeat = softSeat;
    }

    public int getHardBed() {
        return hardBed;
    }

    public void setHardBed(int hardBed) {
        this.hardBed = hardBed;
    }

    public int getSoftBed() {
        return softBed;
    }

    public void setSoftBed(int softBed) {
        this.softBed = softBed;
    }

    public int getHighSoftBed() {
        return highSoftBed;
    }

    public void setHighSoftBed(int highSoftBed) {
        this.highSoftBed = highSoftBed;
    }
}
