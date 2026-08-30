package com.hemachand.ems.dao;

import com.hemachand.ems.model.Employee;
import com.hemachand.ems.util.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import java.sql.Date;

public class EmployeeDAO {
    public void addEmployee (Employee employee) throws SQLException
    {
        String sql= """
                INSERT INTO employees(first_name,last_name,email,phone,department,salary,hire_date)
                VALUES(?,?,?,?,?,?,?)
                """;
        try(Connection connection=DBConnection.getConnection();

            PreparedStatement preparedStatement=connection.prepareStatement(sql)) {
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPhone());
            preparedStatement.setString(5, employee.getDepartment());
            preparedStatement.setBigDecimal(6, employee.getSalary());
            preparedStatement.setDate(7, Date.valueOf(employee.getHireDate()));

            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println(rowsAffected + " employee(s) added successfully");
        }
    }
}
