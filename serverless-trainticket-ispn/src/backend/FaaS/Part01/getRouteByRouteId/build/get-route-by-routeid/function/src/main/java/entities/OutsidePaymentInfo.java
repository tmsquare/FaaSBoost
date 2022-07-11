package entities;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class OutsidePaymentInfo {
    public OutsidePaymentInfo(){
        //Default Constructor
    }

    @ProtoField(number = 1)
    private String orderId;
    @ProtoField(number = 2)
    private String price;
    @ProtoField(number = 3)
    private String userId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

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
}
