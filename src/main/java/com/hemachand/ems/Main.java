package com.hemachand.ems;

import com.hemachand.ems.dao.EmployeeDAO;
import com.hemachand.ems.model.Employee;
import com.hemachand.ems.service.EmployeeService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main
{
    public static void main(String args[]) throws SQLException
    {
//        EmployeeDAO employeeDAO=new EmployeeDAO();
        EmployeeService employeeService=new EmployeeService();
//adding employee
//        Employee employee=new Employee(
//                            "Arun",
//                            "Reddy",
//                            "Arunreddy123@gmail.com",
//                            "+91 9512357456",
//                            "DevOps Engineer",
//                            new BigDecimal("65000"),
//                            LocalDate.of(2026,7,26)
//                            );
//
//        employeeDAO.addEmployee(employee);

//getting employee by ID
        System.out.println(employeeService.findById(1));
        System.out.println(employeeService.findById(10));

//        update the table
        System.out.println(employeeService.updateEmployee(2,"Backend Developer",new BigDecimal("100000")));
        System.out.println(employeeService.updateEmployee(12,"Backend Developer",new BigDecimal("100000")));
//        deleting employee from database
        System.out.println(employeeService.deleteEmployee(5));
//        making a transaction
        System.out.println(employeeService.transferEmployee(2,"DevOps Engineer",LocalDate.now()));
//        retrieveing all employee records
        System.out.println(employeeService.findAll());
    }
}
