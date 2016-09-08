package io.egreen.erp.credit.api;

import com.mongodb.WriteResult;

import io.egreen.erp.credit.data.dto.CreditModel;
import io.egreen.erp.credit.service.CreditService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

/**
 * Created by Pramode Wimukthi on 9/6/2016.
 */
@Path("/credit")
@Api(
        value = "/credit", description = "credit Handling module"
)
@Produces("application/json")
@Consumes("application/json")
public class CreditController {

    @Inject
    private CreditService creditService;

    @POST
    @Path("/save")
    @ApiOperation(
            value = "add new Credit",
            notes = "Add new Credit to the Database"
    )
    public boolean newCredit(CreditModel creditModel) {
        return creditService.newCredit(creditModel);
    }


    @POST
    @Path("/update")
    @ApiOperation(
            value = "update Credit",
            notes = "Update Credit from Database"
    )
    public boolean updateCredit(CreditModel creditModel) {
        return creditService.updateCredit(creditModel);
    }


    @GET
    @Path("/search")
    @ApiOperation(
            value = "search Credit",
            notes = "Search Credit from database"
    )
    public Object searchCredit(@QueryParam("creditId") String creditId) {
        return creditService.searchCredit(creditId);
    }

    @DELETE
    @Path("/delete")
    @ApiOperation(
            value = "delete Credit",
            notes = "Delete Credit from database"
    )
    public WriteResult deleteCredit(@QueryParam("creditId")String creditId) {
        return creditService.deleteCredit(creditId);
    }

}
