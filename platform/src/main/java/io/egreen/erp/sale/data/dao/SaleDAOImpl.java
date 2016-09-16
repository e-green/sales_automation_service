package io.egreen.erp.sale.data.dao;

import io.egreen.apistudio.datalayer.mongodb.dao.impl.AbstractDAOController;
import io.egreen.erp.product.data.entity.Product;
import io.egreen.erp.sale.data.dto.SaleModel;

/**
 * Created by Pramode Wimukthi on 9/16/2016.
 */
public class SaleDAOImpl extends AbstractDAOController<SaleModel> implements SaleDao {
    public SaleDAOImpl() {
        super(SaleModel.class);
    }
}
