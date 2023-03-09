<%--
  Created by IntelliJ IDEA.
  User: Ibrahim  Tawakol
  Date: 2022-11-24
  Time: 4:53 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.sql.*"%>
<html>
<head>
    <title>List of courses</title>
</head>
<%
    String studentID = session.getAttribute("studentID").toString();
    Class.forName("com.mysql.cj.jdbc.Driver");
    String COURSE_IN_STUDENT = "SELECT studentID, courseCode1, courseCode2, courseCode3, courseCode4, courseCode5 FROM enrolledin WHERE studentID= '"+ studentID +"'";
    String AVAILABLE_COURSES = "SELECT * FROM course";
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment1", "root", "");

    Statement statement1 = conn.createStatement();
    ResultSet rs1 = statement1.executeQuery(COURSE_IN_STUDENT);
    Statement statement2 = conn.createStatement();
    ResultSet rs2 = statement2.executeQuery(AVAILABLE_COURSES);
%>
<body>
<table>
    <tr>
        <th>student ID</th>
        <th>course1</th>
        <th>course2</th>
        <th>course3</th>
        <th>course4</th>
        <th>course5</th>
    </tr>
    <TR>
        <TD> <%out.println(studentID); %></td>
        <% while(rs1.next()){ %>
        <TD> <%= rs1.getString(2) %></TD>
        <TD> <%= rs1.getString(3) %></TD>
        <TD> <%= rs1.getString(4) %></TD>
        <TD> <%= rs1.getString(5) %></TD>
        <TD> <%= rs1.getString(6) %></TD>
    </TR>
    <% } %>
</table>
<table>
    <tr>
        <th> Course Code </th>
        <th> Title </th>
        <th> Semester </th>
        <th> Days </th>
        <th> Time </th>
        <th> Instructor </th>
        <th> Room </th>
        <th> Start date</th>
        <th> End date </th>
    </tr>
    <% while(rs2.next()){ %>
    <TR>
        <TD> <%= rs2.getString(1) %></td>
        <TD> <%= rs2.getString(2) %></TD>
        <TD> <%= rs2.getString(3) %></TD>
        <TD> <%= rs2.getString(4) %></TD>
        <TD> <%= rs2.getString(5) %></TD>
        <TD> <%= rs2.getString(6) %></TD>
        <TD> <%= rs2.getString(7) %></TD>
        <TD> <%= rs2.getString(8) %></TD>
        <TD> <%= rs2.getString(9) %></TD>
    </TR>
    <% } %>
</table>
<%
    String login_msg1 = (String)request.getAttribute("error");
    String login_msg2 = (String) request.getAttribute("success");
    if (login_msg2!=null)
        out.println("<font color=red size=4px>\"registered successfully\"</font>");
    if(login_msg1!=null)
        out.println("<font color=red size=4px>\"registration failed\"</font>");
%>
<form method="POST" action=" <%=request.getContextPath()%>/EnrolledInServlet?enrollStudent">
    <p>Course Code</p>
    <input type="text" name="courseCode" size="8" /><br><br>
    <input type="submit" value="Register" />
</form>
<%
    String login_msg3 = (String)request.getAttribute("fail");
    String login_msg4 = (String) request.getAttribute("dropped");
    if (login_msg3!=null)
        out.println("<font color=red size=4px>\"Dropped successfully\"</font>");
    if(login_msg4!=null)
        out.println("<font color=red size=4px>\"Drop failed\"</font>");
%>
<form method="POST" action=" <%=request.getContextPath()%>/EnrolledInServlet?dropStudent">
    <p>Course Code</p>
    <input type="text" name="courseCode" size="8" /><br><br>
    <input type="submit" value="Drop" />
</form>
<br>
<a href="index.jsp">
    <button type="submit">Logout</button>
</a>
</body>
</html>
