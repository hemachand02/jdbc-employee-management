CREATE DATABASE employee_management;

USE employee_management;

CREATE TABLE employees (
                           employee_id INT AUTO_INCREMENT PRIMARY KEY,
                           first_name VARCHAR(50) NOT NULL,
                           last_name VARCHAR(50) NOT NULL,
                           email VARCHAR(100) NOT NULL UNIQUE,
                           phone VARCHAR(15) NOT NULL,
                           department VARCHAR(50) NOT NULL,
                           salary DECIMAL(10,2) NOT NULL,
                           hire_date DATE NOT NULL
);