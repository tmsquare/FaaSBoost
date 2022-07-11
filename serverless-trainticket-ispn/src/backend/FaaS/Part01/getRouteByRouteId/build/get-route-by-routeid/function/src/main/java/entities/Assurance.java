package entities;


import java.util.UUID;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class Assurance {

    private UUID id;

    private UUID orderId;

    private AssuranceType type;

    public Assurance(){
        this.orderId = UUID.randomUUID();
    }

    @ProtoFactory
    public Assurance(UUID id, UUID orderId, AssuranceType type){
        this.id = id;
        this.orderId = orderId;
        this.type = type;
    }

    @ProtoField(number = 1)
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @ProtoField(number = 2)
    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    @ProtoField(number = 3)
    public AssuranceType getType() {
        return type;
    }

    public void setType(AssuranceType type) {
        this.type = type;
    }

}
