package com.openfaas.function.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

/**
 * @author fdse
 */
public class User {

    private UUID userId;

    private String username;

    private String password;

    private Set<String> roles = new HashSet<>();


    public User() {
    }

    @ProtoFactory
    public User(UUID userId, String username, String password,Set<String> roles) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.roles=roles;
    }

    @ProtoField(number = 1)
    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @ProtoField(number = 2)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @ProtoField(number = 3)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ProtoField(number = 4)
    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
