package io.egreen.erp.grn.data.entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.PrePersist;

import java.util.Date;

/**
 * Created by dewmal on 8/24/16.
 */
@Entity("grn")
public class GrnModel {

    @Id
    private ObjectId id;

    private String code;
    private String supplierCode;
    private Date receivedTime;
    private Date finishedTime;
    private boolean finished;

    @PrePersist
    void prePersist() {
        receivedTime = new Date();

    }

    public Date getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(Date finishedTime) {
        this.finishedTime = finishedTime;
    }

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

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public Date getReceivedTime() {
        return receivedTime;
    }

    public void setReceivedTime(Date receivedTime) {
        this.receivedTime = receivedTime;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "GrnModel{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", supplierCode='" + supplierCode + '\'' +
                ", receivedTime=" + receivedTime +
                ", finishedTime=" + finishedTime +
                ", finished=" + finished +
                '}';
    }
}
