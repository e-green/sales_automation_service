package io.egreen.erp.employee.data.dao;

import com.mongodb.WriteResult;
import io.egreen.apistudio.datalayer.mongodb.dao.DAOController;
import io.egreen.erp.employee.data.dto.EmployeeModel;

import java.util.List;

/**
 * Created by Pramode Wimukthi on 9/7/2016.
 */
public interface EmployeeDAO extends DAOController<EmployeeModel> {

    boolean updateEmployee(EmployeeModel employeeModel);

    List<EmployeeModel> searchEmployee(String username, String password);

    WriteResult deleteEmployee(String username, String password);
}
