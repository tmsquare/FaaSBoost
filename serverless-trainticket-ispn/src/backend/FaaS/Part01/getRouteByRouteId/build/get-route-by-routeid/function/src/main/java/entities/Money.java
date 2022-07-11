package entities;

import java.util.UUID;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class Money {

    @ProtoField(number = 1)
    private String id;

    @ProtoField(number = 2)
    private String userId;

    @ProtoField(number = 3)
    private String money;

    @ProtoField(number = 4)
    private MoneyType type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Money(){
        this.id = UUID.randomUUID().toString();
        this.userId = "";
        this.money = "";

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public MoneyType getType() {
        return type;
    }

    public void setType(MoneyType type) {
        this.type = type;
    }
}
