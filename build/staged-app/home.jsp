<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link rel="stylesheet" href="styles.css">
</head>

<body>
    <div class="java">
        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "0");
            if(request.getSession().getAttribute("sessionId") == null) response.sendRedirect(request.getContextPath()+"/index.jsp");
        %>
    </div>

    <nav class="home-nav">
        <div class="details">
            <a href="DisplayController">Profile</a>
        </div>
        <div class="links">
            <a href="LogoutController">Logout</a>
        </div>
    </nav>
    <main class="home-main"></main>
</body>
</html>