package io.egreen.erp.sale.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.Date;

/**
 * Created by Pramode Wimukthi on 9/16/2016.
 */
@Entity
public class SaleModel {

    @Id
    @JsonIgnore
    private ObjectId objectId;


    private String outLetId;
    private String contactPerson;
    private String simNumber;
    private Date date;
    private double salePrice;

    public SaleModel() {

    }

    public ObjectId getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    public String getOutLetId() {
        return outLetId;
    }

    public void setOutLetId(String outLetId) {
        this.outLetId = outLetId;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getSimNumber() {
        return simNumber;
    }

    public void setSimNumber(String simNumber) {
        this.simNumber = simNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }
}
