package io.egreen.erp.cheque.service;

import com.mongodb.WriteResult;
import io.egreen.apistudio.bootstrap.utill.IDUtilty;
import io.egreen.erp.cheque.data.dao.ChequeDAO;
import io.egreen.erp.cheque.data.dto.ChequeModel;

import javax.inject.Inject;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Pramode Wimukthi on 9/5/2016.
 */
public class ChequeService {

    IDUtilty idUtilty = new IDUtilty();
    @Inject
    private ChequeDAO chequeDAO;


    public boolean newCheque(ChequeModel chequeModel) {
        String cheqId = idUtilty.getKey(System.nanoTime());
        chequeModel.setCheqId(cheqId);
        if (chequeModel != null) {
            chequeDAO.create(chequeModel);
            return true;
        }
        return false;
    }

    public boolean updateCheque(ChequeModel chequeModel) {
        if (chequeModel != null) {
            List<ChequeModel> chequeList = chequeDAO.searchCheque(chequeModel.getCheqNo());
            if (chequeList.size() > 0) {
                return chequeDAO.updateCheque(chequeModel);
            }
        }
        return false;
    }

    public List<ChequeModel> searchCheque(String cheqNo) {
        return chequeDAO.searchCheque(cheqNo);
    }

    public WriteResult deleteCheque(String cheqNo) {
        return chequeDAO.deleteCheque(cheqNo);
    }

    public List<ChequeModel> todayIn(String date) {

        return chequeDAO.todayIn(date);
    }
}
