package com.example.assignment2.DAO;
import com.example.assignment2.Bean.Student;
import com.example.assignment2.Mapper.StudentMapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
public class LoginStudentDAO {
    public static boolean validateStudent(Student bean) throws ClassNotFoundException {
        boolean status = false;
        StudentMapper studentMapper = new StudentMapper();
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println(studentMapper.Find());
        try {
            try (Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/assignment1", "root", "");
                 PreparedStatement ps = connection.prepareStatement(studentMapper.Find())) {
                System.out.println(studentMapper.Find());
                if (bean.getStudentID() == "") {
                    status = false;
                } else {
                    ps.setString(1, bean.getStudentID());
                    ResultSet rs = ps.executeQuery();
                    status = rs.next();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }
}
