package io.egreen.erp.product.service;

import io.egreen.apistudio.bootstrap.msg.ReseponseMessage;
import io.egreen.erp.product.data.dao.ProductDAOController;
import io.egreen.erp.product.data.entity.Product;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

//import javax.ejb.LocalBean;

/**
 * Created by dewmal on 8/24/16.
 */
public class ProductService {

    @Inject
    private ProductDAOController productDAOController;

    public Product get(String code) {
        return productDAOController.get(code);
    }


    public List<Product> getAll(int offset, int limit) {
        return productDAOController.getAllPruduct(offset, limit);
    }

    public boolean save(Product product) {
        if (product != null) {
            productDAOController.create(product);
            return true;
        }
        return false;
    }
}
