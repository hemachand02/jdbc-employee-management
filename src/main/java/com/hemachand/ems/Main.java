package com.hemachand.ems;

import com.hemachand.ems.model.Employee;
import com.hemachand.ems.service.EmployeeService;
import com.hemachand.ems.Exception.EmployeeNotFoundException;

import java.util.Scanner;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Main
{
    public static void main(String args[]) throws SQLException
    {
        Scanner sc=new Scanner(System.in);

        EmployeeService employeeService=new EmployeeService();

        boolean running=true;
        while(running)
        {

            System.out.println("\n=========================================================");
            System.out.println("             EMPLOYEE MANAGEMANT SYSTEM");
            System.out.println("==========================================================");
            System.out.println("1. Add Employee");
            System.out.println("2. Find Employee");
            System.out.println("3. View All Employees");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Transfer Employee");
            System.out.println("7. Exit");
            System.out.println("\n");
            System.out.print("Enter your choice : ");
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice)
            {
                case 1: System.out.print("Enter the first name : ");
                        String firstName=sc.nextLine();

                        System.out.print("Enter the Last name : ");
                        String lastName=sc.nextLine();

                        System.out.print("Enter the Email : ");
                        String email=sc.nextLine();

                        System.out.print("Enter the phone number : ");
                        String phone=sc.nextLine();

                        System.out.print("Enter the Department : ");
                        String department=sc.nextLine();

                        System.out.print("Enter the salary : ");
                        BigDecimal salary=sc.nextBigDecimal();
                        sc.nextLine();

                        System.out.print("Enter the hireDate(YYYY-MM-DD) : ");


                        try
                        {
                            LocalDate hireDate=LocalDate.parse(sc.nextLine());

                            Employee employee1=new Employee(firstName,lastName,email,phone,department,salary,hireDate);

                            boolean result=employeeService.addEmployee(employee1);

                            if(result)
                                System.out.println("Employee Details Added to DB Successfully");
                            else
                                System.out.println("failed to add Employee");
                        }
                        catch(SQLException e)
                        {
                            System.err.println("DataBase error : "+e.getMessage());
                        }
                        break;

                case 2: System.out.print("Enter Employee ID : ");
                        int employeeId=sc.nextInt();
                        try
                        {
                            Employee employee =employeeService.findById(employeeId);
                            System.out.println(employee);
                        }
                        catch(EmployeeNotFoundException e){
                            System.out.println(e.getMessage());
                        } catch (SQLException e) {
                            System.out.println("Database error : "+e.getMessage());
                        }
                        break;

                case 3: try
                        {
                            List<Employee> employees=employeeService.findAll();

                            if(employees.isEmpty()){
                                System.out.println("employees not found");
                            }
                            else
                            {
                                for(Employee employee:employees)
                                    System.out.println(employee);
                            }
                        }
                        catch(SQLException e)
                        {
                            System.err.println("Database error : "+e.getMessage());
                        }
                        break;

                case 4: System.out.print("Enter the Employee ID : ");
                        employeeId=sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter the new department : ");
                        String newDepartment=sc.nextLine();

                        System.out.print("Enter the Updated Salary : ");
                        BigDecimal updatedSalary=sc.nextBigDecimal();
                        sc.nextLine();

                        try
                        {
                            boolean result=employeeService.updateEmployee(employeeId,newDepartment,updatedSalary);

                            if(result){
                                System.out.println("Employee updated successfully");
                            }
                            else
                            {
                                System.out.println("Employee updating failed");
                            }
                        }
                        catch(IllegalArgumentException e)
                        {
                            System.out.println("Invalid Input : "+e.getMessage());
                        }
                        catch(SQLException e)
                        {
                            System.err.println("Database error : "+e.getMessage());
                        }
                        break;

                case 5: System.out.print("Enter the Employee ID : ");
                        employeeId=sc.nextInt();
                        sc.nextLine();

                        try
                        {
                            boolean result=employeeService.deleteEmployee(employeeId);
                            if(result)
                                System.out.println("Employee deleted successfully");
                            else
                                System.out.println("Employee Deletion failed");
                        }
                        catch(IllegalArgumentException e)
                        {
                            System.err.println("Invalid Input : "+e.getMessage());
                        }
                        catch(SQLException e)
                        {
                            System.err.println("Database error : "+e.getMessage());
                        }
                        break;

                case 6: System.out.print("Enter employee ID: ");
                        employeeId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter new department: ");
                        newDepartment = sc.nextLine();

                    System.out.print("Enter transfer date (YYYY-MM-DD): ");
                    LocalDate transferDate = LocalDate.parse(sc.nextLine());

                    try {
                        boolean result = employeeService.transferEmployee(
                                employeeId,
                                newDepartment,
                                transferDate
                        );

                        if (result) {
                            System.out.println("Employee transferred successfully.");
                        } else {
                            System.out.println("Employee not found.");
                        }

                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid input: " + e.getMessage());

                    } catch (SQLException e) {
                        System.out.println("Database error: " + e.getMessage());
                    }

                    break;

                case 7: running=false;
                        System.out.println("Exiting Application...");
                        break;

                default :System.out.println("Invalid Choice...");
            }
        }
    }
}
