
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Procesa</title>
</head>
<body>

    <%
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String cargo = request.getParameter("cargo");
    %>

    <div>Nombre: <%=nombre%></div>
    <div>Apellido: <%=apellido%></div>
    <div>Email: <%=email%></div>
    <div>Cargo: <%=cargo%></div>

</body>
</html>
