package io.egreen.erp.credit.data.dao;

import com.mongodb.WriteResult;
import io.egreen.apistudio.datalayer.mongodb.dao.DAOController;
import io.egreen.erp.credit.data.dto.CreditModel;

import java.util.List;

/**
 * Created by Pramode Wimukthi on 9/6/2016.
 */
public interface CreditDAO extends DAOController<CreditModel> {

    boolean updateCredit(CreditModel creditModel);

    List<CreditModel> searchCredit(String creditId);

    WriteResult deleteCredit(String creditId);
}
