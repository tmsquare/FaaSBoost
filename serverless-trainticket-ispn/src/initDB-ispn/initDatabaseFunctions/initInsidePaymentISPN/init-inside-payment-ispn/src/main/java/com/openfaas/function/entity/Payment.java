package com.openfaas.function.entity;

import java.util.UUID;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class Payment {

    @ProtoField(number = 1)
    public String id;

    @ProtoField(number = 2)
    public String orderId;

    @ProtoField(number = 3)
    public String userId;

    @ProtoField(number = 4)
    public String price;

    @ProtoField(number = 5)
    public PaymentType type;

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
