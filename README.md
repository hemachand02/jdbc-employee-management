# Employee Management System

A console-based **Employee Management System** built using **Java, JDBC, MySQL, Maven, and Git/GitHub**.

This project was developed to gain practical experience with database connectivity, CRUD operations, transaction management, layered architecture, exception handling, Maven project management, and Git/GitHub workflows.

---

## 🚀 Features

* Add a new employee
* Find an employee by ID
* View all employees
* Update employee department and salary
* Delete an employee
* Transfer an employee between departments
* Maintain employee transfer history
* Transaction management using `commit()` and `rollback()`
* Input validation
* Custom exception handling
* MySQL database integration using JDBC

---

## 🛠️ Technologies Used

| Technology | Purpose                           |
| ---------- | --------------------------------- |
| Java 17    | Application development           |
| JDBC       | Database connectivity             |
| MySQL      | Database                          |
| Maven      | Project and dependency management |
| Git        | Version control                   |
| GitHub     | Remote repository                 |

---

## 🏗️ Project Architecture

The application follows a simple layered architecture:

```text
             Console User
                  │
                  ▼
              Main.java
             (Console UI)
                  │
                  ▼
         EmployeeService
        (Business Logic)
                  │
                  ▼
           EmployeeDAO
        (Database Operations)
                  │
                  ▼
           DBConnection
          (DB Connection)
                  │
                  ▼
              JDBC
                  │
                  ▼
               MySQL
```

### Layers

**Main**

* Handles console input and output.
* Displays the application menu.
* Calls the service layer.

**Service**

* Contains business validation.
* Coordinates application operations.
* Handles application-level rules.

**DAO (Data Access Object)**

* Contains JDBC/database operations.
* Executes SQL queries.
* Handles CRUD operations and transactions.

**Model**

* Represents an employee using the `Employee` class.

**Exception**

* Contains custom application exceptions such as `EmployeeNotFoundException`.

**Util**

* Contains database connection functionality.

---

## 📁 Project Structure

```text
employee-management-system/
│
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── hemachand/
│                   └── ems/
│                       ├── Main.java
│                       │
│                       ├── model/
│                       │   └── Employee.java
│                       │
│                       ├── dao/
│                       │   └── EmployeeDAO.java
│                       │
│                       ├── service/
│                       │   └── EmployeeService.java
│                       │
│                       ├── util/
│                       │   └── DBConnection.java
│                       │
│                       └── exception/
│                           └── EmployeeNotFoundException.java
│
├── sql/
│   └── schema.sql
│
├── .gitignore
├── pom.xml
└── README.md
```

---

## 🗄️ Database

The application uses **MySQL**.

### Main Table

```text
employees
```

Important columns:

```text
employee_id
first_name
last_name
email
phone
department
salary
hire_date
```

### Transfer History

Employee transfers are stored separately in:

```text
employee_transfers
```

This table records:

```text
transfer_id
employee_id
old_department
new_department
transfer_date
```

The `employee_id` in `employee_transfers` references the employee in the `employees` table.

---

## 🔄 CRUD Operations

The application demonstrates the four fundamental database operations:

### Create

Adds a new employee to the database.

```sql
INSERT INTO employees (...)
VALUES (...);
```

### Read

Finds one employee or retrieves all employees.

```sql
SELECT * FROM employees;
```

### Update

Updates an employee's department and salary.

```sql
UPDATE employees
SET department = ?, salary = ?
WHERE employee_id = ?;
```

### Delete

Deletes an employee using their ID.

```sql
DELETE FROM employees
WHERE employee_id = ?;
```

---

## 🔐 JDBC Concepts Demonstrated

This project covers several important JDBC concepts:

* JDBC Driver
* `DriverManager`
* `Connection`
* `PreparedStatement`
* `ResultSet`
* `executeQuery()`
* `executeUpdate()`
* Try-with-resources
* SQL parameter binding
* Exception handling
* Transactions
* `commit()`
* `rollback()`
* Auto-commit management

---

## 🔁 Transaction Management

The employee transfer operation demonstrates JDBC transaction management.

A transfer performs multiple database operations:

```text
1. Find current department
        ↓
2. Update employee department
        ↓
3. Insert transfer history
        ↓
4. Commit transaction
```

If any operation fails:

```text
UPDATE
   ↓
INSERT fails
   ↓
ROLLBACK
   ↓
Database returns to previous state
```

This prevents the database from being left in an inconsistent state.

---

## ⚠️ Exception Handling

The project demonstrates both standard and custom exception handling.

### Custom Exception

```java
EmployeeNotFoundException
```

This exception is used when an employee cannot be found during operations where a missing employee should be treated as an application-level condition.

### Other Exceptions

The application also handles:

* `SQLException`
* `IllegalArgumentException`
* `DateTimeParseException`

---

## 📋 Application Menu

When the application starts:

```text
========================================
       EMPLOYEE MANAGEMENT SYSTEM
========================================

1. Add Employee
2. Find Employee
3. View All Employees
4. Update Employee
5. Delete Employee
6. Transfer Employee
7. Exit
```

---

## ⚙️ Setup & Installation

### 1. Clone the repository

```bash
git clone https://github.com/hemachand02/jdbc-employee-management.git
```

### 2. Open the project

Open the project in IntelliJ IDEA or another Java IDE that supports Maven.

### 3. Configure MySQL

Create the required database and tables using:

```text
sql/schema.sql
```

### 4. Configure database credentials

Update the database connection details in:

```text
DBConnection.java
```

with your local MySQL configuration.

Example:

```text
Database URL: jdbc:mysql://localhost:3306/your_database
Username: your_username
Password: your_password
```

> Do not commit real database passwords or credentials to GitHub.

### 5. Build the project

Using Maven:

```bash
mvn clean package
```

### 6. Run the application

Run:

```text
Main.java
```

from your IDE.

---

## 📚 What I Learned

Through this project, I practiced:

* Java OOP
* Encapsulation
* Classes and objects
* Exception handling
* Custom exceptions
* JDBC architecture
* SQL CRUD operations
* Prepared statements
* Result sets
* Database transactions
* Commit and rollback
* Maven dependency management
* Project structure
* Layered architecture
* Git branching
* Git merging
* Git commits
* GitHub repository management

---

## 🔮 Future Improvements

Possible improvements for a future version include:

* Convert the application into a Spring Boot REST API
* Add a web frontend
* Add authentication and authorization
* Introduce connection pooling
* Add automated unit and integration tests
* Add logging
* Improve input validation
* Introduce pagination and searching
* Containerize the application using Docker

These improvements are intentionally outside the scope of this first JDBC project.

---

## 👨‍💻 Author

**Hemachand Rampilla**

This project was created as part of my journey toward becoming a Java Backend Developer.

---

## 📌 Project Status

**Completed ✅**

This project focuses on learning and applying core JDBC, MySQL, Maven, Java, and Git/GitHub concepts through a practical application.
