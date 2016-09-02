package io.egreen.erp.gsn.api;

import io.egreen.erp.grn.data.entity.BatchModel;
import io.egreen.erp.gsn.data.entity.OrderItem;
import io.egreen.erp.gsn.service.OrderItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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

@Api("/orderItem")
@Path("/orderItem")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrderItemContoller {
    private static final Logger LOGGER = LogManager.getLogger(OrderItemContoller.class);

    @Inject
    private OrderItemService orderItemService;


    @ApiOperation("Get Product In Order  By Product code ")
    @GET
    @Path("/get/{code}")
    public OrderItem get(@PathParam("code") String code) {
        return orderItemService.get(code);
    }

    @ApiOperation(value = "Delete Product order item Details By order item code "

            , notes = "* DELETE Order Item\n" +
            "     * You cannot delete/remove closed orders items.\n" +
            "     * You cannot delete/remove non exists order items."
    )
    @DELETE
    @Path("/delete/{code}")
    public Object delete(@PathParam("code") String code) {
        return orderItemService.remove(code);
    }


    @ApiOperation("Create Order item  for GSN ")
    @POST
    @Path("/save")
    public Object save(OrderItem batchModel) {
        return orderItemService.save(batchModel);
    }

    @ApiOperation(value = "Create Order item  for GSN ", notes = "" +
            "Get added items as Order item" +
            "Get ")
    @POST
    @Path("/saveOnGsn")
    public Object saveOnGsn(
            @QueryParam("gsnCode")
                    String gsnCode,
            @QueryParam("itemCode")
                    String itemCode,
            @QueryParam("quantity")
                    long orderQuantity,
            @QueryParam("discount")
                    double discount
    ) {
        return orderItemService.createOrderItems(itemCode, gsnCode, orderQuantity, discount);
    }

    @ApiOperation(value = "Set Item discount for the order item ", notes = "" +
            "Added item Discount ")
    @POST
    @Path("/setItemDiscount")
    public Object setDiscount(@QueryParam("orderItemCode") String orderItemCode, @QueryParam("discount") double discount, @QueryParam("isValue") boolean isValue) {
        return orderItemService.setDiscount(orderItemCode, discount, isValue);
    }


}
