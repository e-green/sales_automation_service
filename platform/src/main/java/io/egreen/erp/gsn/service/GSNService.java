package io.egreen.erp.gsn.service;

import io.egreen.apistudio.bootstrap.msg.ReseponseMessage;
import io.egreen.erp.grn.data.entity.GrnModel;
import io.egreen.erp.gsn.data.dao.GSNDAOController;
import io.egreen.erp.gsn.data.dao.OrderItemDAOController;
import io.egreen.erp.gsn.data.entity.GSNModel;
import io.egreen.erp.gsn.data.entity.OrderItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.types.ObjectId;
import org.hashids.Hashids;
import org.mongodb.morphia.Key;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

public class GSNService {

    private static final Logger LOGGER = LogManager.getLogger(GSNService.class);

    @Inject
    private GSNDAOController gsndaoController;

    @Inject
    private OrderItemService orderItemService;


    /**
     * Create GSN Model
     *
     * @param gsnModel
     * @return
     */
    public Object create(GSNModel gsnModel) {
        Hashids hashids = new Hashids(System.nanoTime() + "");
        String code = hashids.encode(System.nanoTime()) + gsnModel.getEmployeeCode();
        gsnModel.setCode(code);
        Key<GSNModel> grnModelKey = gsndaoController.create(gsnModel);
        ObjectId grnModelKeyId = (ObjectId) grnModelKey.getId();
        gsnModel.setId(grnModelKeyId);
        return gsnModel;
    }

    /**
     * @param gsnModel
     * @return
     */
    public Object finish(GSNModel gsnModel) {

        GSNModel gsnSavedModel = gsndaoController.get(gsnModel.getCode());

        if (gsnSavedModel != null && !gsnSavedModel.isClosed()) {
            List<OrderItem> orderItems = orderItemService.closeOrderItems(gsnModel.getCode());
            gsnModel.setOrderItems(orderItems);
            gsndaoController.closeOrder(gsnModel);
            return gsnModel;
        } else {
            LOGGER.warn("Try to close closed order");
            return new ReseponseMessage(ReseponseMessage.Type.ERROR, "Order is already closed");
        }
    }

    public GSNModel get(String code) {
        return null;
    }

    public Object getAllCustomerClosedOrder(String customerCode) {
        List<GSNModel> gsnModels = gsndaoController.getOrderByCustomerCode(customerCode, true);
        return gsnModels;
    }
}
