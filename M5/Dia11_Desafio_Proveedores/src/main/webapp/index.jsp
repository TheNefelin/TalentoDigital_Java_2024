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

  <script src="https://kit.fontawesome.com/5499527a0e.js" crossorigin="anonymous"></script>

  <title>Desafío M5 Dia 11 Proveedores</title>
</head>
<body data-bs-theme="dark">

  <header>
    <%@include file="assets/components/nav.jsp"%>
  </header>

  <main class="mb-4">
    <section class="container mt-4 p-4 bg-secondary-subtle rounded">
      <%@include file="assets/components/form.jsp"%>
    </section>

    <section class="container mt-4 p-4 bg-secondary-subtle rounded">
      <%@include file="assets/components/list.jsp"%>
    </section>
  </main>


  <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
      crossorigin="anonymous">
  </script>
</body>
</html>