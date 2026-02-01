----------------
 SQL Notes 01 
----------------

1. What is a database?
  - A database is a system that allows users to store and organize data in a structured way.
  - They are useful when we are dealing with large amounts of data.
  
  * Typical Users of Databases:
    - Businesses
    - Governments
    - Educational Institutions
    - Individuals

2. Why use a database?
  - To store, manage, and retrieve data efficiently.


3. SQL (Structured Query Language)
  - SQL is a standard language used to communicate with and manipulate databases.
  - It allows users to perform various operations such as querying, updating, and managing data.
  - SQL is the programming language used to communicate with relational databases.

  
4. PostgreSQL DB Restore Command
  * pg_restore -U <username> -d <database_name> -1 <backup_file>.backup
    - -U: Specifies the username to connect to the database.
    - -d: Specifies the name of the database to restore the data into.
    - -1: Indicates that the restore should be done in a single transaction.
    - <backup_file>.backup: The path to the backup file that contains the data to be restored.

  * Example:
    - pg_restore -h localhost -p 5432 -U postgres -C -d postgres   /home/vivek-mate/01_Notes/02_SQL/dvdrental.tar
        - -h: Specifies the host where the database server is running (localhost in this case).
        - -p: Specifies the port number on which the database server is listening (5432 is the default for PostgreSQL).
        - -C: Creates the database before restoring it.

5. How to check all tables in a database?
  - 
    '''SELECT table_schema, table_name
       FROM information_schema.tables
       WHERE table_type = 'BASE TABLE'
        AND table_schema NOT IN ('pg_catalog', 'information_schema')
       ORDER BY table_schema, table_name;'''

6. DISTINCT

  - The DISTINCT keyword is used in SQL to remove duplicate rows from the result set of a query.
  - It ensures that the result set contains only unique values for the specified columns.
  - distinct can work distinct(column1, column2, ...) || distinct(column1) distinct(column2) ... || distinct column1, column2, ...

  * Example:
    - '''SELECT DISTINCT column1, column2
     FROM table_name;'''

    - '''SELECT DISTINCT f.release_year
     FROM film f;'''
    
7. Count

  - The COUNT function in SQL is used to count the number of rows that match a specified condition.
  - It can be used to count all rows or only distinct values.

  * Example:
    - '''SELECT COUNT(*) 
     FROM table_name
     WHERE condition;'''
       
    - '''SELECT COUNT(DISTINCT f.release_year)
     FROM film f;'''

    - '''SELECT COUNT f.release_year
     FROM film f;'''

8. ORDER BY

  - The ORDER BY clause in SQL is used to sort the result set of a query in ascending (ASC) or descending (DESC) order based on one or more columns.

  * Example:
    - '''SELECT column1, column2
     FROM table_name
     ORDER BY column1 ASC, column2 DESC;'''

    - '''select *
     from film f
     order by f.release_year desc, f.title asc;'''

9. LIMIT

    - The LIMIT clause in SQL is used to specify the maximum number of rows to return in the result set of a query.
    
    * Example:
    - '''SELECT column1, column2
     FROM table_name
     LIMIT number_of_rows;'''

    - '''select *
     from film f
     order by f.release_year desc
     limit 10;'''

10. BETWEEN

    - The BETWEEN operator in SQL is used to filter the result set within a specific range.
    - It can be used with numeric, date, and text data types.

    * Example:
    - '''SELECT column1, column2
     FROM table_name
     WHERE column1 BETWEEN value1 AND value2;'''

    - '''select *
     from film f 
     where f.release_year between 2007 and 2015;'''


11. IN

    - The IN operator in SQL is used to filter the result set based on a list of specified values.
    - It allows you to check if a column's value matches any value in a given list.

    * Example:
    - '''SELECT column1, column2
     FROM table_name
     WHERE column1 IN (value1, value2, value3);'''

    - '''select *
     from film f 
     where f.release_year in (2006, 2007, 2008);'''

12. LIKE & ILIKE

    - The LIKE operator in SQL is used to search for a specified pattern in a column.
    - It is often used with wildcard characters to match partial strings.
    - The ILIKE operator is a case-insensitive version of the LIKE operator (specific to PostgreSQL).

    * Example:
    - '''SELECT column1, column2
     FROM table_name
     WHERE column1 LIKE 'pattern%';'''

    - '''select *
     from film f 
     where f.title like 'A%';'''

    - '''select *
     from film f 
     where f.title ilike 'a%';'''

13. AGGREGATE FUNCTIONS 

    - Aggregate functions in SQL are used to perform calculations on a set of values and return a single value.
    - Common aggregate functions include COUNT, SUM, AVG, MAX, and MIN.

    * Example:
    - '''SELECT AVG(column1)
     FROM table_name;'''

    - '''select avg(f.rental_rate)
     from film f;'''

    - '''select max(f.rental_rate)
     from film f;'''

    - '''select min(f.rental_rate)
     from film f;'''

    - '''select sum(f.rental_rate)
     from film f;'''

    - '''select count(*)
     from film f;'''
    
14. GROUP BY

    - The GROUP BY clause in SQL is used to group rows that have the same values in specified columns into summary rows.
    - It is often used with aggregate functions (like COUNT, SUM, AVG) to perform calculations on each group.

    * Example:
    - '''SELECT column1, COUNT(*)
     FROM table_name
     GROUP BY column1;'''

    - '''select release_year ,count(release_year)
      from film
      group by release_year;'''
    
15. HAVING
    - The HAVING clause in SQL is used to filter groups of rows created by the GROUP BY clause based on a specified condition.
    - It is similar to the WHERE clause, but it is used for groups rather than individual rows.

    * Example:
    - '''SELECT column1, COUNT(*)
     FROM table_name
     GROUP BY column1
     HAVING COUNT(*) > value;'''

    - '''select f.release_year, count(*)
     from film f 
     group by f.release_year
     having count(*) > 10;'''
