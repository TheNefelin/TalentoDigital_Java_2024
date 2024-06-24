<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initialscale=1">
    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">
    <title>Actividad Día 4</title>
</head>
<body>

    <%-- Actividad 1 --%>
    <h3>Actividad 1 - C:OUT</h3>
    <div class="container">
        <c:set var="test" value="2"/>
        <div>Contenido de Variable: <c:out value="${test}"/></div>
        <div>Presenta información: <c:out value="Solo un texto"/></div>
    </div>

    <hr>

    <%-- Actividad 2 --%>
    <h3>Actividad 2 - C:IF - C:CHOOSE</h3>
    <div class="container">
        <c:set var = "sueldo" value = "${800000}"/>
        <p>Tu sueldo : <c:out value = "${sueldo}"/></p>

        <c:choose>
            <c:when test = "${sueldo <= 300000}">
                Sueldo igual o inferior al mínimo
            </c:when>

            <c:when test = "${sueldo > 1000}">
                Sueldo superior al mínimo
            </c:when>

            <c:otherwise>
                No existen comentarios asociados...
            </c:otherwise>
        </c:choose>
    </div>

    <hr>

    <%-- Actividad 3 --%>
    <h3>Actividad 3 - C:FOREACH</h3>
    <div class="container">
        <c:forEach var = "i" begin = "1" end = "50">
            <div>
                <a href="https://www.google.com/search?q=imagenes+numero+<c:out value = "${i}"/>">
                    Buscar imágenes del número <c:out value = "${i}"/> en Google
                </a>
            </div>
        </c:forEach>
    </div>

    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>