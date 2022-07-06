package com.openfaas.function.entity;

import java.util.UUID;
import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;


public class Payment {

    private String id;

    private String orderId;

    private String userId;

    private String price;

    public Payment(){
        this.id = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        this.orderId = "";
        this.userId = "";
        this.price = "";
    }

    @ProtoField(number = 1)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ProtoField(number = 2)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @ProtoField(number = 3)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @ProtoField(number = 4)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
