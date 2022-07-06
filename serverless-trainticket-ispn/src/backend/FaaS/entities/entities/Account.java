package entities;

import java.util.UUID;

import org.infinispan.protostream.annotations.ProtoFactory;
import org.infinispan.protostream.annotations.ProtoField;

public class Account {

    private UUID id;

    private String password;

    private int gender;

    private String name;

    private int documentType;

    private String documentNum;

    private String email;


    public Account(){
        gender = Gender.OTHER.getCode();
        password = "defaultPassword"; //NOSONAR
        name = "None";
        documentType = DocumentType.NONE.getCode();
        documentNum = "0123456789";
        email = "0123456789";
    }

    @ProtoField(number = 1)
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @ProtoField(number = 2)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ProtoField(number = 3, required=true)
    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @ProtoField(number = 4)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ProtoField(number = 5, required=true)
    public int getDocumentType() {
        return documentType;
    }

    public void setDocumentType(int documentType) {
        this.documentType = documentType;
    }

    @ProtoField(number = 6)
    public String getDocumentNum() {
        return documentNum;
    }

    public void setDocumentNum(String documentNum) {
        this.documentNum = documentNum;
    }

    @ProtoField(number = 7)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
