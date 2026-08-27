package com.hemachand.ems.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String department;
    private BigDecimal salary;
    private LocalDate hireDate;

    //The Below constructor is used for new employee info class
    //creation
    public Employee(String firstName,String lastName,String email,String phone,String department,BigDecimal salary,LocalDate hireDate)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.phone=phone;
        this.department=department;
        this.salary=salary;
        this.hireDate=hireDate;
    }
    //The Below constructor is used for existing employee info loading into class
    public Employee(int employeeId,String firstName,String lastName,String email,String phone,String department,BigDecimal salary,LocalDate hireDate)
    {
        this.employeeId=employeeId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.phone=phone;
        this.department=department;
        this.salary=salary;
        this.hireDate=hireDate;
    }

    //setters
    public void setEmployeeId(int employeeId){
        this.employeeId=employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public void setPhone(String phone){
        this.phone=phone;
    }

    public void setDepartment(String department){
        this.department=department;
    }

    public void setSalary(BigDecimal salary){
        this.salary=salary;
    }

    public void setHireDate(LocalDate hireDate){
        this.hireDate=hireDate;
    }

    //getters
    public int getEmployeeId(){
        return employeeId;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmail(){
        return email;
    }

    public String getPhone(){
        return phone;
    }

    public String getDepartment(){
        return department;
    }

    public BigDecimal getSalary(){
        return salary;
    }

    public LocalDate getHireDate(){
        return hireDate;
    }

    @Override
    public String toString(){
        return "Employee{ "+
                "employeeId="+employeeId+","+
                "firstName='"+firstName+'\''+
                ",lastName='"+lastName+'\''+
                ",email='"+email+'\''+
                ",phone='"+phone+'\''+
                ",department='"+department+'\''+
                ",salary="+salary+
                ",hireDate="+hireDate+" }";
    }
}
