package entities;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class Balance {

    private String userId;

    private String balance;


    public Balance(){
        //Default Constructor
        this.userId = "";
        this.balance = "";
    }

    @ProtoField(number = 1)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @ProtoField(number = 2)
    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
