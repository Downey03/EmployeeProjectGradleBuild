<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Users Database</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="java">
        <%@ page import="java.util.List" %>
        <%@ page import="DTO.Employee" %>
        <%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");
        if(request.getSession().getAttribute("sessionId") == null) response.sendRedirect(request.getContextPath()+"/index.jsp");
        List<Employee> employeeList = (List<Employee>) request.getAttribute("employeeList");
        for(Employee employee :employeeList){
            System.out.println(employee.toString());
        }
        %>
    </div>
    <nav class="details-nav">
        <a href="admin.jsp">Main</a>
        <a href="LogoutController">Logout</a>
    </nav>
    <main class="details-container">
        <div class="container">
            <table class="detail-table">
                <thead>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Number</th>
                </thead>
                <tbody>

                        <%for(Employee employee : employeeList){%>
                    <tr>
                        <td><%out.print(employee.getId());%></td>
                        <td><%out.print(employee.getName());%></td>
                        <td><%out.print(employee.getMobileNumber());%></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </main>
</body>
</html>