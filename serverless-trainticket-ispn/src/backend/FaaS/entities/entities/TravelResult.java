package entities;
import java.util.Map;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class TravelResult {

    @ProtoField(number = 1, required=true)
    private boolean status;

    @ProtoField(number = 2, required=true)
    private double percent;

    @ProtoField(number = 3)
    private TrainType trainType;

    @ProtoField(number = 4)
    private Map<String,String> prices;

    @ProtoField(number = 5)
    private String message;

    public TravelResult() {
        //Default Constructor
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }

    public TrainType getTrainType() {
        return trainType;
    }

    public void setTrainType(TrainType trainType) {
        this.trainType = trainType;
    }

    public Map<String, String> getPrices() {
        return prices;
    }

    public void setPrices(Map<String, String> prices) {
        this.prices = prices;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
