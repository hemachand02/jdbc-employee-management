package com.hemachand.ems.service;

import com.hemachand.ems.dao.EmployeeDAO;
import com.hemachand.ems.model.Employee;
import com.hemachand.ems.Exception.EmployeeNotFoundException;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.math.BigDecimal;

public class EmployeeService {
    private EmployeeDAO employeeDAO;
    public EmployeeService(){
        this.employeeDAO=new EmployeeDAO();
    }

    public Employee findById(int employeeId) throws SQLException {
        if(employeeId<=0){
            throw new IllegalArgumentException("Employee ID must greater than ZERO");
        }
        Employee employee= employeeDAO.findById(employeeId);
        if(employee==null){
            throw new EmployeeNotFoundException("employee ID "+employeeId+" not found");
        }
        return employee;
    }

    public boolean transferEmployee(int employeeId, String newDepartment, LocalDate transferDate) throws SQLException
    {
        if(employeeId<=0)
            throw new IllegalArgumentException("Employee ID must be greater than 0");
        if(newDepartment==null || newDepartment.isBlank())
            throw new IllegalArgumentException("New Department cannot be blank");
        if(transferDate==null)
            throw new IllegalArgumentException("Transfer date cannot be null");
        return employeeDAO.transferEmployee(employeeId,newDepartment,transferDate);
    }
    public List<Employee> findAll() throws SQLException {
        return employeeDAO.findAll();
    }
    public boolean addEmployee(Employee employee) throws SQLException{
        if(employee == null)
            throw new IllegalArgumentException("Employee cannot be null");
        return employeeDAO.addEmployee(employee);

    }
    public boolean updateEmployee(int employee_id,String Department,BigDecimal salary) throws SQLException
    {
        if(employee_id <=0)
            throw new IllegalArgumentException("employee ID must be greater than 0");
        if(Department ==null || Department.isBlank())
            throw new IllegalArgumentException("Department cannot be blank");
        if(salary==null || salary.compareTo(BigDecimal.ZERO)<0)
            throw new IllegalArgumentException("Salary cannot be negative");
        return employeeDAO.updateEmployee(employee_id,Department,salary);
    }
    public boolean deleteEmployee(int employee_id) throws SQLException {
        if (employee_id <= 0)
            throw new IllegalArgumentException("Employee ID must be greater than 0");

        return employeeDAO.deleteEmployee(employee_id);
    }

}
