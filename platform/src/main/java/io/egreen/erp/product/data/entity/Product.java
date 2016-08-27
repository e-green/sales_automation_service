package io.egreen.erp.product.data.entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

/**
 * Created by dewmal on 8/24/16.
 */
@Entity("product")
@Indexes(
        @Index(value = "name", fields = @Field("name"))
)
public class Product {

    @Id
    private ObjectId id;
    private String name;
    private String code;
    private String category;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
