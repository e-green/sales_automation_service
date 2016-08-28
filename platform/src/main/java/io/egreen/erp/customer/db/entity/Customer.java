package io.egreen.erp.customer.db.entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.Date;

/**
 * Created by dewmal on 8/23/16.
 */
@Entity("customer")
@Indexes(
        @Index(value = "name", fields = @Field("name"))
)
public class Customer {

    @Id
    private ObjectId id;

    private String code;
    private String name;
    private String nic;
    private String simpleAddress;
    private Date registerDate;

    @PostPersist
    void postPresist() {
        registerDate = new Date();
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getSimpleAddress() {
        return simpleAddress;
    }

    public void setSimpleAddress(String simpleAddress) {
        this.simpleAddress = simpleAddress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", simpleAddress='" + simpleAddress + '\'' +
                ", registerDate=" + registerDate +
                '}';
    }
}
