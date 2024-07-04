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

  <title>Ejercicio DAO</title>
</head>
<body>

  <section class="container mt-4">
    <form method="post" action="user-servlet">
      <input type="hidden" id="id" name="id"
             value="${user != null ? user.id : ''}">

      <div class="mb-3">
        <label for="name" class="form-label">Nombre</label>
        <input type="text" class="form-control" id="name" name="name" required
               value="${user != null ? user.name : ''}">
      </div>
      <div class="mb-3">
        <label for="surname" class="form-label">Apellido</label>
        <input type="text" class="form-control" id="surname" name="surname" required
               value="${user != null ? user.surname : ''}">
      </div>
      <div class="mb-3">
        <label for="email" class="form-label">Correo</label>
        <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" required
               value="${user != null ? user.email : ''}">
      </div>
      <div class="mb-3">
        <label for="age" class="form-label">Edad</label>
        <input type="number" class="form-control" id="age" name="age" aria-describedby="emailHelp" required
               value="${user != null ? user.age : ''}">
      </div>

      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </section>

  <section class="container">
    <a href="user-servlet" class="btn btn-success mt-4">Cargar Lista de Clientes</a>

    <table class="table">
      <thead>
      <tr>
        <th scope="col">Id</th>
        <th scope="col">Nombre</th>
        <th scope="col">Apellido</th>
        <th scope="col">Email</th>
        <th scope="col">Edad</th>
        <th scope="col">Acciones</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="user" items="${users}">
        <tr>
          <td>${user.id}</td>
          <td>${user.name}</td>
          <td>${user.surname}</td>
          <td>${user.email}</td>
          <td>${user.age}</td>
          <td>
            <a href="user-servlet?action=edit&id=${user.id}" class="btn btn-warning">Editar</a>
            <a href="user-servlet?action=delete&id=${user.id}" class="btn btn-danger" onclick="return confirm('¿Estás seguro de que deseas eliminar este usuario?');">Eliminar</a>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </section>

  <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
      crossorigin="anonymous">
  </script>

</body>
</html>