
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>signup</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <nav class="signup-nav">
        <a href="./home.jsp">Home</a>
    </nav>
    <div class="signup-container">
        <div class="signup-form">
            <form action="SignUpController" autocomplete="off" method="post">
                <label for="name">Name</label>
                <input type="text" name="name" placeholder="Enter Your Name" >
                <br><br>
                <label for="password">Password</label>
                <input type="password" name="password" placeholder="Choose a password" >
                <br><br>
                <label for="mobile">Mobile</label>
                <input type="tel" name="mobile" placeholder="Enter Your Number">
                <br><br>
                <input type="submit" value="Register">
            </form>
        </div>
    </div>
</body>
</html>