package io.egreen.erp.product.api;

import io.egreen.erp.product.data.entity.Product;
import io.egreen.erp.product.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by dewmal on 8/24/16.
 */
@Api(
        value = "/product",
        description = "controller for Item Products can be manage any sale good"
)
@Path("/product")
public class ProductsController {


    @Inject
    private ProductService productService;


    @ApiOperation(value = "Get Product Details",
            notes = "By Product code",
            response = Product.class,
            responseReference = "Return product by code",
            responseContainer = "Single")
    @GET
    @Path("/get/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product get(@PathParam("code") String code) {
        Product product = null;
        if (code != null) {
            product = productService.get(code);
        } else {
            product = new Product();
        }
        return product;
    }


    @ApiOperation(value = "Get All Product Details",
            notes = "Get By limit and offset",
            response = Product.class,
            responseReference = "Return product by code",
            responseContainer = "Single")
    @GET
    @Path("/getAll/{offset}/{limit}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAll(@PathParam("offset") int offset, @PathParam("limit") int limit) {
        return productService.getAll(offset, limit);
    }


    @ApiOperation(value = "Save Product Details",
            notes = "Save All Product details unique key is code",
            response = Product.class,
            responseReference = "Return product system generated code",
            responseContainer = "Single")
    @Path("/save")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Object save(Product product) {
        return productService.save(product);
    }

}
