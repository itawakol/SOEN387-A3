package com.example.assignment2;

import com.example.assignment2.Bean.Course;
import com.example.assignment2.DAO.CourseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.IOException;

@WebServlet(name = "CourseServlet", value = "/CourseServlet")
public class CourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1;
    private CourseDAO courseDAO;
    public void init() { courseDAO = new CourseDAO(); }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getQueryString().equals("create")){
            String courseCode = request.getParameter("courseCode");
            String title = request.getParameter("title");
            String semester = request.getParameter("semester");
            String days = request.getParameter("days");
            String time = request.getParameter("time");
            String instructor = request.getParameter("instructor");
            String room = request.getParameter("room");
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");

            Course course = new Course();
            course.setCourseCode(courseCode);
            course.setTitle(title);
            course.setSemester(semester);
            course.setDays(days);
            course.setTime(time);
            course.setInstructor(instructor);
            course.setRoom(room);
            course.setStartDate(startDate);
            course.setEndDate(endDate);

            try{
                courseDAO.createCourse(course);
            } catch (Exception e){
                e.printStackTrace();
                response.sendRedirect("adminHub.jsp");
            }
            response.sendRedirect("adminHub.jsp");

        }

    }
}
