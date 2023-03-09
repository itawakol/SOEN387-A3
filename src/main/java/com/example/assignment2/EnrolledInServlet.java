package com.example.assignment2;

import com.example.assignment2.Bean.EnrolledIn;
import com.example.assignment2.DAO.EnrolledInDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EnrolledInServlet", value = "/EnrolledInServlet")
public class EnrolledInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getQueryString().equals("courseInStudent")) {
            String studentID = request.getParameter("studentID");
            EnrolledIn enrolledIn = new EnrolledIn();
            enrolledIn.setStudentID(studentID);
            HttpSession session = request.getSession();
            session.setAttribute("studentID", studentID);
            try {
                RequestDispatcher dispatcher = request.getRequestDispatcher("courseInStudent.jsp");
                dispatcher.forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("adminHub.jsp");
            }
        }else if(request.getQueryString().equals("studentInCourse")){
            String courseCode = request.getParameter("courseCode");
            EnrolledIn course = new EnrolledIn();
            course.setCourseCode1(courseCode);
            HttpSession session = request.getSession();
            session.setAttribute("courseCode", courseCode);
            try{
                RequestDispatcher dispatcher = request.getRequestDispatcher("studentInCourse.jsp");
                dispatcher.forward(request, response);
            } catch (Exception eX) {
                eX.printStackTrace();
                response.sendRedirect("adminHub.jsp");
            }
        }else if(request.getQueryString().equals("enrollStudent")){
            EnrolledIn course = new EnrolledIn();
            EnrolledInDAO enrolDAO = new EnrolledInDAO();
            String courseCode = request.getParameter("courseCode");
            HttpSession session = request.getSession();
            String studentID = (String) session.getAttribute("studentID");
            course.setStudentID(studentID);
            try{
                int result = enrolDAO.enrollStudent(course, courseCode);
                if(result != 0) {
                    request.setAttribute("success", "registered in course");
                    RequestDispatcher rd = request.getRequestDispatcher("/studentHub.jsp");
                    rd.include(request, response);
                } else{
                    request.setAttribute("error", "Failed to register");
                    RequestDispatcher rd = request.getRequestDispatcher("/studentHub.jsp");
                    rd.include(request, response);
                }
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }else if(request.getQueryString().equals("dropStudent")){
            EnrolledIn student = new EnrolledIn();
            EnrolledInDAO DAO = new EnrolledInDAO();
            String courseCode = request.getParameter("courseCode");
            HttpSession session = request.getSession();
            String studentID = (String) session.getAttribute("studentID");
            student.setStudentID(studentID);
            try{
                int result = DAO.dropStudent(student,courseCode);
                if(result!=0){
                    request.setAttribute("dropped", "course is dropped");
                    RequestDispatcher rd = request.getRequestDispatcher("/studentHub.jsp");
                    rd.include(request, response);
                }else{
                    request.setAttribute("fail", "course is not dropped");
                    RequestDispatcher rd = request.getRequestDispatcher("/studentHub.jsp");
                    rd.include(request,response);
                }
            }catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
