package io.egreen.erp.supplier.api;

import io.egreen.erp.product.data.entity.Product;
import io.egreen.erp.supplier.data.entity.Supplier;
import io.egreen.erp.supplier.service.SupplierService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by dewmal on 8/24/16.
 */
@Api(value = "/supplier", description = "Supplier Details Controller")
@Path("/supplier")
public class SupplierController {

    @Inject
    private SupplierService supplierService;

    @ApiOperation(value = "Save Supplier Details",
            notes = "Save All Supplier details unique key is code",
            response = Object.class,
            responseReference = "Return supplier system generated code",
            responseContainer = "Single")
    @Path("/save")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Object save(Supplier supplier) {
        return supplierService.save(supplier);
    }


    @ApiOperation(value = "Get Supplier Details")
    @Path("/get/{code}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Supplier get(@PathParam("code") String code) {
        return supplierService.get(code);
    }

    @ApiOperation(value = "Get All Supplier Details")
    @Path("/getAll/{offset}/{limit}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Supplier> getAll(@PathParam("offset") int offset, @PathParam("limit") int limit) {
        return supplierService.getAll(offset, limit);
    }
}
