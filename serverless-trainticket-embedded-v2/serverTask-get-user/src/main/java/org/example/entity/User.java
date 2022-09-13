package org.example.entity;

import java.util.UUID;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;


public class User  {

    private UUID userId;
    private String userName;
    private String password;

    private int gender;

    private int documentType;

    private String documentNum;

    private String email;


    public User() {
    }

    @ProtoFactory
    public User(UUID userId, String userName, String password, int gender, int documentType, String documentNum, String email) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.documentType = documentType;
        this.documentNum = documentNum;
        this.email = email;
    }

    @ProtoField(number = 1)
    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @ProtoField(number = 2)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @ProtoField(number = 3)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ProtoField(number = 4, required = true)
    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @ProtoField(number = 5, required = true)
    public int getDocumentType() {
        return documentType;
    }

    public void setDocumentType(int documentType) {
        this.documentType = documentType;
    }

    @ProtoField(number = 6)
    public String getDocumentNum() {
        return documentNum;
    }

    public void setDocumentNum(String documentNum) {
        this.documentNum = documentNum;
    }

    @ProtoField(number = 7)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", documentType=" + documentType +
                ", documentNum='" + documentNum + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
