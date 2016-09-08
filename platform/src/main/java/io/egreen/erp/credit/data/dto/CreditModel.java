package io.egreen.erp.credit.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Created by Pramode Wimukthi on 9/6/2016.
 */
@Entity
public class CreditModel {

    @Id
    @JsonIgnore
    private ObjectId objectId;

//    @JsonIgnore
    private  String creditId;

    private  int lastDigit;
    private  String creditName;
    private  String amount;

    public CreditModel() {

    }

    public ObjectId getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public int getLastDigit() {
        return lastDigit;
    }

    public void setLastDigit(int lastDigit) {
        this.lastDigit = lastDigit;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
