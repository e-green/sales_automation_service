package io.egreen.erp.payment.service;

import io.egreen.apistudio.bootstrap.status.StatusMessage;
import io.egreen.apistudio.bootstrap.utill.IDUtilty;
import io.egreen.erp.payment.data.dao.PaymentDAO;
import io.egreen.erp.payment.data.entity.PaymentModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

/**
 * Created by Pramode Wimukthi on 9/4/2016.
 */
public class PaymentService {
    private static final Logger LOGGER = LogManager.getLogger(PaymentService.class);

    IDUtilty idUtilty = new IDUtilty();

    @Inject
    private PaymentDAO paymentDAO;


    public boolean newPayment(String orderId, double amount) {
        try {

            String paymentId = idUtilty.getKey(System.nanoTime());
            StatusMessage pendding = new StatusMessage(StatusMessage.Type.PENDDING);

            PaymentModel paymenyModel = new PaymentModel();
            LOGGER.info(paymenyModel);
            paymenyModel.setPayId("PAY001");
            paymenyModel.setOrderId(orderId);
            paymenyModel.setAmount(amount);
            paymenyModel.setStatus(pendding.getType().toString());


            paymentDAO.create(paymenyModel);
            LOGGER.info(paymentDAO.create(paymenyModel));
            return true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;

    }
}
