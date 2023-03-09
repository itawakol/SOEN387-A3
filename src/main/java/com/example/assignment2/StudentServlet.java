    package com.example.assignment2;

    import com.example.assignment2.Bean.Student;
    import com.example.assignment2.DAO.StudentDAO;
    import jakarta.servlet.ServletException;
    import jakarta.servlet.annotation.WebServlet;
    import jakarta.servlet.http.HttpServlet;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    import java.io.IOException;


@WebServlet("/registerStudent")

public class StudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1;
    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String studentID = request.getParameter("studentID");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String dateOfBirth = request.getParameter("dateOfBirth");

        Student student = new Student();
        student.setStudentID(studentID);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setAddress(address);
        student.setEmail(email);
        student.setPhoneNumber(phoneNumber);
        student.setDateOfBirth(dateOfBirth);

        try {
            studentDAO.registerStudent(student);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response.sendRedirect("newStudentRegistration.jsp");
        }

        response.sendRedirect("index.jsp");
    }
}
