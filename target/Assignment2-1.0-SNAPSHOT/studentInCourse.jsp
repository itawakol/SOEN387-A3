<%--
  Created by IntelliJ IDEA.
  User: Ibrahim  Tawakol
  Date: 2022-11-25
  Time: 11:45 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*"%>
<html>
<head>
    <title>List of students</title>
</head>
<%
    String courseCode = session.getAttribute("courseCode").toString();

    Class.forName("com.mysql.cj.jdbc.Driver");
    String STUDENT_IN_COURSE = "SELECT studentID FROM enrolledin WHERE courseCode1= '" + courseCode + "'or courseCode2= '" + courseCode
            + "' or courseCode3='" + courseCode + "' or courseCode4= '" + courseCode + "' or courseCode5= '" + courseCode + "'";
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment1", "root", "");
    System.out.println(STUDENT_IN_COURSE);
    Statement statement = conn.createStatement();
    ResultSet rs = statement.executeQuery(STUDENT_IN_COURSE);
%>
<body>
<table>
    <tr>
        <th>student ID </th>
    </tr>
    <% while(rs.next()){ %>
    <TR>
        <TD> <%=rs.getString(1)%></td>
    </tr>
    <%}%>
</table>
</body>
</html>
