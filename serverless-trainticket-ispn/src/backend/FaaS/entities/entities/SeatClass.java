package entities;

import org.infinispan.protostream.annotations.ProtoEnumValue;

public enum SeatClass {

    @ProtoEnumValue(number = 1, name = "NONE")
    NONE        (0,"NoSeat"),

    @ProtoEnumValue(number = 2, name = "BUSINESS")
    BUSINESS    (1,"GreenSeat"),

    @ProtoEnumValue(number = 3, name = "FIRSTCLASS")
    FIRSTCLASS  (2,"FirstClassSeat"),

    @ProtoEnumValue(number = 4, name = "SECONDCLASS")
    SECONDCLASS (3,"SecondClassSeat"),

    @ProtoEnumValue(number = 5, name = "HARDSEAT")
    HARDSEAT    (4,"HardSeat"),

    @ProtoEnumValue(number = 6, name = "SOFTSEAT")
    SOFTSEAT    (5,"SoftSeat"),

    @ProtoEnumValue(number = 7, name = "HARDBED")
    HARDBED     (6,"HardBed"),

    @ProtoEnumValue(number = 8, name = "SOFTBED")
    SOFTBED     (7,"SoftBed"),

    @ProtoEnumValue(number = 9, name = "HIGHSOFTBED")
    HIGHSOFTBED (8,"HighSoftSeat");

    private int code;
    private String name;

    SeatClass(int code, String name){
        this.code = code;
        this.name = name;
    }

    public int getCode(){
        return code;
    }

    public String getName() {
        return name;
    }

    public static String getNameByCode(int code){
        SeatClass[] seatClassSet = SeatClass.values();
        for(SeatClass seatClass : seatClassSet){
            if(seatClass.getCode() == code){
                return seatClass.getName();
            }
        }
        return seatClassSet[0].getName();
    }
}
