package io.egreen.erp.customer.db.entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

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

    private String name;
    private String nic;
    private String simpleAddress;

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
                ", name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", simpleAddress='" + simpleAddress + '\'' +
                '}';
    }
}
