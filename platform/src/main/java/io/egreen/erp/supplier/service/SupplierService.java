package io.egreen.erp.supplier.service;

import io.egreen.erp.supplier.data.dao.SupplierDAOControoler;
import io.egreen.erp.supplier.data.entity.Supplier;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by dewmal on 8/24/16.
 */
public class SupplierService {

    @Inject
    private SupplierDAOControoler supplierDAOControoler;

    public Object save(Supplier supplier) {
        return supplierDAOControoler.create(supplier);
    }

    public Supplier get(String code) {
        return supplierDAOControoler.get(code);
    }

    public List<Supplier> getAll(int offset, int limit) {
        return supplierDAOControoler.getAll(offset,limit);
    }
}
