package io.egreen.erp.grn.api;

import io.egreen.erp.grn.data.entity.GrnModel;
import io.egreen.erp.grn.serivce.GRNService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by dewmal on 8/24/16.
 */
@Api("/grn")
@Path("/grn")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GRNController {

    @Inject
    private GRNService grnService;


    @ApiOperation("Save GRN Model")
    @Path("/save")
    @POST
    public Object createGRN(GrnModel grnModel) {
        return grnService.create(grnModel);
    }


    @ApiOperation("Save GRN Model")
    @Path("/finish")
    @POST
    public Object finishGRN(GrnModel grnModel) {
        return grnService.finish(grnModel);
    }


    @ApiOperation("Get GRN Model By code")
    @GET
    @Path("/get/{code}")
    public GrnModel get(@PathParam("code") String code) {
        return grnService.get(code);
    }

}
