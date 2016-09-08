package io.egreen.erp.grn.api;

import io.egreen.erp.grn.data.entity.BatchModel;
import io.egreen.erp.grn.serivce.ItemBatchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
 * Created by dewmal on 8/24/16.
 */

@Api("/batch")
@Path("/batch")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BatchController {



    @Inject
    private ItemBatchService itemBatchService;

    @ApiOperation("Get Product batch Details By Batch code ")
    @GET
    @Path("/get/{code}")
    public BatchModel get(@PathParam("code") String code) {
        return itemBatchService.get(code);
    }

    @ApiOperation("Delete Product batch Details By Batch code ")
    @DELETE
    @Path("/delete/{code}")
    public Object delete(@PathParam("code") String code) {
        return itemBatchService.remove(code);
    }



    @ApiOperation("Create Products for GRN ")
    @POST
    @Path("/save")
    public Object save(BatchModel batchModel) {
        return itemBatchService.save(batchModel);
    }


    @Path("/availablebatch")
    @GET
    @ApiOperation(
            value = "get available batch",
            notes = "Get Available units from Database , You must pass 1 and 0 for this availableUnits parameter.0={empty},1={available}"
    )
    public Object availableBatch(@QueryParam("availableUnits")int availableUnits,@QueryParam("offset") int ofset, @QueryParam("limit") int limit) {
        return itemBatchService.availableBatch(availableUnits,ofset,limit);
    }

}
