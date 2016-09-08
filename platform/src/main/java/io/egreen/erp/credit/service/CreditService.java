package io.egreen.erp.credit.service;

import com.mongodb.WriteResult;
import io.egreen.apistudio.bootstrap.utill.IDUtilty;
import io.egreen.erp.credit.data.dao.CreditDAO;
import io.egreen.erp.credit.data.dto.CreditModel;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Pramode Wimukthi on 9/6/2016.
 */
public class CreditService {

    IDUtilty idUtilty = new IDUtilty();
    @Inject
    private CreditDAO creditDAO;


    public boolean newCredit(CreditModel creditModel) {
        String creditId = idUtilty.getKey(System.nanoTime());
        if (creditModel != null) {
            creditModel.setCreditId(creditId);
            creditDAO.create(creditModel);
            return true;
        }
        return false;
    }

    public boolean updateCredit(CreditModel creditModel) {
        return creditDAO.updateCredit(creditModel);
    }


    public List<CreditModel> searchCredit(String creditId) {
        return creditDAO.searchCredit(creditId);
    }

    public WriteResult deleteCredit(String creditId) {
        return creditDAO.deleteCredit(creditId);
    }
}
