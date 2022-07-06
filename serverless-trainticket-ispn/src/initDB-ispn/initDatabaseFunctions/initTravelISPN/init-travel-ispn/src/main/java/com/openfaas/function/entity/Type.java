package com.openfaas.function.entity;

import java.io.Serializable;

import org.infinispan.protostream.annotations.ProtoEnumValue;

public enum Type implements Serializable{

    /**
     * G
     */
    @ProtoEnumValue(number = 1, name = "G")
    G("G", 1),
    /**
     * D
     */
    @ProtoEnumValue(number = 2, name = "D")
    D("D", 2);

    private String name;
    private int index;


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
