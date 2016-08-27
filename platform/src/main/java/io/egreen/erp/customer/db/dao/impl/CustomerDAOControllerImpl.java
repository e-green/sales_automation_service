package io.egreen.erp.customer.db.dao.impl;

import io.egreen.apistudio.datalayer.mongodb.dao.impl.AbstractDAOController;
import io.egreen.erp.customer.db.dao.CustomerDAOController;
import io.egreen.erp.customer.db.entity.Customer;

import javax.ejb.Stateless;

/**
 * Created by dewmal on 8/23/16.
 */
@Stateless
public class CustomerDAOControllerImpl extends AbstractDAOController<Customer> implements CustomerDAOController {

    public CustomerDAOControllerImpl() {
        super(Customer.class);
    }
}
