package io.egreen.erp.grn.serivce;

import io.egreen.apistudio.bootstrap.msg.ReseponseMessage;
import io.egreen.erp.grn.data.dao.BatchDAOController;
import io.egreen.erp.grn.data.dao.GRNDAOController;
import io.egreen.erp.grn.data.entity.BatchModel;
import io.egreen.erp.grn.data.entity.GrnModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

/**
 * Created by dewmal on 8/24/16.
 */
public class ItemBatchService {

    private static final Logger LOGGER = LogManager.getLogger(ItemBatchService.class);

    @Inject
    private BatchDAOController batchDAOController;

    @Inject
    private GRNDAOController grndaoController;

    /**
     * Save Batch Model
     *
     * @param batchModel
     * @return
     */
    public Object save(BatchModel batchModel) {
        GrnModel grnModel = grndaoController.get(batchModel.getGrnCode());

        if (grnModel == null) {
            return new ReseponseMessage(ReseponseMessage.Type.ERROR, "You cannot add Batch to Non Exists GRN Order");
        }

        if (grnModel.isFinished()) {
            return new ReseponseMessage(ReseponseMessage.Type.ERROR, "You cannot add Batch to finished GRN Order");
        }

        if (batchModel.getCode() != null) {
            LOGGER.info(batchModel);
            batchModel = batchDAOController.update(batchModel);
        } else {
            batchModel = batchDAOController.createForObject(batchModel);
        }
        return batchModel;
    }

    /**
     * Get Batch Model By Code
     *
     * @param code
     * @return
     */
    public BatchModel get(String code) {
        return batchDAOController.get(code);
    }

    /**
     * Remove ITEM FROM Batch And GRN Order
     *
     * @param code
     * @return
     */
    public Object remove(String code) {
        return batchDAOController.removeFromOrder(code);
    }


}
