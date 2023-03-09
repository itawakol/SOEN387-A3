<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Online Course Registration</title>
</head>
<body>
<div class="Admin" >
    <h1>Online Course Registration</h1>
    <form action="<%= request.getContextPath() %>/registerAdmin" method="post">
        <table style="width: 80%">
            <tr>
                <td>employment ID</td>
                <td><label>
                    <input type="text" name="employmentID" />
                </label></td>
            </tr>
            <tr>
                <td>First Name</td>
                <td><label>
                    <input type="text" name="firstName" />
                </label></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><label>
                    <input type="text" name="lastName" />
                </label></td>
            </tr>
            <tr>
                <td>Address</td>
                <td><label>
                    <input type="text" name="address" />
                </label></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><label>
                    <input type="text" name="email" />
                </label></td>
            </tr>
            <tr>
                <td>Phone Number</td>
                <td><label>
                    <input type="text" name="phoneNumber" />
                </label></td>
            </tr>
            <tr>
                <td>Date of Birth</td>
                <td><label>
                    <input type="text" name="dateOfBirth" />
                </label></td>
            </tr>
        </table>
        <input type="submit" value="Submit" />
    </form>
</div>

</body>
</html>
