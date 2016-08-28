package io.egreen.erp.customer.service;

import io.egreen.erp.customer.db.dao.CustomerDAOController;
import io.egreen.erp.customer.db.entity.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by dewmal on 8/23/16.
 */
@Stateless
public class CustomerService {

    private static final Logger LOGGER = LogManager.getLogger(CustomerService.class);

    @Inject
    private CustomerDAOController customerDAOController;

    public Object saveCustomer(Customer customer) {
        LOGGER.info(customer);
        return customerDAOController.create(customer).getId();
    }

    public List<Customer> getAll(int offset, int limit) {
        return customerDAOController.getAll(offset, limit);
    }
}
