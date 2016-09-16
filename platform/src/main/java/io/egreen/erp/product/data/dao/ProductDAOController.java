package io.egreen.erp.product.data.dao;

import io.egreen.apistudio.datalayer.mongodb.dao.DAOController;
import io.egreen.erp.product.data.entity.Product;

import java.util.List;

/**
 * Created by dewmal on 8/24/16.
 */
public interface ProductDAOController extends DAOController<Product> {

    List<Product> getAllPruduct(int offset, int limit);
}
