<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="cl.praxis.webapp.models.GeneralUtilities" %>
<%
    GeneralUtilities utils = new GeneralUtilities();
    String date = utils.getDate();
%>
<!doctype html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
            crossorigin="anonymous">
    <title>Date</title>
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

    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
        crossorigin="anonymous">
    </script>

</body>
</html>
