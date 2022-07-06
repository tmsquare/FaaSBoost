package entities;

import org.infinispan.protostream.annotations.ProtoEnumValue;

public enum Gender {

    @ProtoEnumValue(number = 1, name = "NONE")
    NONE   (0, "Null"),

    @ProtoEnumValue(number = 2, name = "MALE")
    MALE   (1, "Male"),

    @ProtoEnumValue(number = 3, name = "FEMALE")
    FEMALE (2, "Female"),

    @ProtoEnumValue(number = 4, name = "OTHER")
    OTHER  (3, "Other");

    private int code;
    private String name;

    Gender(int code, String name){
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
        Gender[] genderSet = Gender.values();
        for(Gender gender : genderSet){
            if(gender.getCode() == code){
                return gender.getName();
            }
        }
        return genderSet[0].getName();
    }

}
