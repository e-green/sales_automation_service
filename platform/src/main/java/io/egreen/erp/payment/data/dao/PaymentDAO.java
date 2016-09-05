package io.egreen.erp.payment.data.dao;

import io.egreen.apistudio.datalayer.mongodb.dao.DAOController;
import io.egreen.erp.payment.data.entity.PaymentModel;

import java.util.List;

/**
 * Created by Pramode Wimukthi on 9/4/2016.
 */
public interface PaymentDAO extends DAOController<PaymentModel> {


    List<PaymentModel> getPaymentByOrderId(String orderId);

    List<PaymentModel> searchPayment(String payId);

    void updatePaymentStatus(PaymentModel paymentModel);
}
