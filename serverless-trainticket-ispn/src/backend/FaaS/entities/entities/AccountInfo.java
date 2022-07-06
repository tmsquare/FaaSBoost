package entities;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;


public class AccountInfo {

    private String userId;

    private String money;

    public AccountInfo(){
        //Default Constructor
    }

    @ProtoField(number = 1)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @ProtoField(number = 2)
    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

}
