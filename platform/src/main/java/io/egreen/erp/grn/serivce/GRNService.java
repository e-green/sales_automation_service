package io.egreen.erp.grn.serivce;

import io.egreen.apistudio.bootstrap.msg.ReseponseMessage;
import io.egreen.erp.grn.data.dao.GRNDAOController;
import io.egreen.erp.grn.data.entity.GrnModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.types.ObjectId;
import org.hashids.Hashids;
import org.mongodb.morphia.Key;

import javax.inject.Inject;
import java.util.Date;

/**
 * Created by dewmal on 8/24/16.
 */
public class GRNService {

    private static final Logger LOGGER = LogManager.getLogger(GRNService.class);

    @Inject
    private GRNDAOController grndaoController;


    /**
     * Create GRN Order
     *
     * @param grnModel
     * @return
     */
    public Object create(GrnModel grnModel) {
        Hashids hashids = new Hashids(System.nanoTime() + "");
        String code = hashids.encode(System.nanoTime()) + grnModel.getSupplierCode();

        grnModel.setCode(code);
        grnModel.setReceivedTime(new Date());

        Key<GrnModel> grnModelKey = grndaoController.create(grnModel);
        ObjectId grnModelKeyId = (ObjectId) grnModelKey.getId();
        grnModel.setId(grnModelKeyId);
        return grnModel;
    }

    /**
     * GET GRN Order By Code
     *
     * @param code
     * @return
     */
    public GrnModel get(String code) {
        GrnModel grnModel = grndaoController.get("code", code);
        return grnModel;
    }


    /**
     * Finish GRN ORDER
     *
     * @param grnModel
     * @return
     */
    public Object finish(GrnModel grnModel) {
        GrnModel model = get(grnModel.getCode());
        if (!model.isFinished()) {
            return grndaoController.finish(grnModel.getCode());
        }
        return new ReseponseMessage(ReseponseMessage.Type.WARNING, "Order is already finished " + model.getFinishedTime());
    }
}
