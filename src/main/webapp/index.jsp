<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Online Registration</title>
</head>
<body>
<h1>Online Course Registration</h1>
<br>
<div class="student">
    <h2>Student</h2>

    <%
        String login_msg1 = (String)request.getAttribute("error1");
        if (login_msg1!=null)
            out.print("<font color=red size=4px>\"Invalid student ID\"</font>");
    %>
    <form method="POST" action="<%=request.getContextPath()%>/StudentLoginServlet">
        <p>Student ID (8 digits):</p>
        <input type="text" name="studentID" size="8" /><br><br>
        <input type="submit" value="Sign In" />
    </form> <br>
    <a href="newStudentRegistration.jsp">
        <button type="submit">Don't have an account? Register here!</button>
    </a>

</div>

<div class="admin">

    <h2>Administrator</h2>
    <%
        String login_msg = (String)request.getAttribute("error");
        if (login_msg!=null)
            out.print("<font color=red size=4px>\"Invalid Admin ID\"</font>");
    %>
    <form action="<%=request.getContextPath()%>/adminLogin" method="post">
            <tr>
                <td>Administrator ID (8 digits)</td> <br>
                <td><input type="text" name="employmentID" /></td>
            </tr>
        </table>
        <br>
        <input type="submit" value="Submit" />
    </form> <br>
    <a href="newAdminRegistration.jsp">
        <button type="submit">Don't have an account? Register here!</button>
    </a>

</div>


</body>
</html>