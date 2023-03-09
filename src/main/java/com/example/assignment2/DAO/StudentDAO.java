package com.example.assignment2.DAO;
import com.example.assignment2.Mapper.EnrolledInMapper;
import com.example.assignment2.Mapper.StudentMapper;
import com.example.assignment2.Bean.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {

    public int registerStudent(Student student) throws ClassNotFoundException {

        StudentMapper studentMapper = new StudentMapper();

        EnrolledInMapper enrolledInMapper = new EnrolledInMapper();


        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/assignment1", "root", "");



             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(studentMapper.Insert())) {
            preparedStatement.setString(1, student.getStudentID());
            preparedStatement.setString(2, student.getFirstName());
            preparedStatement.setString(3, student.getLastName());
            preparedStatement.setString(4, student.getAddress());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setString(6, student.getPhoneNumber());
            preparedStatement.setString(7, student.getDateOfBirth());
            PreparedStatement ps = connection.prepareStatement(enrolledInMapper.InsertStudent(student));
            System.out.println(ps);
            result = ps.executeUpdate();
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

