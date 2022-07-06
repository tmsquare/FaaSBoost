package entities;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class NotifyInfo {

    public NotifyInfo(){
        //Default Constructor
    }
    @ProtoField(number = 1)
    private String email;
    @ProtoField(number = 2)
    private String orderNumber;
    @ProtoField(number = 3)
    private String username;
    @ProtoField(number = 4)
    private String startingPlace;
    @ProtoField(number = 5)
    private String endPlace;
    @ProtoField(number = 6)
    private String startingTime;
    @ProtoField(number = 7)
    private String date;
    @ProtoField(number = 8)
    private String seatClass;
    @ProtoField(number = 9)
    private String seatNumber;
    @ProtoField(number = 10)
    private String price;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }
}
