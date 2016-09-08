package io.egreen.erp.cheque.api;

import com.mongodb.WriteResult;
import io.egreen.erp.cheque.data.dto.ChequeModel;
import io.egreen.erp.cheque.service.ChequeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

/**
 * Created by Pramode Wimukthi on 9/5/2016.
 */
@Path("/cheque")
@Api(
        value = "/cheque", description = "cheque Handling module"
)
@Produces("application/json")
@Consumes("application/json")
public class ChequeController {

    @Inject
    private ChequeService chequeService;

    @POST
    @Path("/save")
    @ApiOperation(
            value = "add new Cheque",
            notes = "Add new Cheque to the Database"
    )
    public boolean newCheque(ChequeModel chequeModel) {
        return chequeService.newCheque(chequeModel);
    }


    @POST
    @Path("/update")
    @ApiOperation(
            value = "update Cheque",
            notes = "Update Cheque from Database"
    )
    public boolean updateCheque(ChequeModel chequeModel) {
        return chequeService.updateCheque(chequeModel);
    }


    @GET
    @Path("/search")
    @ApiOperation(
            value = "search Cheque",
            notes = "Search Cheque from database"
    )
    public Object searchCheque(@QueryParam("cheqNo") String cheqNo) {
        return chequeService.searchCheque(cheqNo);
    }

    @DELETE
    @Path("/delete")
    @ApiOperation(
            value = "delete Cheque",
            notes = "Delete Cheque from database"
    )
    public WriteResult deleteCheque(@QueryParam("cheqNo")String cheqNo) {
        return chequeService.deleteCheque(cheqNo);
    }

    @GET
    @Path("/todayin")
    @ApiOperation(
            value = " today in Cheque",
            notes = "List the Today in(Diposit) Cheque"
    )
    public Object todayIn(@QueryParam("cheqDate")String date){
        return chequeService.todayIn(date);
    }


}
