package io.egreen.erp.transaction.api;


import io.egreen.erp.transaction.service.TransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

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

@Api(value = "/transaction", description = "All Transaction are handle hear")
@Path("/transaction")
public class TransactionController {

    @Inject
    private TransactionService transactionService;


    @ApiOperation(value = "/save Transaction ", notes = "Save Transaction Object")
    @POST
    @Path("/save")
    public boolean create(@QueryParam("orderId") String orderId, @QueryParam("amount") double amount,@QueryParam("typeId") String typeId) {
        return transactionService.createGSNOrderTransaction(orderId,amount,typeId);

    }

}
