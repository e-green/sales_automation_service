package io.egreen.erp.employee.api;

import com.mongodb.WriteResult;

import io.egreen.erp.employee.data.dto.EmployeeModel;
import io.egreen.erp.employee.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

/**
 * Created by Pramode Wimukthi on 9/7/2016.
 */
@Path("/employee")
@Api(
        value = "/employee", description = "employee Handling module"
)
@Produces("application/json")
@Consumes("application/json")
public class EmployeeController {

    @Inject
    private EmployeeService employeeService;

    @POST
    @Path("/save")
    @ApiOperation(
            value = "add new Employee",
            notes = "Add new Employee to the Database"
    )
    public boolean newEmployee(EmployeeModel employeeModel) {
        return employeeService.newEmployee(employeeModel);
    }


    @POST
    @Path("/update")
    @ApiOperation(
            value = "update Employee",
            notes = "Update Employee from Database"
    )
    public boolean updateEmployee(EmployeeModel employeeModel) {
        return employeeService.updateEmployee(employeeModel);
    }


    @GET
    @Path("/search")
    @ApiOperation(
            value = "search Employee",
            notes = "Search Employee from database"
    )
    public Object searchEmployee(@QueryParam("userName") String username,@QueryParam("password")String password) {
        return employeeService.searchEmployee(username,password);
    }

    @DELETE
    @Path("/delete")
    @ApiOperation(
            value = "delete Employee",
            notes = "Delete Employee from database"
    )
    public WriteResult deleteEmployee(@QueryParam("userName") String username,@QueryParam("password")String password) {
        return employeeService.deleteEmployee(username,password);
    }

}
