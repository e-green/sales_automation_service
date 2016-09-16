package io.egreen.erp.sale.api;

import io.egreen.erp.sale.data.dto.SaleModel;
import io.egreen.erp.sale.service.SaleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;


/**
 * Created by Pramode Wimukthi on 9/16/2016.
 */
@Path("/sale")
@Api(
        value = "/sale",
        description = "Sale Controller"
)
@Produces("application/json")
@Consumes("application/json")
public class SaleApiController {

    @Inject
    private SaleService saleService;

    @Path("/save")
    @POST
    @ApiOperation(
            value = "save Sale",
            notes = "Save Sale to the Databse"
    )
    public boolean newSale(SaleModel saleModel){
        return saleService.newSale(saleModel);
    }


    @Path("/getAll")
    @GET
    @ApiOperation(
            value = "get all Sales",
            notes = "get All Sales From Database you should enter ofset and limit"
    )
    public Object getAllSales(@QueryParam("offset")int offset,@QueryParam("limit")int limit){
       return saleService.getAllSales(offset,limit);
    }



}
