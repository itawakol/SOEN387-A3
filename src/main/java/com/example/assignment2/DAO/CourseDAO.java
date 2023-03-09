package com.example.assignment2.DAO;

import com.example.assignment2.Bean.Course;
import com.example.assignment2.Mapper.CourseMapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CourseDAO {
    public int createCourse(Course course) throws ClassNotFoundException {

        CourseMapper courseMapper = new CourseMapper();

        int resultCourse = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/assignment1", "root", "");

             PreparedStatement ps1 = connection.prepareStatement(courseMapper.Insert())) {
            ps1.setString(1, course.getCourseCode());
            ps1.setString(2, course.getTitle());
            ps1.setString(3, course.getSemester());
            ps1.setString(4, course.getDays());
            ps1.setString(5, course.getTime());
            ps1.setString(6, course.getInstructor());
            ps1.setString(7, course.getRoom());
            ps1.setString(8, course.getStartDate());
            ps1.setString(9, course.getEndDate());
            System.out.println(ps1);
            resultCourse = ps1.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return resultCourse;

        }
        private void printSQLException(SQLException exA) {
        for (Throwable eX: exA) {
            if (eX instanceof SQLException) {
                eX.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) eX).getSQLState());
                System.err.println("Error Code: " + ((SQLException) eX).getErrorCode());
                System.err.println("Message: " + eX.getMessage());
                Throwable t = exA.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
