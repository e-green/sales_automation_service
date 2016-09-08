package io.egreen.erp.cheque.data.dao.impl;

import com.mongodb.WriteResult;
import io.egreen.apistudio.datalayer.mongodb.dao.impl.AbstractDAOController;
import io.egreen.erp.cheque.data.dao.ChequeDAO;
import io.egreen.erp.cheque.data.dto.ChequeModel;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import java.util.List;

/**
 * Created by Pramode Wimukthi on 9/5/2016.
 */
public class ChequeDAOImpl extends AbstractDAOController<ChequeModel> implements ChequeDAO {

    public ChequeDAOImpl() {
        super(ChequeModel.class);
    }

    @Override
    public List<ChequeModel> searchCheque(String cheqNo) {
        Query<ChequeModel> query = getQuery();
        query.filter("cheqDate", "2016-09-06");
        query.filter("inOut", "in");
        return query.asList();
    }

    @Override
    public boolean updateCheque(ChequeModel chequeModel) {
        Query<ChequeModel> query = getQuery();
        query.filter("cheqNo", chequeModel.getCheqNo());
        UpdateOperations<ChequeModel> updateOperations = getDatastore().createUpdateOperations(ChequeModel.class);

        updateOperations.set("cheqNo", chequeModel.getCheqNo());
        updateOperations.set("cheqBank", chequeModel.getCheqBank());
        updateOperations.set("cheqDate", chequeModel.getCheqDate());
        updateOperations.set("cheqAmount", chequeModel.getCheqAmount());
        updateOperations.set("inOut", chequeModel.getInOut());

        getDatastore().update(query, updateOperations);
        return true;

    }

    @Override
    public WriteResult deleteCheque(String cheqNo) {
        Query<ChequeModel> query = getQuery();
        query.filter("cheqNo", cheqNo);
        return getDatastore().delete(query);
    }

    @Override
    public List<ChequeModel> todayIn(String date) {
        Query<ChequeModel> query = getQuery();
        query.filter("cheqDate", date);
        query.filter("inOut", "in");
        return query.asList();
    }

}
