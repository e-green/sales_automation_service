package io.egreen.erp.product.data.dao.impl;

import io.egreen.apistudio.datalayer.mongodb.dao.impl.AbstractDAOController;
import io.egreen.erp.product.data.dao.ProductDAOController;
import io.egreen.erp.product.data.entity.Product;
import org.mongodb.morphia.query.Query;

import java.util.List;

/**
 * Created by dewmal on 8/24/16.
 */
//@Dependent
public class ProductDAOControllerImpl extends AbstractDAOController<Product> implements ProductDAOController {

    public ProductDAOControllerImpl() {
        super(Product.class);
    }


}
