package io.egreen.erp.transactiontype.api;

import io.egreen.erp.transactiontype.data.entity.TransactionTypeModel;
import io.egreen.erp.transactiontype.service.TransactionTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by Pramode Wimukthi on 9/5/2016.
 */
@Path("transactiontype")
@Api(
        value = "/transactiontype",
        description = "transactiontype Controller"
)
@Produces("application/json")
@Consumes("application/json")
public class TransactionTypeController {

    @Inject
    private TransactionTypeService transactionTypeService;


    @POST
    @Path("/save")
    @ApiOperation(
            value = "save transaction type",
            notes = "Save Transaction Type to database"
    )
    public boolean newTransactionType(TransactionTypeModel typeModel){
        return transactionTypeService.newTransactionType(typeModel);
    }
}
