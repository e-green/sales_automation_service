package io.egreen.erp.grn.data.dao;

import com.mongodb.WriteResult;
import io.egreen.apistudio.datalayer.mongodb.dao.DAOController;
import io.egreen.erp.grn.data.entity.BatchModel;
import org.mongodb.morphia.query.UpdateResults;

import java.util.List;

/**
 * Created by dewmal on 8/24/16.
 */
public interface BatchDAOController extends DAOController<BatchModel> {

    /**
     * Get NEXT Batch Model CODE
     *
     * @param itemCode
     * @return
     */
    String getNextBatchID(String itemCode);

    BatchModel update(BatchModel batchModel);

    WriteResult removeFromOrder(String code);

    BatchModel createForObject(BatchModel batchModel);

    List<BatchModel> getNonEmptyBatchByItemCode(String itemCode);

    void updateAvailableUnits(String code, long orderQuantity,long reservedUnits);
}
