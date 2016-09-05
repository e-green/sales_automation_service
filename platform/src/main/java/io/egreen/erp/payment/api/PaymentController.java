package io.egreen.erp.payment.api;


import io.egreen.erp.payment.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;

/**
 * Created by Pramode Wimukthi on 9/4/2016.
 */
@Path("/payment")
@Api(
        value = "/payment",
        description = "controller for the All Payment"
)
@Produces("application/json")
@Consumes("application/json")
public class PaymentController {

    private static final Logger LOGGER = LogManager.getLogger(PaymentController.class);
    @Inject
    private PaymentService paymentService;

//
//    @POST
//    @Path("/save")
//    @ApiOperation(
//            value = "add new payment",
//            notes = "Add New Payment to the DataBase"
//    )
//    public boolean newPayment(@QueryParam("orderId") String orderId, @QueryParam("amount") double amount) {
//        LOGGER.info(orderId + " " + amount);
//        return paymentService.newPayment(orderId, amount);
//    }
}
