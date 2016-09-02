package io.egreen.erp.gsn.data.dao.impl;

import com.mongodb.WriteResult;
import io.egreen.apistudio.datalayer.mongodb.dao.impl.AbstractDAOController;
import io.egreen.erp.gsn.data.dao.OrderItemDAOController;
import io.egreen.erp.gsn.data.entity.OrderItem;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import java.util.List;

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

public class OrderItemDAOContollerImpl extends AbstractDAOController<OrderItem> implements OrderItemDAOController {

    public OrderItemDAOContollerImpl() {
        super(OrderItem.class);
    }

    @Override
    public void remove(String code) {
        Query<OrderItem> query = getQuery();
        query.filter("code =", code);


        WriteResult delete = getDatastore().delete(query);


    }

    @Override
    public List<OrderItem> getAllOrderItemsFromGSNOrderCode(String gsnCode) {
        Query<OrderItem> query = getQuery();
        query.filter("orderCode =", gsnCode);
        return query.asList();
    }

    @Override
    public Object setDiscount(String orderItemCode, double discount, boolean isValue) {
        Query<OrderItem> orderItemQuery = getQuery();
        orderItemQuery.filter("code =", orderItemCode);

        UpdateOperations<OrderItem> updateOperations = getDatastore().createUpdateOperations(entityClass);

        if (!isValue) {
            updateOperations.set("unitDiscount", discount);
            updateOperations.set("totalDiscount", 0);
        } else {
            updateOperations.set("totalDiscount", discount);
            updateOperations.set("unitDiscount", 0);
        }


        getDatastore().update(orderItemQuery, updateOperations);

        return true;
    }
}
