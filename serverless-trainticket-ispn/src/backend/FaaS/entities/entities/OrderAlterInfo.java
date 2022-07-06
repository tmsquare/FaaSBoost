package entities;

import java.util.UUID;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class OrderAlterInfo {

    @ProtoField(number = 1)
    private UUID accountId;

    @ProtoField(number = 2)
    private UUID previousOrderId;

    @ProtoField(number = 3)
    private String loginToken;

    @ProtoField(number = 4)
    private Order newOrderInfo;


    public OrderAlterInfo(){
        newOrderInfo = new Order();
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public UUID getPreviousOrderId() {
        return previousOrderId;
    }

    public void setPreviousOrderId(UUID previousOrderId) {
        this.previousOrderId = previousOrderId;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public Order getNewOrderInfo() {
        return newOrderInfo;
    }

    public void setNewOrderInfo(Order newOrderInfo) {
        this.newOrderInfo = newOrderInfo;
    }
}
