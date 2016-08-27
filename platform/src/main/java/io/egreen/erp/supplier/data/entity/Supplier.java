package io.egreen.erp.supplier.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

/**
 * Created by dewmal on 8/24/16.
 */
@Entity("supplier")
@Indexes(
        @Index(value = "name", fields = @Field("name"))
)
public class Supplier {

    @Id
    @JsonIgnore
    private ObjectId id;
    private String code;
    private String name;
    private String nic;
    private String tpNumber;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getTpNumber() {
        return tpNumber;
    }

    public void setTpNumber(String tpNumber) {
        this.tpNumber = tpNumber;
    }
}
