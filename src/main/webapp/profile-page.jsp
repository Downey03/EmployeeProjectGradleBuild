
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="java">
        <%@ page import="DTO.Employee" %>
        <%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        if(request.getSession().getAttribute("sessionId") == null) response.sendRedirect(request.getContextPath()+"/index.jsp");
        request.getSession().setAttribute("sessionId",request.getSession().getAttribute("sessionId"));
        Employee employee = (Employee)request.getAttribute("Employee");
        String name = employee.getName();
        String number = employee.getMobileNumber();
        %>
    </div>
    <header class="profile-nav">
        <a href="./home.jsp">Main</a>
        <a href="RemoveAccountController">Delete Account</a>
    </header>
    <div class="profile-container">
        <form action="UpdateController" class="profile-form">
            <label for="name">Name</label><br>
            <input type="text" name="name" value="<%=employee.getName()%>" ><br>
            <label for="number">Number</label><br>
            <input type="number" name="number" value="<%=employee.getMobileNumber()%>"><br>
            <input type="submit"  id="submit" value="Update">
        </form>
    </div>
    
</body>
</html>