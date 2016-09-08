package io.egreen.erp.cheque.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Created by Pramode Wimukthi on 9/5/2016.
 */
@Entity
public class ChequeModel {
    @Id
    @JsonIgnore
    private ObjectId objectId;

    @JsonIgnore
    private String cheqId;

    private String cheqNo;
    private String cheqBank;
    private String cheqDate;
    private double cheqAmount;
    private String inOut;

    public ChequeModel() {

    }

    public ObjectId getObjectId() {
        return objectId;
    }

    public void setObjectId(ObjectId objectId) {
        this.objectId = objectId;
    }

    public String getCheqId() {
        return cheqId;
    }

    public void setCheqId(String cheqId) {
        this.cheqId = cheqId;
    }

    public String getCheqNo() {
        return cheqNo;
    }

    public void setCheqNo(String cheqNo) {
        this.cheqNo = cheqNo;
    }

    public String getCheqBank() {
        return cheqBank;
    }

    public void setCheqBank(String cheqBank) {
        this.cheqBank = cheqBank;
    }

    public String getCheqDate() {
        return cheqDate;
    }

    public void setCheqDate(String cheqDate) {
        this.cheqDate = cheqDate;
    }

    public double getCheqAmount() {
        return cheqAmount;
    }

    public void setCheqAmount(double cheqAmount) {
        this.cheqAmount = cheqAmount;
    }

    public String getInOut() {
        return inOut;
    }

    public void setInOut(String inOut) {
        this.inOut = inOut;
    }
}
