package entities;

import java.util.UUID;


import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class PriceConfig {

    @ProtoField(number = 1)
    private UUID id;

    @ProtoField(number = 2)
    private String trainType;

    @ProtoField(number = 3)
    private String routeId;

    @ProtoField(number = 4, required=true)
    private double basicPriceRate;

    @ProtoField(number = 5, required=true)
    private double firstClassPriceRate;

    public PriceConfig() {
        //Empty Constructor
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public double getBasicPriceRate() {
        return basicPriceRate;
    }

    public void setBasicPriceRate(double basicPriceRate) {
        this.basicPriceRate = basicPriceRate;
    }

    public double getFirstClassPriceRate() {
        return firstClassPriceRate;
    }

    public void setFirstClassPriceRate(double firstClassPriceRate) {
        this.firstClassPriceRate = firstClassPriceRate;
    }
}
