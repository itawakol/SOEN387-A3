package com.example.assignment2;

import com.example.assignment2.Bean.Administrator;
import com.example.assignment2.DAO.AdminDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registerAdmin")

public class AdminServlet extends HttpServlet {

    private static final long serialVersionUID = 1;
    private AdminDAO amdinDAO;

    public void init() {
        amdinDAO = new AdminDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String employmentID = request.getParameter("employmentID");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String dateOfBirth = request.getParameter("dateOfBirth");

        Administrator admin = new Administrator();
        admin.setEmploymentID(employmentID);
        admin.setFirstName(firstName);
        admin.setLastName(lastName);
        admin.setAddress(address);
        admin.setEmail(email);
        admin.setPhoneNumber(phoneNumber);
        admin.setDateOfBirth(dateOfBirth);

        try {
            amdinDAO.registerAdmin(admin);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response.sendRedirect("newAdminRegistration.jsp");
        }

        response.sendRedirect("index.jsp");
    }
}
