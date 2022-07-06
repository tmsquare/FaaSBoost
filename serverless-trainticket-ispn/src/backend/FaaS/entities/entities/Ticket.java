package entities;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class Ticket {

    @ProtoField(number = 1)
    private String seatNo;

    @ProtoField(number = 2)
    private String startStation;

    @ProtoField(number = 3)
    private String destStation;

    public Ticket(){

    }

    public Ticket(String seatNo, String startStation, String destStation) {
        this.seatNo = seatNo;
        this.startStation = startStation;
        this.destStation = destStation;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getDestStation() {
        return destStation;
    }

    public void setDestStation(String destStation) {
        this.destStation = destStation;
    }
}
