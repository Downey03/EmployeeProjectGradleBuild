
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link rel="text/stylesheet" href="styles.css">
</head>
<body>
    <nav>
        <% System.out.println("inhomejsp"+ request.getSession().getAttribute("sessionId"));
            request.setAttribute("sessionId",request.getAttribute("sessionId"));
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "0");
            if(request.getSession().getAttribute("sessionId") == null) response.sendRedirect(request.getContextPath()+"/index.jsp");
            %>
        <span><a href="update.jsp">Update</a></span>
        <span><a href="RemoveAccountController">RemoveAccount</a></span>
        <span><a href="DisplayController">Display Details</a></span>
       <span><a href="LogoutController">Logout</a></span>
    </nav>
</body>
</html>