<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<main>
    <div>
        <div>
            <p>Este enlace descarga un archivo excel o ejecuta otra dependiendo la extension (Por defecto es .xls)</p>
            <a href="${pageContext.request.contextPath}/productos.xls">Enviar (Formato)</a>
        </div>
        <div>
            <a href="${pageContext.request.contextPath}/productos.json">Enviar Json por Get</a>
        </div>
        <div>
            <form action="${pageContext.request.contextPath}/login.jsp" method="post">
                <button type="submit" name="btn-verificar">enviar a formulario login</button>
            </form>
        </div>
        <div>
            <form action="${pageContext.request.contextPath}/hello-servlet" method="post">
                <button type="submit" name="btn-buscar">Buscar producto login</button>
            </form>
        </div>
    </div>
</main>
</body>
</html>