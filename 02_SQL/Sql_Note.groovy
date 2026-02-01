
-----------
# SQL Note
-----------

1. SQL
   SQL (Structured Query Language) is a standard programming language specifically designed for managing and manipulating relational databases. 
   It allows users to perform various operations such as querying data, updating records, and managing database structures.

2. What is a relational database?
    A relational database is a type of database that organizes data into tables (also known as relations) consisting of rows and columns. 
    Each table represents a specific entity, and the relationships between tables are established through keys (primary and foreign keys).

3. Data Types
    - INT: Integer data type for whole numbers.
    - VARCHAR: Variable-length character string for text data.
    - DATE: Date data type for storing dates.
    - BOOLEAN: Boolean data type for true/false values.
    - FLOAT: Floating-point data type for decimal numbers.
    - TEXT: Large text data type for storing long strings.
    - NULL: Represents a missing or undefined value.

4. SQL Commands
   SQL commands are categorized into several types based on their functionality:

   * Data Definition Language (DDL): Commands used to define and manage database structures.
   
     - CREATE: Create a new table or database.
        ex:
        ```
        CREATE TABLE Employees (
            EmployeeID INT PRIMARY KEY,
            FirstName VARCHAR(50),
            LastName VARCHAR(50),
            HireDate DATE
        );
        ```

     - ALTER: Modify an existing table structure.
        ex:
        ```
        ALTER TABLE Employees
        ADD COLUMN Email VARCHAR(100);
        ```

     - DROP: Delete a table or database.
        ex:
        ```
        DROP TABLE Employees;
        ```

     - TRUNCATE: Remove all records from a table, but keep the table structure.
        ex:
        ```
        TRUNCATE TABLE Employees;
        ```

   * Data Manipulation Language (DML): Commands used to manipulate data within tables.

     - SELECT: Retrieve data from one or more tables.
        ex:
        ```
        SELECT FirstName, LastName FROM Employees WHERE HireDate > '2020-01-01';
        ```

     - INSERT: Add new records to a table.
        ex:
        ```
        INSERT INTO Employees (EmployeeID, FirstName, LastName, HireDate)
        VALUES (1, 'John', 'Doe', '2021-05-15');
        ```

     - UPDATE: Modify existing records in a table.
        ex:
        ```
        UPDATE Employees
        SET Email = 'vivekmate0002@gmail.com'
        WHERE EmployeeID = 1;
        ```


     - DELETE: Remove records from a table.
        ex:
        ```
        DELETE FROM Employees WHERE EmployeeID = 1;
        ```

   * Data Control Language (DCL): Commands used to control access to the database.

     - GRANT: Give specific privileges to users.
        ex:
        ```
        GRANT SELECT, INSERT ON Employees TO 'username';
        ```

     - REVOKE: Remove specific privileges from users.
        ex:
        ```
        REVOKE INSERT ON Employees FROM 'username';
        ```

5. SQL Clauses

   SQL clauses are components of SQL statements that define specific conditions or operations.

   - WHERE: Filter records based on specified conditions.
      ex:
      ```
      SELECT * FROM Employees WHERE LastName = 'Doe';
      ```

   - ORDER BY: Sort the result set in ascending (ASC) or descending (DESC) order.
      ex:
      ```
      SELECT * FROM Employees ORDER BY HireDate DESC;
      ```

   - GROUP BY: Group records with identical values in specified columns.
      ex:
      ```
      SELECT COUNT(*), Department FROM Employees GROUP BY Department;
      ```
      explanation: This query counts the number of employees in each department.

   - HAVING: Filter groups based on specified conditions (used with GROUP BY).
      ex:
      ```
      SELECT COUNT(*), Department FROM Employees GROUP BY Department HAVING COUNT(*) > 5;
      ```
      explanation: This query counts the number of employees in each department and only includes departments with more than 5 employees.

   - JOIN: Combine rows from two or more tables based on a related column.

      Types of JOINs:
      * INNER JOIN: 

        - Returns records that have matching values in both tables.
        ex:
        ```
        SELECT Employees.FirstName, Departments.DepartmentName
        FROM Employees
        INNER JOIN Departments ON Employees.DepartmentID = Departments.DepartmentID;
        ```
        explanation: This query retrieves the first names of employees along with their corresponding department names 
        by joining the Employees and Departments tables on the DepartmentID column.

      * LEFT JOIN (or LEFT OUTER JOIN): 

        - Returns all records from the left table and matched records from the right table. 
            If no match, NULL values are returned for columns from the right table.
        ex:
        ```
        SELECT Employees.FirstName, Departments.DepartmentName
        FROM Employees
        LEFT JOIN Departments ON Employees.DepartmentID = Departments.DepartmentID;
        ```
        explanation: This query retrieves the first names of all employees along with their corresponding department names.
            If an employee does not belong to any department, the DepartmentName will be NULL.

      * RIGHT JOIN (or RIGHT OUTER JOIN): 
        
        - Returns all records from the right table and matched records from the left table. 
            If no match, NULL values are returned for columns from the left table.
        ex:
        ```
        SELECT Employees.FirstName, Departments.DepartmentName
        FROM Employees
        RIGHT JOIN Departments ON Employees.DepartmentID = Departments.DepartmentID;
        ```
        explanation: This query retrieves the first names of employees along with their corresponding department names.
            If a department does not have any employees, the FirstName will be NULL.


      * FULL JOIN (or FULL OUTER JOIN): 
        
        - Returns all records when there is a match in either left or right table. 
            If no match, NULL values are returned for columns from the table without a match.
        ex:
        ```
        SELECT Employees.FirstName, Departments.DepartmentName
        FROM Employees
        FULL JOIN Departments ON Employees.DepartmentID = Departments.DepartmentID;
        ```
        explanation: This query retrieves the first names of employees along with their corresponding department names.
            It includes all employees and all departments, even if there are no matches between them.

      * CROSS JOIN:
        - Returns the Cartesian product of both tables, combining each row from the first table with every row from the second table.
        ex:
        ```
        SELECT Employees.FirstName, Departments.DepartmentName
        FROM Employees
        CROSS JOIN Departments;
        ```
        explanation: This query retrieves all possible combinations of employee first names and department names 
            by performing a cross join between the Employees and Departments tables.
        
      * SELF JOIN:
        - A self join is a regular join but the table is joined with itself.
        ex:
        ```
        SELECT A.EmployeeName AS Employee, 
               B.EmployeeName AS Manager
        FROM Employees A
        JOIN Employees B ON A.ManagerID = B.EmployeeID;
        ```
        explanation: This query retrieves a list of employees along with their respective managers by performing a self join on the Employees table.
            The table is aliased as A and B to differentiate between the employee and manager records.

    - DISTINCT: Remove duplicate records from the result set.
      ex:
      ```
      SELECT DISTINCT Department FROM Employees;
      ```
      explanation: This query retrieves a list of unique departments from the Employees table, eliminating any duplicate department entries.

    - LIMIT: Restrict the number of records returned in the result set.

        ex:
        ```
        SELECT * FROM Employees LIMIT 10;
        ```
        explanation: This query retrieves the first 10 records from the Employees table.
    
    - OFFSET: Skip a specified number of records before starting to return records.
        ex:
        ```
        SELECT * FROM Employees LIMIT 10 OFFSET 5;
        ```
        explanation: This query retrieves 10 records from the Employees table, starting from the 6th record (skipping the first 5 records).
    
6. SQL Aggregate Functions
   Aggregate functions perform calculations on a set of values and return a single value.

   - COUNT(): Count the number of rows in a result set.
      ex:
      ```
      SELECT COUNT(*) FROM Employees;
      ```

   - SUM(): Calculate the total sum of a numeric column.
      ex:
      ```
      SELECT SUM(Salary) FROM Employees;
      ```

   - AVG(): Calculate the average value of a numeric column.
      ex:
      ```
      SELECT AVG(Salary) FROM Employees;
      ```

   - MIN(): Find the minimum value in a numeric column.
      ex:
      ```
      SELECT MIN(Salary) FROM Employees;
      ```

   - MAX(): Find the maximum value in a numeric column.
      ex:
      ```
      SELECT MAX(Salary) FROM Employees;
      ```

7. Basic constraints
    Constraints are rules applied to table columns to enforce data integrity and consistency.
    
    - PRIMARY KEY: Uniquely identifies each record in a table. It cannot contain NULL values.
        ex:
        ```
        CREATE TABLE Employees (
             EmployeeID INT PRIMARY KEY,
             FirstName VARCHAR(50),
             LastName VARCHAR(50)
        );
        ```
    
    - FOREIGN KEY: Establishes a relationship between two tables by linking a column in one table to the primary key of another table.
        ex:
        ```
        CREATE TABLE Orders (
             OrderID INT PRIMARY KEY,
             EmployeeID INT,
             FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID)
        );
        ```
    
    - UNIQUE: Ensures that all values in a column are unique (no duplicates).
        ex:
        ```
        CREATE TABLE Employees (
             EmployeeID INT PRIMARY KEY,
             Email VARCHAR(100) UNIQUE
        );
        ```
    
    - NOT NULL: Ensures that a column cannot have NULL values.
        ex:
        ```
        CREATE TABLE Employees (
             EmployeeID INT PRIMARY KEY,
             FirstName VARCHAR(50) NOT NULL,
             LastName VARCHAR(50) NOT NULL
        );
        ```
    
    - CHECK: Ensures that all values in a column satisfy a specific condition.
        ex:
        ```
        CREATE TABLE Employees (
             EmployeeID INT PRIMARY KEY,
             Age INT CHECK (Age >= 18)
        );
        ```
    
8. Set operations
    Set operations allow you to combine the results of two or more SQL queries.
    
    - UNION: Combine the result sets of two or more SELECT statements, removing duplicates.
        ex:
        ```
        SELECT FirstName FROM Employees
        UNION
        SELECT FirstName FROM Customers;
        ```
    
    - UNION ALL: Combine the result sets of two or more SELECT statements, including duplicates.
        ex:
        ```
        SELECT FirstName FROM Employees
        UNION ALL
        SELECT FirstName FROM Customers;
        ```
    
9. Intro to transactions
    A transaction is a sequence of one or more SQL operations that are treated as a single unit of work. 
    Transactions ensure data integrity and consistency by following the ACID properties: Atomicity, Consistency, Isolation, and Durability.

    - BEGIN TRANSACTION: Start a new transaction.
        ex:
        ```
        BEGIN TRANSACTION;
        ```

    - COMMIT: Save all changes made during the transaction to the database.
        ex:
        ```
        COMMIT;
        ```

    - ROLLBACK: Undo all changes made during the transaction.
        ex:
        ```
        ROLLBACK;
        ```

10. Normalization
    Normalization is the process of organizing data in a database to reduce redundancy and improve data integrity. 
    It involves dividing large tables into smaller, related tables and defining relationships between them.

    Common normal forms:
    - First Normal Form (1NF): Eliminate duplicate columns and ensure that each column contains atomic values.
        ex:
        ```
        CREATE TABLE Orders (
            OrderID INT PRIMARY KEY,
            ProductID INT,
            Quantity INT
        );
        ```
    - Second Normal Form (2NF): Ensure that all non-key columns are fully dependent on the primary key.
        ex:
        ```
        CREATE TABLE OrderDetails (
            OrderDetailID INT PRIMARY KEY,
            OrderID INT,
            ProductID INT,
            Quantity INT,
            FOREIGN KEY (OrderID) REFERENCES Orders(OrderID)
        );
        ```
    - Third Normal Form (3NF): Ensure that all non-key columns are not dependent on other non-key columns.
        ex:
        ```
        CREATE TABLE Products (
            ProductID INT PRIMARY KEY,
            ProductName VARCHAR(100),
            Price DECIMAL(10, 2)
        );
        ```



11. ACID :
- Atomicity: Ensures that all operations within a transaction are completed successfully. If any operation fails, 
                the entire transaction is rolled back, and no changes are made to the database.
- Consistency: Ensures that a transaction brings the database from one valid state to another valid state, maintaining all predefined rules 
                and constraints.
- Isolation: Ensures that concurrent transactions do not interfere with each other. Each transaction should operate as if it is the only 
                transaction in the system.
- Durability: Ensures that once a transaction is committed, its changes are permanent and will survive any subsequent system failures.


12. Find the second highest salary from the Employee table
    ex:
    1. Using Subquery
    ```
    SELECT MAX(salary) AS SecondHighestSalary
    FROM employees
    WHERE salary < (SELECT MAX(salary) FROM employees);
    ```

    2. Using DISTINCT and LIMIT-OFFSET (for MySQL, PostgreSQL)
    ```
    SELECT DISTINCT salary
    FROM employees
    ORDER BY salary DESC
    LIMIT 1 OFFSET 1;
    ```

13. Find duplicate records in a table based on a specific column
    ex:
    ```
    SELECT name, COUNT(*) AS count
    FROM employees
    GROUP BY name
    HAVING COUNT(*) > 1;
    ```