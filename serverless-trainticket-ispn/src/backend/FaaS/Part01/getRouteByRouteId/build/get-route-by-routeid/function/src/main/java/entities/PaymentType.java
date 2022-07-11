package entities;

import java.io.Serializable;

import org.infinispan.protostream.annotations.ProtoEnumValue;

public enum  PaymentType implements Serializable {

    @ProtoEnumValue(number = 1, name = "P")
    P("Payment",1),

    @ProtoEnumValue(number = 2, name = "D")
    D("Difference",2),

    @ProtoEnumValue(number = 3, name = "O")
    O("Outside Payment",3),

    @ProtoEnumValue(number = 4, name = "E")
    E("Difference & Outside Payment",4);

    private String name;
    private int index;

    PaymentType(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (PaymentType type : PaymentType.values()) {
            if (type.getIndex() == index) {
                return type.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    void setIndex(int index) {
        this.index = index;
    }
}
