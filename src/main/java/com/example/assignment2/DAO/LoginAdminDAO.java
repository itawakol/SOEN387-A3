package com.example.assignment2.DAO;
import com.example.assignment2.Bean.Administrator;
import com.example.assignment2.Mapper.AdminMapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
public class LoginAdminDAO {
    public static boolean validate(Administrator bean) throws ClassNotFoundException {
        boolean status = false;
        AdminMapper adminMapper = new AdminMapper();
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            try (Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/assignment1", "root", "");
                 PreparedStatement ps = connection.prepareStatement(adminMapper.Find())) {
                if (bean.getEmploymentID()==""){
                    status = false;
                } else {
                    ps.setString(1, bean.getEmploymentID());
                    ResultSet rs = ps.executeQuery();
                    status = rs.next();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
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
