<%@ page import="cl.praxis.dia02_ejercicio.utils.GeneralUtilities" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    GeneralUtilities utils = new GeneralUtilities();
    String date = utils.getDate();
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <title>Title</title>
</head>
<body>

    <div class="container">
        <h1>Consulta Fecha Hora</h1>
        <div class="row">
            <div class="col-12 col-sm-12">
                La Fecha y Hora
                actual es: <%=date%>
            </div>
        </div>
    </div>

    <hr>

    <div class="container">
        <h1>Proyecto Demo 1 - Academia Desafío Latam</h1>
        <div class="row">
            <div class="col-12 col-sm-12">
                <a href="dia02_ejercicio.jsp">Consulta Fecha y Hora Actual</a>
            </div>
        </div>
        <div class="col-12 col-sm-12">
            <a href="specific_query?valor=hombre">Consulta Específica - Hombre</a>
        </div>
        <div class="row">
            <div class="col-12 col-sm-3">
                <a href="specific_query?valor=mujer">Consulta Específica - Mujer</a>
            </div>
        </div>
    </div>

</body>
</html>
