<%--
  Created by IntelliJ IDEA.
  User: manoj
  Date: 18/1/18
  Time: 1:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="${pageContext.request.contextPath}/j_spring_security_check" method="post" modelAttribute="login">
    <input type="text" name="j_username"/><br><br>
    <input type="password" name="j_password"/><br><br>
    <input type="submit" name="Submit">
</form>
</body>
</html>
