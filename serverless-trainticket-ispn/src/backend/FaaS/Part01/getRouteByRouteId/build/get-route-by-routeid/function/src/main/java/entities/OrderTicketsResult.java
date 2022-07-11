package entities;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class OrderTicketsResult {

    @ProtoField(number = 1, required=true)
    private boolean status;

    @ProtoField(number = 2)
    private String message;

    @ProtoField(number = 3)
    private Order order;

    public OrderTicketsResult(){
        //Default Constructor
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
