package com.example.assignment2;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.*;
import com.example.assignment2.DAO.LoginAdminDAO;
import com.example.assignment2.Bean.Administrator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static java.lang.System.out;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1;

    private LoginAdminDAO loginDao;

    public void init() {
        loginDao = new LoginAdminDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employmentID = request.getParameter("employmentID");
        Administrator administrator = new Administrator();
        administrator.setEmploymentID(employmentID);
        out.println(employmentID);
        try{
            if (loginDao.validate(administrator)) {
                response.sendRedirect("adminHub.jsp");
            } else {
                request.setAttribute("error", "invalid admin ID");
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                rd.include(request, response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
