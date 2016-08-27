package io.egreen.erp.product.service;

import io.egreen.erp.product.data.dao.ProductDAOController;
import io.egreen.erp.product.data.entity.Product;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

//import javax.ejb.LocalBean;

/**
 * Created by dewmal on 8/24/16.
 */
@Singleton
public class ProductService {

    @Inject
    private ProductDAOController productDAOController;


    /**
     * Get Product From Product Code
     *
     * @param code
     * @return
     */
    public Product get(String code) {
        return productDAOController.get(code);
    }


    /**
     * Save Product service
     *
     * @param product
     * @return
     */
    public Object save(Product product) {
        return productDAOController.create(product);
    }

    /**
     * Get list of products by offsets and limit
     *
     * @param offset
     * @param limit
     * @return
     */
    public List<Product> getAll(int offset, int limit) {
        return productDAOController.getAll(offset,limit);
    }
}
