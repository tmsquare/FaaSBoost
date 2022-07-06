package com.openfaas.function.entity;

import java.util.UUID;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class PriceConfig {

    private UUID id;

    private String trainType;

    private String routeId;

    private double basicPriceRate;

    private double firstClassPriceRate;

    public PriceConfig() {
        //Empty Constructor
    }

    @ProtoField(number = 1)
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @ProtoField(number = 2)
    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    @ProtoField(number = 3)
    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    @ProtoField(number = 4, required=true)
    public double getBasicPriceRate() {
        return basicPriceRate;
    }

    public void setBasicPriceRate(double basicPriceRate) {
        this.basicPriceRate = basicPriceRate;
    }

    @ProtoField(number = 5, required=true)
    public double getFirstClassPriceRate() {
        return firstClassPriceRate;
    }

    public void setFirstClassPriceRate(double firstClassPriceRate) {
        this.firstClassPriceRate = firstClassPriceRate;
    }
}
