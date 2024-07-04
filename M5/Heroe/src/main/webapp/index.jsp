<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta charset="ISO-8859-1">

  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
    crossorigin="anonymous">

  <title>Game</title>
</head>
<body>

  <%--
  <header>
    <%@include file="assets/html/nav.jsp"%>
  </header>

  <%@include file="assets/html/carousel.jsp"%>

  <main class="container">
    <div class="grid">
      <%@include file="assets/html/form.jsp"%>
    </div>

    <hr>
    <%@include file="assets/html/list.jsp"%>
  </main>
  --%>

  <%@include file="assets/html/list.jsp"%>

  <%@include file="assets/html/form.jsp"%>

  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
    crossorigin="anonymous">
  </script>

</body>
</html>