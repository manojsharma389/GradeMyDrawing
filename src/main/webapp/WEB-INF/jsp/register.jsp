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
    <title>register</title>
</head>
<body>
<form action="/registerProcess" method="post" modelAttribute="register">
    <label>User Name : </label>
    <input type="text" name="name"><br><br><br>
    <label>Password : </label>
    <input type="password" name="password"><br><br><br>
    <label>Email : </label>
    <input type="text" name="email"/><br><br><br>

    <label>Role : </label>
    <input type="text" name="role"/><br><br><br>

    <input type="submit" value="Submit"/>
</form>
</body>
</html>
