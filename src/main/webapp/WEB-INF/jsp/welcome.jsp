<%--
  Created by IntelliJ IDEA.
  User: manoj
  Date: 18/1/18
  Time: 2:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
    <link rel="shortcut icon" href="">
</head>
<body>
<h1>Welcome Bitch</h1>
<h1>${userName}</h1>
<h1>${email}</h1> <br>
<a href="${pageContext.request.contextPath}/j_spring_security_logout">Logout</a>
</body>
</html>
