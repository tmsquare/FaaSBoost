package entities;

import java.util.Date;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class OrderTicketsInfo {
    @ProtoField(number = 1)
    private String accountId;

    @ProtoField(number = 2)
    private String contactsId;

    @ProtoField(number = 3)
    private String tripId;

    @ProtoField(number = 4, required=true)
    private int seatType;

    @ProtoField(number = 5)
    private Date date;

    @ProtoField(number = 6)
    private String from;

    @ProtoField(number = 7)
    private String to;

    @ProtoField(number = 8, required=true)
    private int assurance;

    @ProtoField(number = 9, required=true)
    private int foodType = 0;

    @ProtoField(number = 10)
    private String stationName;

    @ProtoField(number = 11)
    private String storeName;

    @ProtoField(number = 12)
    private String foodName;

    @ProtoField(number = 13, required=true)
    private double foodPrice;

    @ProtoField(number = 14)
    private String handleDate;

    @ProtoField(number = 15)
    private String consigneeName = "";

    @ProtoField(number = 16)
    private String consigneePhone = "";

    @ProtoField(number = 17, required=true)
    private double consigneeWeight;

    @ProtoField(number = 18, required=true)
    private boolean isWithin;


    public OrderTicketsInfo() {
        //Default Constructor
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getFoodType() {
        return foodType;
    }

    public void setFoodType(int foodType) {
        this.foodType = foodType;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getHandleDate() {
        return handleDate;
    }

    public void setHandleDate(String handleDate) {
        this.handleDate = handleDate;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getConsigneePhone() {
        return consigneePhone;
    }

    public void setConsigneePhone(String consigneePhone) {
        this.consigneePhone = consigneePhone;
    }

    public double getConsigneeWeight() {
        return consigneeWeight;
    }

    public void setConsigneeWeight(double consigneeWeight) {
        this.consigneeWeight = consigneeWeight;
    }

    public boolean isWithin() {
        return isWithin;
    }

    public void setWithin(boolean within) {
        isWithin = within;
    }

    public String getContactsId() {
        return contactsId;
    }

    public void setContactsId(String contactsId) {
        this.contactsId = contactsId;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public int getSeatType() {
        return seatType;
    }

    public void setSeatType(int seatType) {
        this.seatType = seatType;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public int getAssurance() {
        return assurance;
    }

    public void setAssurance(int assurance) {
        this.assurance = assurance;
    }
}