package io.egreen.erp.cheque.data.dao;

import com.mongodb.WriteResult;
import io.egreen.apistudio.datalayer.mongodb.dao.DAOController;
import io.egreen.erp.cheque.data.dto.ChequeModel;

import java.util.List;

/**
 * Created by Pramode Wimukthi on 9/5/2016.
 */
public interface ChequeDAO extends DAOController<ChequeModel> {


    List<ChequeModel> searchCheque(String cheqNo);

    boolean updateCheque(ChequeModel chequeModel);

    WriteResult deleteCheque(String cheqNo);

    List<ChequeModel> todayIn(String date);
}
