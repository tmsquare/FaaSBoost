package entities;

import java.util.Date;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class OrderInfo {

    @ProtoField(number = 1)
    private String loginId;

    @ProtoField(number = 2)
    private Date travelDateStart;

    @ProtoField(number = 3)
    private Date travelDateEnd;

    @ProtoField(number = 4)
    private Date boughtDateStart;

    @ProtoField(number = 5)
    private Date boughtDateEnd;

    @ProtoField(number = 6, required=true)
    private int state;

    @ProtoField(number = 7, required=true)
    private boolean enableTravelDateQuery;

    @ProtoField(number = 8, required=true)
    private boolean enableBoughtDateQuery;

    @ProtoField(number = 9, required=true)
    private boolean enableStateQuery;

    public OrderInfo(){
        //Default Constructor
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public Date getTravelDateStart() {
        return travelDateStart;
    }

    public Date getTravelDateEnd() {
        return travelDateEnd;
    }

    public Date getBoughtDateStart() {
        return boughtDateStart;
    }

    public Date getBoughtDateEnd() {
        return boughtDateEnd;
    }

    public int getState() {
        return state;
    }

    public void enableTravelDateQuery(Date startTime, Date endTime){
        enableTravelDateQuery = true;
        travelDateStart = startTime;
        travelDateEnd = endTime;
    }

    public void disableTravelDateQuery(){
        enableTravelDateQuery = false;
        travelDateStart = null;
        travelDateEnd = null;
    }

    public void enableBoughtDateQuery(Date startTime, Date endTime){
        enableBoughtDateQuery = true;
        boughtDateStart = startTime;
        boughtDateEnd = endTime;
    }

    public void disableBoughtDateQuery(){
        enableBoughtDateQuery = false;
        boughtDateStart = null;
        boughtDateEnd = null;
    }

    public void enableStateQuery(int targetStatus){
        enableStateQuery = true;
        state = targetStatus;
    }

    public void disableStateQuery(){
        enableTravelDateQuery = false;
        state = -1;
    }

    public boolean isEnableTravelDateQuery() {
        return enableTravelDateQuery;
    }

    public boolean isEnableBoughtDateQuery() {
        return enableBoughtDateQuery;
    }

    public boolean isEnableStateQuery() {
        return enableStateQuery;
    }
}
