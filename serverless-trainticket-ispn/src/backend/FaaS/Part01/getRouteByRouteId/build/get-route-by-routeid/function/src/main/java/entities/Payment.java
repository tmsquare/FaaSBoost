package entities;

import java.util.UUID;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class Payment {

    @ProtoField(number = 1)
    private String id;

    @ProtoField(number = 2)
    private String orderId;

    @ProtoField(number = 3)
    private String userId;

    @ProtoField(number = 4)
    private String price;

    @ProtoField(number = 5)
    private PaymentType type;

    public Payment(){
        this.id = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        this.orderId = "";
        this.userId = "";
        this.price = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public PaymentType getType() {
        return type;
    }

    public void setType(PaymentType type) {
        this.type = type;
    }
}
