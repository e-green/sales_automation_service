package io.egreen.erp.credit.data.dao.impl;

import com.mongodb.WriteResult;
import io.egreen.apistudio.datalayer.mongodb.dao.impl.AbstractDAOController;
import io.egreen.erp.credit.data.dao.CreditDAO;
import io.egreen.erp.credit.data.dto.CreditModel;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import java.util.List;

/**
 * Created by Pramode Wimukthi on 9/6/2016.
 */
public class CreditDAOImpl extends AbstractDAOController<CreditModel> implements CreditDAO {

    public CreditDAOImpl() {
        super(CreditModel.class);
    }

    @Override
    public boolean updateCredit(CreditModel creditModel) {
        Query<CreditModel> query = getQuery();
        query.filter("creditId", creditModel.getCreditId());

        UpdateOperations<CreditModel> updateOperations = getDatastore().createUpdateOperations(CreditModel.class);
        updateOperations.set("lastDigit", creditModel.getLastDigit());
        updateOperations.set("creditName", creditModel.getCreditName());
        updateOperations.set("amount", creditModel.getAmount());

        getDatastore().update(query, updateOperations);
        return true;
    }

    @Override
    public List<CreditModel> searchCredit(String creditId) {
        Query<CreditModel> query = getQuery();
        query.filter("creditId", creditId);
        return query.asList();
    }

    @Override
    public WriteResult deleteCredit(String creditId) {
        Query<CreditModel> query = getQuery();
        query.filter("creditId", creditId);
        return getDatastore().delete(query);
    }
}
