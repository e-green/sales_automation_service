package io.egreen.erp.gsn.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Copyright (c) E-Green. (http://www.egreen.io) All Rights Reserved.
 * <p>
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * <p>
 * Created by dewmal on 8/27/16.
 */

@Entity("orderItem")
public class OrderItem {


    @Id
    @JsonIgnore
    private ObjectId id;
    private String code;
    private String itemCode;
    private String orderCode;
    private String batchCode;
    private String unit;
    private long numberOfUnits;
    private double unitPrice;
    private double unitDiscount;
    private double totalDiscount;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
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

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public long getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(long numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getUnitDiscount() {
        return unitDiscount;
    }

    public void setUnitDiscount(double unitDiscount) {
        this.unitDiscount = unitDiscount;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", unit='" + unit + '\'' +
                ", numberOfUnits=" + numberOfUnits +
                ", unitPrice=" + unitPrice +
                ", unitDiscount=" + unitDiscount +
                ", totalDiscount=" + totalDiscount +
                '}';
    }
}
