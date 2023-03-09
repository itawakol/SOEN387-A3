package com.example.assignment2;

import com.example.assignment2.Bean.EnrolledIn;
import com.example.assignment2.Bean.Student;
import com.example.assignment2.DAO.LoginStudentDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "StudentLoginServlet", value = "/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1;
    private LoginStudentDAO loginDAO;

    public void init() {
        loginDAO = new LoginStudentDAO();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Student student = new Student();
        String studentID = request.getParameter("studentID");
        EnrolledIn enrolledIn = new EnrolledIn();
        enrolledIn.setStudentID(studentID);
        student.setStudentID(studentID);
        HttpSession session = request.getSession();
        session.setAttribute("studentID", studentID);
        System.out.println(student.getStudentID());
        try {

            if (loginDAO.validateStudent(student)) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("studentHub.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("error1", "Invalid Student ID");
                System.out.println(request);
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                rd.include(request, response);
            }
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
