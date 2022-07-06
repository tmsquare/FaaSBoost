package com.openfaas.function.entity;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

/**
 * @author fdse
 */
public class Config {
    private String name;

    private String value;

    private String description;

    public Config() {
        this.name = "";
        this.value = "";
    }

    @ProtoFactory
    public Config(String name, String value, String description) {
        this.name = name;
        this.value = value;
        this.description = description;
    }

    @ProtoField(number = 1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ProtoField(number = 2)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @ProtoField(number = 3)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}