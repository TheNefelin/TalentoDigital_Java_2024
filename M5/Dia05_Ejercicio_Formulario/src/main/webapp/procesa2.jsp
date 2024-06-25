
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Procesa 2</title>
</head>
<body>

    <div>Nombre: <c:out value="${param.nombre}"></c:out> </div>
    <div>Apellido: <c:out value="${param.apellido}"></c:out></div>
    <div>Email: <c:out value="${param.email}"></c:out></div>
    <div>Cargo: <c:out value="${param.cargo}"></c:out></div>

</body>
</html>
