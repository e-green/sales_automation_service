package io.egreen.erp.grn.data.entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

/**
 * Created by dewmal on 8/24/16.
 */
@Entity("batch")
@Indexes(
        {
                @Index(value = "item", fields = @Field("itemCode")),
                @Index(value = "grn", fields = @Field("grnCode"))
        }
)
public class BatchModel {

    @Id
    private ObjectId id;
    private String code;
    private String itemCode;
    private String grnCode;
    private double unitSellingPrice;
    private double unitBuyingPrice;
    private long numberOfUnits;
    private long availableUnits;
    private String unit;

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

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getGrnCode() {
        return grnCode;
    }

    public void setGrnCode(String grnCode) {
        this.grnCode = grnCode;
    }

    public double getUnitSellingPrice() {
        return unitSellingPrice;
    }

    public void setUnitSellingPrice(double unitSellingPrice) {
        this.unitSellingPrice = unitSellingPrice;
    }

    public double getUnitBuyingPrice() {
        return unitBuyingPrice;
    }

    public void setUnitBuyingPrice(double unitBuyingPrice) {
        this.unitBuyingPrice = unitBuyingPrice;
    }

    public long getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(long numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public long getAvailableUnits() {
        return availableUnits;
    }

    public void setAvailableUnits(long availableUnits) {
        this.availableUnits = availableUnits;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "BatchModel{" +
                "id=" + code +
                ", code='" + code + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", grnCode='" + grnCode + '\'' +
                ", unitSellingPrice=" + unitSellingPrice +
                ", unitBuyingPrice=" + unitBuyingPrice +
                ", numberOfUnits=" + numberOfUnits +
                ", availableUnits=" + availableUnits +
                ", unit='" + unit + '\'' +
                '}';
    }
}
