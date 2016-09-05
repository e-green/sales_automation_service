package io.egreen.erp.transactiontype.service;

import io.egreen.erp.transactiontype.data.dao.TransactionTypeDAO;
import io.egreen.erp.transactiontype.data.entity.TransactionTypeModel;

import javax.inject.Inject;

/**
 * Created by Pramode Wimukthi on 9/5/2016.
 */
public class TransactionTypeService {

    @Inject
    private TransactionTypeDAO transactionTypeDAO;

    public boolean newTransactionType(TransactionTypeModel typeModel) {
        if (typeModel != null) {
            transactionTypeDAO.create(typeModel);
            return true;
        }
        return false;
    }
}
