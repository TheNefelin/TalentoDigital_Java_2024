<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
  <%@include file="assets/components/meta.jsp"%>
  <%@include file="assets/components/bootstrap_css.jsp"%>

  <title>Registrarse</title>
</head>
<body>

  <header>
    <%@include file="assets/components/nav.jsp"%>
  </header>

  <main class="container my-4">
    <div class="card mb-4">

      <div class="card-header">
        Home
      </div>

      <h3 class="text-center m-2">${user.getMsg()}</h3>
      <hr>

      <section class="row row-cols-1 row-cols-md-2">
        <article class="col p-4">
          <h4 class="text-center">Usuario</h4>

          <div class="card-body text-center">
            <div class="card m-auto" style="width: 18rem;">
              <img src="assets/img/Yo.png" class="card-img-top" alt="img perfil">
              <div class="card-body">
                <h5 class="card-title">${user.obj.getName()}</h5>
                <h5 class="card-title">${user.obj.getEmail()}</h5>
                <a href="#" class="btn btn-primary m-2">Cerrar Sesion</a>
              </div>
            </div>
          </div>
        </article>

        <article class="col m-auto p-4">
          <h4 class="text-center">Lista de Proveedores</h4>

          <table class="table col">
            <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Proveedores</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="supplier" items="${suppliers.getObj()}">
              <tr>
                <th scope="row">${supplier.id}</th>
                <td>${supplier.name}</td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </article>

      </section>
    </div>

    <div class="card">
      <div class="card-header">
        Registro de Trabajadores
      </div>

      <table class="table col">
        <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Correo</th>
          <th scope="col">Nombre</th>
          <th scope="col">Apodo</th>
          <th scope="col">Peso</th>
          <th scope="col">Creacion</th>
          <th scope="col">Actualizado</th>
          <th scope="col">Rol</th>
          <th scope="col">Auto</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users.getObj()}">
          <tr>
            <th scope="row">${user.id}</th>
            <td>${user.email}</td>
            <td>${user.name}</td>
            <td>${user.nick}</td>
            <td>${user.weight}</td>
            <td>${user.date_create}</td>
            <td>${user.date_update}</td>
            <td>${user.rol}</td>
            <td class="my-img">
              <img src="assets/img/${user.url}" class="img" alt="auto">
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>

    </div>
  </main>

  <%@include file="assets/components/bootstrap_js.jsp"%>
</body>
</html>