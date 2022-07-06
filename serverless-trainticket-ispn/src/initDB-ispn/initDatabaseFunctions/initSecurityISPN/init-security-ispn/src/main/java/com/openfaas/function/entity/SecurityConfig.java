package com.openfaas.function.entity;

import java.util.UUID;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class SecurityConfig {

    private UUID id;

    private String name;

    private String value;

    private String description;

    public SecurityConfig() {
        //Default Constructor
    }

    @ProtoField(number = 1)
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @ProtoField(number = 2)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ProtoField(number = 3)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @ProtoField(number = 4)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
