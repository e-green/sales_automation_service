package io.egreen.erp.gsn.api;

import io.egreen.erp.grn.data.entity.GrnModel;
import io.egreen.erp.gsn.data.entity.GSNModel;
import io.egreen.erp.gsn.service.GSNService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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


}
