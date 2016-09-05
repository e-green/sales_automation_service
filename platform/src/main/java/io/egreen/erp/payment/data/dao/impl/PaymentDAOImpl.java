package io.egreen.erp.payment.data.dao.impl;

import io.egreen.apistudio.datalayer.mongodb.dao.impl.AbstractDAOController;
import io.egreen.erp.payment.data.dao.PaymentDAO;
import io.egreen.erp.payment.data.entity.PaymentModel;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import java.util.List;

/**
 * Created by Pramode Wimukthi on 9/4/2016.
 */
public class PaymentDAOImpl extends AbstractDAOController<PaymentModel> implements PaymentDAO {

    public PaymentDAOImpl() {
        super(PaymentModel.class);
    }


    @Override
    public List<PaymentModel> getPaymentByOrderId(String orderId) {
        Query<PaymentModel> query = getQuery();
        query.filter("orderId", orderId);
        return query.asList();
    }

    @Override
    public List<PaymentModel> searchPayment(String payId) {
        Query<PaymentModel> query = getQuery();
        query.filter("payId", payId);
        return query.asList();
    }

    @Override
    public void updatePaymentStatus(PaymentModel paymentModel) {
        Query<PaymentModel> query = getQuery();
        query.filter("payId =", paymentModel.getPayId());

        UpdateOperations<PaymentModel> updateOperations = getDatastore().createUpdateOperations(PaymentModel.class);

        updateOperations.set("status", paymentModel.getStatus());
        getDatastore().update(query, updateOperations);
    }
}
