package io.egreen.erp.gsn.service;

import io.egreen.apistudio.bootstrap.msg.ReseponseMessage;
import io.egreen.erp.grn.data.dao.BatchDAOController;
import io.egreen.erp.grn.data.entity.BatchModel;
import io.egreen.erp.gsn.data.dao.GSNDAOController;
import io.egreen.erp.gsn.data.dao.OrderItemDAOController;
import io.egreen.erp.gsn.data.entity.GSNModel;
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

    @Inject
    private GSNDAOController gsndaoController;


    public OrderItem get(String code) {
        return orderItemDAOController.get(code);
    }


    /**
     * DELETE Order Item
     * <p>
     * You cannot delete/remove closed orders items.
     * You cannot delete/remove non exists order items.
     *
     * @param code
     * @return
     */
    public Object remove(String code) {


        OrderItem orderItem = orderItemDAOController.get(code);

        if (orderItem != null) {

            GSNModel gsnModel = gsndaoController.get(orderItem.getOrderCode());
            if (gsnModel != null && !gsnModel.isClosed()) {

                LOGGER.info(orderItem);

                BatchModel batchModel = batchDAOController.get(orderItem.getBatchCode());

                batchModel.setReservedUnits(batchModel.getReservedUnits() - orderItem.getNumberOfUnits());
                batchModel.setAvailableUnits(batchModel.getAvailableUnits() + orderItem.getNumberOfUnits());

                batchDAOController.updateAvailableUnits(batchModel);
                orderItemDAOController.remove(code);
            } else {
                return new ReseponseMessage(ReseponseMessage.Type.ERROR, "You cannot remove this Order item, GSN order is closed");
            }
        } else {
            return new ReseponseMessage(ReseponseMessage.Type.ERROR, "There are no valid Order item");
        }
        return new ReseponseMessage(ReseponseMessage.Type.SUCCESS, "Delete success");
    }

    public Object save(OrderItem batchModel) {
        orderItemDAOController.create(batchModel);
        return new ReseponseMessage(ReseponseMessage.Type.SUCCESS, "Save success");
    }

    public Object createOrderItems(String itemCode, String orderCode, long orderQuantity, double discount) {
        List<OrderItem> orderItems = new ArrayList<>();
        List<BatchModel> batchModels = batchDAOController.getNonEmptyBatchByItemCode(itemCode);
//        for (BatchModel batchModel : batchModels) {
//            LOGGER.info(batchModel);
//        }
        LOGGER.info(batchModels);


        GSNModel gsnModel = gsndaoController.get(orderCode);

//        long remainOrderQunatity = orderQuantity;

        if (gsnModel != null && !gsnModel.isClosed()) {

            for (int i = 0; i < batchModels.size() && orderQuantity > 0; i++) {
                BatchModel batchModel = batchModels.get(i);

//            LOGGER.info(orderQuantity);

                OrderItem orderItem = new OrderItem();
                if (orderQuantity < batchModel.getAvailableUnits()) {
                    orderItem.setNumberOfUnits(orderQuantity);

                    batchModel.setReservedUnits(batchModel.getReservedUnits() + orderQuantity);
                    batchModel.setAvailableUnits(batchModel.getAvailableUnits() - orderQuantity);
                } else {
//                throw new Exception("Not impliemtnted please methana karana oni order eka quantity ekata wada batcfh eka adui nan anik batch walin aragena purwana eka. ")
                    long availableQuantity = orderQuantity - batchModel.getAvailableUnits();
                    orderItem.setNumberOfUnits(batchModel.getAvailableUnits());

                    batchModel.setAvailableUnits(0);
                    batchModel.setReservedUnits(batchModel.getReservedUnits() + batchModel.getAvailableUnits());
                }

                // Set Unique code for order item model
                orderItem.setCode(getUniqueId(System.currentTimeMillis()) + itemCode);
                orderItem.setOrderCode(orderCode);

                orderItem.setItemCode(itemCode);
                orderItem.setBatchCode(batchModel.getCode());
                orderItem.setUnit(batchModel.getUnit());
                orderItem.setUnitPrice(batchModel.getUnitSellingPrice());
                orderItem.setUnitDiscount(discount);

                orderItemDAOController.create(orderItem);

                // Update Batch For Available units
                batchDAOController.updateAvailableUnits(batchModel);

                orderItems.add(orderItem);

                orderQuantity = orderQuantity - orderItem.getNumberOfUnits();
            }
        } else {
            return new ReseponseMessage(ReseponseMessage.Type.ERROR, "Invalid order, Order is null or closed");
        }


        return orderItems;
    }

    /**
     * @param key
     * @return
     */
    private String getUniqueId(long key) {
        return new Hashids(System.nanoTime() + "").encode(key);
    }

    /**
     * Close Order Items in GSN Order
     *
     * @param gsnCode
     * @return
     */
    public List<OrderItem> closeOrderItems(String gsnCode) {
        List<OrderItem> orderItems = orderItemDAOController.getAllOrderItemsFromGSNOrderCode(gsnCode);
        for (OrderItem orderItem : orderItems) {
            BatchModel batchModel = batchDAOController.get(orderItem.getBatchCode());
            batchModel.setReservedUnits(batchModel.getReservedUnits() - orderItem.getNumberOfUnits());
            batchDAOController.updateBatchQuantity(batchModel);
        }
        LOGGER.info(orderItems);
        return orderItems;
    }

    /**
     * Set Discount To Order Items
     *
     * @param orderItemCode
     * @param discount
     * @param isValue
     * @return
     */
    public Object setDiscount(String orderItemCode, double discount, boolean isValue) {
        boolean setDiscountIsOk = (boolean) orderItemDAOController.setDiscount(orderItemCode, discount, isValue);
        return orderItemDAOController.get(orderItemCode);
    }

    public List<OrderItem> getOrderItems(String code) {
        return orderItemDAOController.getAllOrderItemsFromGSNOrderCode(code);
    }
}
