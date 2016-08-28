package io.egreen.erp.gsn.service;

import io.egreen.erp.grn.data.dao.BatchDAOController;
import io.egreen.erp.grn.data.entity.BatchModel;
import io.egreen.erp.gsn.data.dao.OrderItemDAOController;
import io.egreen.erp.gsn.data.entity.OrderItem;
import io.egreen.erp.product.data.dao.ProductDAOController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hashids.Hashids;

import javax.inject.Inject;
import java.util.ArrayList;
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

public class OrderItemService {


    private static final Logger LOGGER = LogManager.getLogger(OrderItemService.class);

    @Inject
    private OrderItemDAOController orderItemDAOController;

    @Inject
    private BatchDAOController batchDAOController;

    @Inject
    private ProductDAOController productDAOController;


    public OrderItem get(String code) {
        return null;
    }

    public Object remove(String code) {
        return null;
    }

    public Object save(OrderItem batchModel) {
        orderItemDAOController.create(batchModel);
        return null;
    }

    public List<OrderItem> createOrderItems(String itemCode, long orderQuantity) {
        List<OrderItem> orderItems = new ArrayList<>();
        List<BatchModel> batchModels = batchDAOController.getNonEmptyBatchByItemCode(itemCode);
        for (int i = 0; i < batchModels.size(); i++) {
            BatchModel batchModel = batchModels.get(i);
            OrderItem orderItem = new OrderItem();
            if (orderQuantity < batchModel.getAvailableUnits()) {
                orderItem.setItemCode(itemCode);
                orderItem.setBatchCode(batchModel.getCode());
                orderItem.setNumberOfUnits(orderQuantity);
            } else {
                throw new Exception("Not impliemtnted please methana karana oni order eka quantity ekata wada batcfh eka adui nan anik batch walin aragena purwana eka. ")
            }

            // Set Unique code for order item model
            orderItem.setCode(getUniqueId(System.currentTimeMillis()) + itemCode);
            orderItemDAOController.create(orderItem);

            // Update Batch For Available units
            batchDAOController.updateAvailableUnits(batchModel.getCode(), batchModel.getAvailableUnits() - orderQuantity, orderQuantity);
        }


        LOGGER.info(batchModels);


        return orderItems;
    }

    private String getUniqueId(long key) {
        return new Hashids(System.nanoTime() + "").encode(key);
    }
}
