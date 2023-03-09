<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Hub</title>
</head>
<body>
<h1>Admin Hub</h1>
<br>

<div class="createCourse">
    <h2>Create A Course</h2>
    <form method="post" action="<%=request.getContextPath()%>/CourseServlet?create">
        <label>Course Code (ex: COMP387):</label>
        <input type="text" name="courseCode" /> <br><br>

        <label>Title:</label>
        <input type="text" name="title" /> <br><br>

        <label>Semester (ex: Fall 2022):</label>
        <input type="text" name="semester"/> <br><br>

        <label>Days (ex: MoFr):</label>
        <input type="text" name="days"/> <br><br>

        <label>Time (ex: 10:30am):</label>
        <input type="text" name="time"/> <br><br>

        <label>Instructor Name:</label>
        <input type="text" name="instructor"/> <br><br>

        <label>Room:</label>
        <input type="text" name="room" size="4"/> <br><br>

        <label>Start Date (YYYY-MM-DD):</label>
        <input type="text" name="startDate"/> <br><br>

        <label>End Date (YYYY-MM-DD):</label>
        <input type="text" name="endDate"/> <br>
        <br>
        <br>
        <input type="submit" value="Submit" />
    </form>
</div>
<br>
<h2>Student Reports</h2>

<div class="searchByCourse">
    <h3> List of students in a course: </h3>
    <form method="POST" action="<%=request.getContextPath()%>/EnrolledInServlet?studentInCourse">
        <input type="text" name="courseCode" value="Course Code"/>
        <br>
        <input type="submit" value="Submit" />
    </form>
</div>
<br>
<div class="searchByStudent">
    <h3> List of courses taken by a student: </h3>
    <form method="POST" action="<%=request.getContextPath()%>/EnrolledInServlet?courseInStudent">
        <input type="text" name="studentID" value="student ID"/>
        <br>
        <input type="submit" value="Submit" />
    </form>
</div>


</body>
</html>