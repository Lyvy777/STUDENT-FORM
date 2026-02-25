/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
    // Fields for student details
    private String name;
    private int age;

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Method to establish database connection
    private Connection connectToDatabase() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/student_db";
        String username = "root"; 
        String password = "M@chine002"; // Replace with your MySQL password
        return DriverManager.getConnection(url, username, password);
    }

    // Method to save student details to the database
    public void saveStudent() {
        String query = "INSERT INTO students (name, age) VALUES (?, ?)";
        try (Connection connection = connectToDatabase();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, name);
            statement.setInt(2, age);
            statement.executeUpdate();
            System.out.println("Student details saved successfully!");

        } catch (SQLException e) {
            System.out.println("Error saving student details: " + e.getMessage());
        }
    }

    // Method to retrieve student details from the database
    public void retrieveStudents() {
        String query = "SELECT * FROM students";
        try (Connection connection = connectToDatabase();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
                System.out.println("Age: " + resultSet.getInt("age"));
                System.out.println("--------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving student details: " + e.getMessage());
        }
    }
}

    

