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
@Produces("application/json")
@Consumes("application/json")
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


    @ApiOperation(
            value = "get all products",
            notes = "get All Product from Database"
    )
    @GET
    @Path("/getAll")
    public List<Product> getAll(@QueryParam("offset") int offset, @QueryParam("limit") int limit) {
        return productService.getAll(offset, limit);
    }


    @ApiOperation(
            value = "Save Product Details",
            notes = "Save All Product details unique key is code"
    )
    @Path("/save")
    @POST
    public boolean save(Product product) {
        return productService.save(product);
    }

}
