package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
    private String name;
    private int age;

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

    private Connection connectToDatabase() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/student_db";
        String username = "root"; 
        String password = "your_password"; 
        return DriverManager.getConnection(url, username, password);
    }

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

