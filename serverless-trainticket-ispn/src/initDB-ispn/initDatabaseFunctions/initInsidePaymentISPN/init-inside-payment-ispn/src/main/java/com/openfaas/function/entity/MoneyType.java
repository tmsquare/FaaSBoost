package com.openfaas.function.entity;

import java.io.Serializable;

import org.infinispan.protostream.annotations.ProtoEnumValue;

public enum MoneyType implements Serializable {

    @ProtoEnumValue(number = 1, name = "A")
    A("Add Money",1),

    @ProtoEnumValue(number = 2, name = "D")
    D("Draw Back Money",2);

    public String name;
    public int index;

    MoneyType(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (MoneyType type : MoneyType.values()) {
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
