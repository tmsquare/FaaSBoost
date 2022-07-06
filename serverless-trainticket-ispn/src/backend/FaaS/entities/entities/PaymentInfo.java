package entities;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class PaymentInfo {
    public PaymentInfo(){
        //Default Constructor
    }

    @ProtoField(number = 1)
    private String userId;
    @ProtoField(number = 2)
    private String orderId;
    @ProtoField(number = 3)
    private String tripId;
    @ProtoField(number = 4)
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }
}
