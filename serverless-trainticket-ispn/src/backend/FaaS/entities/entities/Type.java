package entities;


import java.io.Serializable;

import org.infinispan.protostream.annotations.ProtoEnumValue;

public enum Type implements Serializable{


    @ProtoEnumValue(number = 1, name = "G")
    G("G", 1),

    @ProtoEnumValue(number = 2, name = "D")
    D("D", 2),

    @ProtoEnumValue(number = 3, name = "Z")
    Z("Z", 3),

    @ProtoEnumValue(number = 4, name = "T")
    T("T", 4),

    @ProtoEnumValue(number = 5, name = "K")
    K("K", 5);

    public String name;
    public int index;


    Type(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (Type type : Type.values()) {
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
