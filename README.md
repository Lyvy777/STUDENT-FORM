# Simple Student Management System

## Project Description
This project is a **Student Management System** developed using **Java Swing** and **MySQL**.  
The system allows users to enter student details and store them in a database, then retrieve and display the stored records in a table interface.

This project demonstrates basic concepts of:
- Java GUI development (Swing)
- Database connectivity (JDBC)
- SQL operations (INSERT and SELECT)
- Event-driven programming

## Features
- Add student name and age
- Save student details into MySQL database
- Retrieve student records
- Display records in a JTable
- Simple and user-friendly interface

## Technologies Used
- Java
- Java Swing (GUI)
- JDBC (Java Database Connectivity)
- MySQL Database
- SQL

## Project Structure
- `Student.java` → Handles database operations and student data
- `StudentForm.java` → GUI interface using Java Swing
- SQL Script → Database and table creation

## Database Setup
Run the following SQL in MySQL:

```sql
CREATE DATABASE student_db;

USE student_db;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL
);

```

## How to run the project
1. Install Java (JDK 8 or above).
2. Install MySQL and create the database using the SQL script above.
3. Add MySQL Connector/J to your project libraries.
4. Open the project in NetBeans or any Java IDE.
5. Update the database password in the code.
6. Run `StudentForm.java`
7. Enter student details and click **SAVE**.
8. Click **VIEW** to display stored records.

## Learning Objectives
This project was developed to practice:
- Java GUI development
- Database connectivity using JDBC
- Basic SQL operations
- Desktop application structure

## Author
Lyvia Gekonge
