package com.hemachand.ems.dao;

import com.hemachand.ems.model.Employee;
import com.hemachand.ems.util.DBConnection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Date;
import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.List;
import java.util.ArrayList;

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
    public Employee findById(int employeeId) throws SQLException{
        String sql= """
                SELECT * from employees WHERE employee_id=?""";
        try(Connection connection =DBConnection.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setInt(1,employeeId);

            try(ResultSet result=preparedStatement.executeQuery()){
                if(result.next()){
                    int employee_Id=result.getInt("employee_id");
                    String first_name=result.getString("first_name");
                    String last_name=result.getString("last_name");
                    String email=result.getString("email");
                    String phone=result.getString("phone");
                    String department=result.getString("department");
                    BigDecimal salary=result.getBigDecimal("salary");
                    LocalDate hire_date=result.getDate("hire_date").toLocalDate();

                    Employee employee=new Employee(employee_Id,first_name,last_name,email,phone,department,salary,hire_date);

                    return employee;
                }else{
                    return null;
                }
            }
        }
    }
    public List<Employee> findAll() throws SQLException{
        String sql="SELECT * FROM employees";
        List<Employee> employees=new ArrayList<>();
        try(Connection connection =DBConnection.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(sql))
        {
            try(ResultSet resultSet=preparedStatement.executeQuery())
            {
                    while(resultSet.next())
                    {
                        int employee_id=resultSet.getInt("employee_id");
                        String first_name=resultSet.getString("first_name");
                        String last_name=resultSet.getString("last_name");
                        String email=resultSet.getString("email");
                        String phone=resultSet.getString("phone");
                        String department=resultSet.getString("department");
                        BigDecimal salary=resultSet.getBigDecimal("salary");
                        LocalDate hire_date=resultSet.getDate("hire_date").toLocalDate();

                        Employee employee=new Employee(
                                employee_id,
                                first_name,
                                last_name,
                                email,
                                phone,
                                department,
                                salary,
                                hire_date);

                        employees.add(employee);
                    }
                    return employees;
            }
        }
    }
}
