package io.egreen.erp.employee.data.dao.impl;

import com.mongodb.WriteResult;
import io.egreen.apistudio.datalayer.mongodb.dao.impl.AbstractDAOController;
import io.egreen.erp.employee.data.dao.EmployeeDAO;
import io.egreen.erp.employee.data.dto.EmployeeModel;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import java.util.List;

/**
 * Created by Pramode Wimukthi on 9/7/2016.
 */
public class EmployeeDAOImpl extends AbstractDAOController<EmployeeModel> implements EmployeeDAO {

    public EmployeeDAOImpl() {
        super(EmployeeModel.class);
    }

    @Override
    public boolean updateEmployee(EmployeeModel employeeModel) {
        Query<EmployeeModel> query = getQuery();
        query.filter("username", employeeModel.getUsername());
        query.filter("password", employeeModel.getPassword());
        UpdateOperations<EmployeeModel> updateOperations = getDatastore().createUpdateOperations(EmployeeModel.class);

        updateOperations.set("firstName", employeeModel.getFirstName());
        updateOperations.set("lastName", employeeModel.getLastName());
        updateOperations.set("nic", employeeModel.getNic());
        updateOperations.set("empTele", employeeModel.getEmpTele());
        updateOperations.set("username", employeeModel.getUsername());
        updateOperations.set("password", employeeModel.getPassword());

        getDatastore().update(query, updateOperations);
        return true;
    }

    @Override
    public List<EmployeeModel> searchEmployee(String username, String password) {
        Query<EmployeeModel> query = getQuery();
        query.filter("username", username);
        query.filter("password", password);
        return query.asList();
    }

    @Override
    public WriteResult deleteEmployee(String username, String password) {
        Query<EmployeeModel> query = getQuery();
        query.filter("username", username);
        query.filter("password", password);
        return getDatastore().delete(query);
    }
}
