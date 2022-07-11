package entities;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class OrderSecurity {

    @ProtoField(number = 1)
    private int orderNumInLastOneHour;

    @ProtoField(number = 2)
    private int orderNumOfValidOrder;

    public OrderSecurity() {
        //Default Constructor
    }

    public int getOrderNumInLastOneHour() {
        return orderNumInLastOneHour;
    }

    public void setOrderNumInLastOneHour(int orderNumInLastOneHour) {
        this.orderNumInLastOneHour = orderNumInLastOneHour;
    }

    public int getOrderNumOfValidOrder() {
        return orderNumOfValidOrder;
    }

    public void setOrderNumOfValidOrder(int orderNumOfValidOrder) {
        this.orderNumOfValidOrder = orderNumOfValidOrder;
    }
}
