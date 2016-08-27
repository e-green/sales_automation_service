package io.egreen.erp.supplier.data.dao.impl;

import io.egreen.apistudio.datalayer.mongodb.dao.impl.AbstractDAOController;
import io.egreen.erp.supplier.data.dao.SupplierDAOControoler;
import io.egreen.erp.supplier.data.entity.Supplier;

/**
 * Created by dewmal on 8/24/16.
 */

public class SupplierDAOControllerImpl extends AbstractDAOController<Supplier> implements SupplierDAOControoler {

    public SupplierDAOControllerImpl() {
        super(Supplier.class);
    }
}
