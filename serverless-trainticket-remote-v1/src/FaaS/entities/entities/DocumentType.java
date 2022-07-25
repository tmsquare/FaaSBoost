package entities;

import org.infinispan.protostream.annotations.ProtoEnumValue;

public enum DocumentType {

    @ProtoEnumValue(number = 1, name = "NONE")
    NONE      (0,"Null"),

    @ProtoEnumValue(number = 2, name = "ID_CARD")
    ID_CARD   (1,"ID Card"),

    @ProtoEnumValue(number = 3, name = "PASSPORT")
    PASSPORT  (2,"Passport"),

    @ProtoEnumValue(number = 4, name = "OTHER")
    OTHER     (3,"Other");

    private int code;
    private String name;

    DocumentType(int code, String name){
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
        DocumentType[] documentTypeSet = DocumentType.values();
        for(DocumentType documentType : documentTypeSet){
            if(documentType.getCode() == code){
                return documentType.getName();
            }
        }
        return documentTypeSet[0].getName();
    }
}
