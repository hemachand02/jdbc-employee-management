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

        Employee employee=new Employee(
                            "Arun",
                            "Reddy",
                            "Arunreddy123@gmail.com",
                            "+91 9512357456",
                            "DevOps Engineer",
                            new BigDecimal("65000"),
                            LocalDate.of(2026,7,26)
                            );

        employeeDAO.addEmployee(employee);
    }
}
