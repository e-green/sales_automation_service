package io.egreen.erp.employee.service;

import com.mongodb.WriteResult;
import io.egreen.apistudio.bootstrap.utill.IDUtilty;
import io.egreen.erp.employee.data.dao.EmployeeDAO;
import io.egreen.erp.employee.data.dto.EmployeeModel;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Pramode Wimukthi on 9/7/2016.
 */
public class EmployeeService {
    IDUtilty idUtilty = new IDUtilty();
    @Inject
    private EmployeeDAO employeeDAO;


    public boolean newEmployee(EmployeeModel employeeModel) {
        String empId = idUtilty.getKey(System.nanoTime());
        if (employeeModel != null) {
            employeeModel.setEmpId(empId);
            employeeDAO.create(employeeModel);
            return true;
        }
        return false;
    }


    public boolean updateEmployee(EmployeeModel employeeModel) {
        return employeeDAO.updateEmployee(employeeModel);
    }


    public List<EmployeeModel> searchEmployee(String username, String password) {
        return employeeDAO.searchEmployee(username, password);
    }

    public WriteResult deleteEmployee(String username, String password) {
        return employeeDAO.deleteEmployee(username, password);
    }
}
