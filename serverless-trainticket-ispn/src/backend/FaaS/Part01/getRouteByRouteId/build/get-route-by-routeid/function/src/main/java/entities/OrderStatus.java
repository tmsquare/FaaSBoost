package entities;

import org.infinispan.protostream.annotations.ProtoEnumValue;

public enum OrderStatus {

    @ProtoEnumValue(number = 1, name = "NOTPAID")
    NOTPAID   (0,"Not Paid"),

    @ProtoEnumValue(number = 2, name = "PAID")
    PAID      (1,"Paid & Not Collected"),

    @ProtoEnumValue(number = 3, name = "COLLECTED")
    COLLECTED (2,"Collected"),

    @ProtoEnumValue(number = 4, name = "CHANGE")
    CHANGE    (3,"Cancel & Rebook"),

    @ProtoEnumValue(number = 5, name = "CANCEL")
    CANCEL    (4,"Cancel"),

    @ProtoEnumValue(number = 6, name = "REFUNDS")
    REFUNDS   (5,"Refunded"),

    @ProtoEnumValue(number = 7, name = "USED")
    USED      (6,"Used");

    private int code;
    private String name;

    OrderStatus(int code, String name){
        this.code = code;
        this.name = name;
    }

    public int getCode(){
        return code;
    }

    public String getName() {
        return name;
    }

    public static String getNameByCode(int code){
        OrderStatus[] orderStatusSet = OrderStatus.values();
        for(OrderStatus orderStatus : orderStatusSet){
            if(orderStatus.getCode() == code){
                return orderStatus.getName();
            }
        }
        return orderStatusSet[0].getName();
    }

}
