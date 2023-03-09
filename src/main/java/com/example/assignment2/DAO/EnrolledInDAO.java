package com.example.assignment2.DAO;
import com.example.assignment2.Bean.EnrolledIn;
import com.example.assignment2.EnrolledInServlet;
import com.example.assignment2.Mapper.EnrolledInMapper;
import org.w3c.dom.ls.LSOutput;

import java.sql.*;
import java.util.Objects;


public class EnrolledInDAO {
    public static int courseInStudent(EnrolledIn enrolledIn) throws ClassNotFoundException {
        EnrolledInMapper enrolledInMapper = new EnrolledInMapper();
        int resultCourses = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/assignment1", "root", "");

             PreparedStatement ps = connection.prepareStatement(enrolledInMapper.FindCourseList(enrolledIn))) {
            ps.setString(1, enrolledIn.getStudentID());
            resultCourses = ps.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return resultCourses;
    }

    public static int enrollStudent(EnrolledIn enrolledIn, String courseCode) throws ClassNotFoundException {
        int insertStudent = 0;

        EnrolledInMapper enrolledInMapper = new EnrolledInMapper();

        Class.forName("com.mysql.cj.jdbc.Driver");


            try (Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/assignment1", "root", "");
                 Statement ps = connection.createStatement()) {
                ResultSet rs = ps.executeQuery(enrolledInMapper.Find(enrolledIn));
                rs.next();
                    if (Objects.equals(rs.getString(2), "")) {
                        PreparedStatement ps1 = connection.prepareStatement(EnrolledInMapper.Insert(enrolledIn,courseCode, "courseCode1"));
                        insertStudent = ps1.executeUpdate();
                    } else if (Objects.equals(rs.getString(3), "")) {
                        PreparedStatement ps2 = connection.prepareStatement(EnrolledInMapper.Insert(enrolledIn,courseCode,"courseCode2"));
                        insertStudent = ps2.executeUpdate();
                    } else if(Objects.equals(rs.getString(4), "")) {
                        PreparedStatement ps3 = connection.prepareStatement(EnrolledInMapper.Insert(enrolledIn,courseCode,"courseCode3"));
                        insertStudent = ps3.executeUpdate();
                    } else if (Objects.equals(rs.getString(5), "")) {
                        PreparedStatement ps4 = connection.prepareStatement(EnrolledInMapper.Insert(enrolledIn,courseCode,"courseCode4"));
                        insertStudent = ps4.executeUpdate();
                    } else if (Objects.equals(rs.getString(6), "")) {
                        PreparedStatement ps5 = connection.prepareStatement(EnrolledInMapper.Insert(enrolledIn,courseCode, "courseCode5"));
                        insertStudent = ps5.executeUpdate();
                    } else {
                        insertStudent = 0;
                    }
            } catch (SQLException e){
                printSQLException(e);
            }
        return insertStudent;
    }
    public static int dropStudent(EnrolledIn student, String courseCode) throws ClassNotFoundException{
        int deleteStudent = 0;
        EnrolledInMapper enrolledInMapper = new EnrolledInMapper();

        Class.forName("com.mysql.cj.jdbc.Driver");


        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/assignment1", "root", "");
        PreparedStatement ps = connection.prepareStatement(EnrolledInMapper.Delete(student,"courseCode1", courseCode))){
            deleteStudent = ps.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/assignment1", "root", "");
              PreparedStatement ps = connection.prepareStatement(EnrolledInMapper.Delete(student,"courseCode2", courseCode))){
            deleteStudent = ps.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/assignment1", "root", "");
              PreparedStatement ps = connection.prepareStatement(EnrolledInMapper.Delete(student,"courseCode3", courseCode))){
            deleteStudent = ps.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/assignment1", "root", "");
              PreparedStatement ps = connection.prepareStatement(EnrolledInMapper.Delete(student,"courseCode4", courseCode))){
            deleteStudent = ps.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/assignment1", "root", "");
              PreparedStatement ps = connection.prepareStatement(EnrolledInMapper.Delete(student,"courseCode5", courseCode))){
            deleteStudent = ps.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }

        return deleteStudent;
    }

    private static void printSQLException(SQLException e) {
        for (Throwable eX : e) {
            if (eX instanceof SQLException) {
                eX.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) eX).getSQLState());
                System.err.println("Error Code: " + ((SQLException) eX).getErrorCode());
                System.err.println("Message: " + eX.getMessage());
                Throwable t = e.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
