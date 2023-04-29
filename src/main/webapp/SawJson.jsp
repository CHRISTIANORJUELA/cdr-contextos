<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/17/2023
  Time: 9:06 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Json Enviado</title>
</head>
<body>
  <%String json = (String) request.getSession().getAttribute("json");%>

<p><%=json%></p>
</form>
</body>
</html>
