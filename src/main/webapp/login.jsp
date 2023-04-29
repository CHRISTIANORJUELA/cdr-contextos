<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/17/2023
  Time: 8:40 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulario de login</title>
</head>
<body>
<% %>
<h1>Iniciar sesión</h1>
<form action="${pageContext.request.contextPath}/login" method="post">
    <div>
        <label for="username">Username</label>
        <div>
            <input type="text" name="username" id="username">
        </div>
    </div>
    <div>
        <label for="password">Password</label>
        <div>
            <input type="password" name="password" id="password">
        </div>
    </div>
    <div>
        <input type="submit" value="Login">
    </div>
</form>
<div>
    <p>Para poder acceder:</p>
    <p>User:Maria</p>
    <p>Password:5</p>
</div>
</body>
</html>