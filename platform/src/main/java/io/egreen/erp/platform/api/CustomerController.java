package io.egreen.erp.platform.api;

import com.sun.org.apache.regexp.internal.RE;
import io.egreen.erp.platform.db.entity.Customer;
import io.egreen.erp.platform.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by dewmal on 8/23/16.
 */
@Api(
        value = "/customer", description = "Customer Handling module"
)
@Path("/customer")
public class CustomerController {
    private static final Logger LOGGER = LogManager.getLogger(CustomerController.class);


    @Inject
    private CustomerService customerService;


    @Path("/save/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Save Customer Details",
            notes = "Need customer unique identifier with details",
            response = Object.class,
            responseReference = "Return Key after save customer object",
            responseContainer = "Single")
    @Consumes(MediaType.APPLICATION_JSON)
    public Object save(Customer customer) {
        LOGGER.debug(customer);
        return customerService.saveCustomer(customer);
    }


    @Path("/view/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Get Unique Customer Details by key",
            notes = "Need customer unique identifier",
            response = Customer.class,
            responseContainer = "Single")
    public Customer get(@PathParam("id") String id) {
        return new Customer();
    }

}
