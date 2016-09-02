package io.egreen.erp.gsn.data.dao.impl;

import io.egreen.apistudio.datalayer.mongodb.dao.impl.AbstractDAOController;
import io.egreen.erp.gsn.data.dao.GSNDAOController;
import io.egreen.erp.gsn.data.entity.GSNModel;
import io.egreen.erp.gsn.data.entity.OrderItem;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import java.util.Date;
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

public class GSNDAOContollerImpl extends AbstractDAOController<GSNModel> implements GSNDAOController {
    public GSNDAOContollerImpl() {
        super(GSNModel.class);
    }

    @Override
    public List<GSNModel> getOrderByCustomerCode(String customerCode, boolean isClosed) {
        Query<GSNModel> query = getQuery();
        query.filter("customerCode =", customerCode);
        query.filter("isClosed =", isClosed);
        return query.asList();
    }

    @Override
    public void closeOrder(GSNModel gsnModel) {

        Query<GSNModel> filter = getQuery().filter("code =", gsnModel.getCode());

        UpdateOperations<GSNModel> updateOperations = getDatastore().createUpdateOperations(entityClass);

        updateOperations.set("isClosed", true);
        updateOperations.set("finishTime", new Date());

        updateOperations.set("orderItems", gsnModel.getOrderItems());

        getDatastore().update(filter, updateOperations);
    }
}
