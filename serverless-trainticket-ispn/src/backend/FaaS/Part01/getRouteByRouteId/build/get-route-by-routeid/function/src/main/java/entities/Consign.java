package entities;


import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;
import java.util.UUID;

public class Consign {

    @ProtoField(number = 1)
    private UUID id;
    @ProtoField(number = 2)
    private UUID orderId;
    @ProtoField(number = 3)
    private UUID accountId;
    @ProtoField(number = 4)
    private String handleDate;
    @ProtoField(number = 5)
    private String targetDate;
    @ProtoField(number = 6)
    private String from;
    @ProtoField(number = 7)
    private String to;
    @ProtoField(number = 8)
    private String consignee;
    @ProtoField(number = 9)
    private String phone;
    @ProtoField(number = 10, required=true)
    private double weight;
    @ProtoField(number = 11, required=true)
    private boolean isWithin;


}
