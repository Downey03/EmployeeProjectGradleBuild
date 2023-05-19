
<%@ page import="javax.servlet.http.HttpServlet" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
      <%
         response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
         response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        if(request.getSession().getAttribute("sessionId") == null) {
        response.sendRedirect(request.getContextPath()+"/index.jsp");
        System.out.println("inredirect inside if");
        } %>
        <p>asf</p>
    <%  String redirection =(String) request.getParameter("redirect");
    System.out.println("inredirect");
    if(redirection==null)   redirection = (String) request.getAttribute("redirect");
    request.getRequestDispatcher(redirection).forward(request,response);
    %>
</body>
</html>