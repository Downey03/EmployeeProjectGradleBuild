
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SignUp Successful</title>
</head>
<body>
    <%  String msg = (String) request.getAttribute("msg");
        if(msg!=null)
        out.println(msg);%>
</body>
</html>