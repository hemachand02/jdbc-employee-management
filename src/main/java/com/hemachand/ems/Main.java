package com.hemachand.ems;

import com.hemachand.ems.dao.EmployeeDAO;
import com.hemachand.ems.model.Employee;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main
{
    public static void main(String args[]) throws SQLException
    {
        EmployeeDAO employeeDAO=new EmployeeDAO();
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
        System.out.println(employeeDAO.findById(1));
        System.out.println(employeeDAO.findById(10));

//        update the table
        System.out.println(employeeDAO.updateEmployee(2,"Backend Developer",new BigDecimal("100000")));
        System.out.println(employeeDAO.updateEmployee(12,"Backend Developer",new BigDecimal("100000")));
//        deleting employee from database
        System.out.println(employeeDAO.deleteEmployee(5));
//        retrieveing all employee records
        System.out.println(employeeDAO.findAll());
    }
}
