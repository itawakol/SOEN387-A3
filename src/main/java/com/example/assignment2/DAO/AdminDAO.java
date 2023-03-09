package com.example.assignment2.DAO;

import com.example.assignment2.Bean.Administrator;
import com.example.assignment2.Mapper.AdminMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminDAO {

    public int registerAdmin(Administrator admin) throws ClassNotFoundException {


        AdminMapper adminMapper = new AdminMapper();

        int resultAdmin = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/assignment1", "root", "");



             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(adminMapper.Insert())) {
//            preparedStatement.setInt(1, 1);
            preparedStatement.setString(1, admin.getEmploymentID());
            preparedStatement.setString(2, admin.getFirstName());
            preparedStatement.setString(3, admin.getLastName());
            preparedStatement.setString(4, admin.getAddress());
            preparedStatement.setString(5, admin.getEmail());
            preparedStatement.setString(6, admin.getPhoneNumber());
            preparedStatement.setString(7, admin.getDateOfBirth());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            resultAdmin = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return resultAdmin;
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

