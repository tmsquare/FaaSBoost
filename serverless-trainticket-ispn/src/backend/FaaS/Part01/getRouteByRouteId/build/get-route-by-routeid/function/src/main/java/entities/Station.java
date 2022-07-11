package entities;

import java.util.UUID;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class Station {

    @ProtoField(number = 1)
    private String id;

    @ProtoField(number = 2)
    private String name;

    @ProtoField(number = 3, required=true)
    private int stayTime;

    public Station(){
        //Default Constructor
        this.id = UUID.randomUUID().toString();
        this.name = "";
    }

    public Station(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @ProtoFactory
    public Station(String id, String name, int stayTime) {
        this.id = id;
        this.name = name;
        this.stayTime = stayTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStayTime() {
        return stayTime;
    }

    public void setStayTime(int stayTime) {
        this.stayTime = stayTime;
    }
}
