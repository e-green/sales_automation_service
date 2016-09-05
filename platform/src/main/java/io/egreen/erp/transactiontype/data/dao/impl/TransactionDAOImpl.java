package io.egreen.erp.transactiontype.data.dao.impl;

import io.egreen.apistudio.datalayer.mongodb.dao.impl.AbstractDAOController;
import io.egreen.erp.transactiontype.data.dao.TransactionTypeDAO;
import io.egreen.erp.transactiontype.data.entity.TransactionTypeModel;

/**
 * Created by Pramode Wimukthi on 9/5/2016.
 */
public class TransactionDAOImpl extends AbstractDAOController<TransactionTypeModel> implements TransactionTypeDAO{

    public TransactionDAOImpl() {
        super(TransactionTypeModel.class);
    }
}
