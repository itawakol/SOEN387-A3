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

  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment1", "root", "");

  Statement statement = conn.createStatement();
  System.out.println(COURSE_IN_STUDENT);
  ResultSet rs = statement.executeQuery(COURSE_IN_STUDENT);
%>
<body>
<table>
  <tr>
    <th>student name</th>
    <th>course1</th>
    <th>course2</th>
    <th>course3</th>
    <th>course4</th>
    <th>course5</th>
  </tr>
  <% while(rs.next()){ %>
  <TR>
    <TD> <%= rs.getString(1) %></td>
    <TD> <%= rs.getString(2) %></TD>
    <TD> <%= rs.getString(3) %></TD>
    <TD> <%= rs.getString(4) %></TD>
    <TD> <%= rs.getString(5) %></TD>
    <TD> <%= rs.getString(6) %></TD>
  </TR>
  <% } %>
</table>
</body>
</html>
