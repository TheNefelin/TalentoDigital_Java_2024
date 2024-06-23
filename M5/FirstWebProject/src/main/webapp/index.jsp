<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1">
  <title>Proyecto Demo - Desafio Latam</title>
  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
    crossorigin="anonymous">

  <title>JSP - Hello World</title>
</head>
<body>

  <div class="container">
    <h1>Proyecto Demo 1 - Academia Desafío Latam</h1>
    <div class="row">
      <div class="col-12 col-sm-12">
        <a href="consulta_fechahora.jsp">Consulta Fecha y Hora Actual</a>
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

  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
    crossorigin="anonymous">
  </script>
</body>
</html>