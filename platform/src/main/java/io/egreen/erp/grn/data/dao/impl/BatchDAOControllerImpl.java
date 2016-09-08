package io.egreen.erp.grn.data.dao.impl;

import com.mongodb.WriteResult;
import io.egreen.apistudio.datalayer.mongodb.dao.impl.AbstractDAOController;
import io.egreen.erp.grn.data.dao.BatchDAOController;
import io.egreen.erp.grn.data.entity.BatchModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.mongodb.morphia.query.UpdateResults;

import java.util.List;

/**
 * Created by dewmal on 8/24/16.
 */
public class BatchDAOControllerImpl extends AbstractDAOController<BatchModel> implements BatchDAOController {

    private static final Logger LOGGER = LogManager.getLogger(BatchDAOControllerImpl.class);


    public BatchDAOControllerImpl() {
        super(BatchModel.class);
    }

    @Override
    public String getNextBatchID(String itemCode) {
        String batchNextID = itemCode + "_" + 1;

        Query<BatchModel> query = getDatastore().createQuery(entityClass);
        query.filter("itemCode =", itemCode);

        LOGGER.info(query.getBatchSize());

        List<BatchModel> batchModels = query.asList();
        if (batchModels != null) {
            LOGGER.info(batchModels.size());
            batchNextID = itemCode + "_" + (batchModels.size() + 1);

        }
        return batchNextID;
    }

    @Override
    public BatchModel update(BatchModel batchModel) {

        Query<BatchModel> filterQuery = getDatastore().createQuery(entityClass);
        filterQuery.filter("code =", batchModel.getCode());

        UpdateOperations<BatchModel> updateOperations = getDatastore().createUpdateOperations(entityClass);
        updateOperations.set("numberOfUnits", batchModel.getNumberOfUnits());
        updateOperations.set("availableUnits", batchModel.getAvailableUnits());
        updateOperations.set("unit", batchModel.getUnit());
        updateOperations.set("unitBuyingPrice", batchModel.getUnitBuyingPrice());
        updateOperations.set("unitSellingPrice", batchModel.getUnitSellingPrice());
        updateOperations.set("availableUnits", batchModel.getAvailableUnits());


        UpdateResults update = getDatastore().update(filterQuery, updateOperations);


        batchModel.setId((ObjectId) update.getNewId());
        return batchModel;

    }

    @Override
    public BatchModel createForObject(BatchModel batchModel) {
        String batchCode = getNextBatchID(batchModel.getItemCode());
        batchModel.setCode(batchCode);
        Key<BatchModel> batchModelKey = super.create(batchModel);
        ObjectId objectId = (ObjectId) batchModelKey.getId();
        batchModel.setId(objectId);
        return batchModel;
    }

    @Override
    public WriteResult removeFromOrder(String code) {
        Query<BatchModel> filterQuery = getDatastore().createQuery(entityClass);
        filterQuery.filter("code =", code);

        WriteResult delete = getDatastore().delete(filterQuery);
        return delete;
    }

    @Override
    public List<BatchModel> getNonEmptyBatchByItemCode(String itemCode) {
        Query<BatchModel> query = getDatastore().createQuery(entityClass);
        query.filter("itemCode =", itemCode);
        query.filter("availableUnits >", 0);
        query.order("batchDate");
//        query.
        return query.asList();
    }

    @Override
    public void updateAvailableUnits(BatchModel batchModel) {
        Query<BatchModel> filterQuery = getDatastore().createQuery(entityClass);
        filterQuery.filter("code =", batchModel.getCode());

        UpdateOperations<BatchModel> updateOperations = getDatastore().createUpdateOperations(entityClass);
        updateOperations.set("availableUnits", batchModel.getAvailableUnits());
        updateOperations.set("reservedUnits", batchModel.getReservedUnits());

        getDatastore().update(filterQuery, updateOperations);
    }

    @Override
    public void updateBatchQuantity(BatchModel batchModel) {
        Query<BatchModel> filterQuery = getQuery();
        filterQuery.filter("code =", batchModel.getCode());

        UpdateOperations<BatchModel> updateOperations = getDatastore().createUpdateOperations(entityClass);
        updateOperations.set("reservedUnits", batchModel.getReservedUnits());

        getDatastore().update(filterQuery, updateOperations);
    }

    @Override
    public List<BatchModel> chechAvailability(int availableUnits, int ofset, int limit) {
        Query<BatchModel> query = getQuery();
        query.filter("availableUnits =", availableUnits);
        query.offset(ofset);
        query.limit(limit);
        return query.asList();
    }

    @Override
    public List<BatchModel> chechAvailability2(int availableUnits, int ofset, int limit) {
        Query<BatchModel> query = getQuery();
        query.filter("availableUnits >", availableUnits);
        query.offset(ofset);
        query.limit(limit);
        return query.asList();
    }
}
