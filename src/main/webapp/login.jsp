<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <nav class="login-nav">
        <a href="./home.jsp">Home</a>
    </nav>
    <div class="login-container">
        <div class="login-form">
            <form action="LoginController" method="get">
                <label for="id">ID</label><br>
                <input type="text" name="id" placeholder="Enter Your Id">
                <br>
                <label for="password">Password</label><br>
                <input type="password" name="password" placeholder="Enter Your Password"><br>
                <input type="submit" value="Submit">
            </form>
        </div>
    </div>
</body>
</html>