package io.egreen.erp.gsn.api;

import io.egreen.erp.grn.data.entity.GrnModel;
import io.egreen.erp.gsn.data.entity.GSNModel;
import io.egreen.erp.gsn.service.GSNService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
@Api("/gsn")
@Path("/gsn")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GSNController {

    @Inject
    private GSNService gsnService;


    @ApiOperation("Save GSN Model")
    @Path("/save")
    @POST
    public Object createGRN(GSNModel gsn) {
        return gsnService.create(gsn);
    }


    @ApiOperation("Finish GSN Model")
    @Path("/finish")
    @POST
    public Object finishGRN(GSNModel gsnModel) {
        return gsnService.finish(gsnModel);
    }


    @ApiOperation("Get GSN Model By code")
    @GET
    @Path("/get/{code}")
    public GSNModel get(@PathParam("code") String code) {
        return gsnService.get(code);
    }


    @ApiOperation(value = "Get All Closed orders by customer ID")
    @GET
    @Path("/getClosedOrdersByCustomerName")
    public Object getAllClosedOrders(@QueryParam("customerCoder") String customerCode) {
        return gsnService.getAllCustomerClosedOrder(customerCode);
    }

    @GET
    @Path("/salesbydate")
    @ApiOperation(
            value = "sales by date",
            notes = "Get Sales by date "
    )
    public Object salesByDate(@QueryParam("finishTime") String finishTime, @QueryParam("offset") int offset, @QueryParam("limit") int limit) {
        return gsnService.getSalesByDate(finishTime, offset, limit);
    }
}
