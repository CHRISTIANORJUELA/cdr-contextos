<%@ page import="com.example.practica_metodos.models.Producto" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 4/17/2023
  Time: 9:14 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buscar Producto</title>
</head>
<body>
<%Producto producto = (Producto) request.getAttribute("obj");%>
<main style="max-height: max-content ; display: flex ; justify-content: center; align-content: center">
    <div>
        <form action="${pageContext.request.contextPath}/buscarProducto" method="post">
            <input name="idproducto">
            <button type="submit">Enviar</button>
        </form>
        <div>
            <p>Productos con id 1,2,3</p>
        </div>
    </div>
<%if (producto != null){%>
    <div>
        <p><%=producto%></p>
    </div>
<%}%>
</main>
</body>
</html>
