package io.egreen.erp.transaction.data.dao.impl;

import io.egreen.apistudio.datalayer.mongodb.dao.impl.AbstractDAOController;
import io.egreen.erp.transaction.data.dao.TransactionDAO;
import io.egreen.erp.transaction.data.entity.TransactionModel;
import org.mongodb.morphia.query.Query;

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
 * Created by dewmal on 9/3/16.
 */

public class TransactionDAOImpl extends AbstractDAOController<TransactionModel> implements TransactionDAO {

    public TransactionDAOImpl() {
        super(TransactionModel.class);
    }

    @Override
    public List<TransactionModel> checkTransaction(String orderId, String payId) {
        Query<TransactionModel> query = getQuery();
        query.filter("orderId",orderId);
        query.filter("payId",payId);
        return query.asList();
    }
}
