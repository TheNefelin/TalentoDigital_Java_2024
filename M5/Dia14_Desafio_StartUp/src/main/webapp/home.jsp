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
    <div class="card">

      <div class="card-header">
        Home
      </div>

      <h3 class="text-center m-2">${response.getMsg()}</h3>

      <div class="card-body m-auto text-center">
        <div class="card" style="width: 18rem;">
          <img src="assets/img/Yo.png" class="card-img-top" alt="img perfil">
          <div class="card-body">
            <h5 class="card-title">${response.obj.getName()}</h5>
            <h5 class="card-title">${response.obj.getEmail()}</h5>
            <a href="#" class="btn btn-primary m-2">Cerrar Sesion</a>
          </div>
        </div>
      </div>

    </div>
  </main>

  <%@include file="assets/components/bootstrap_css.jsp"%>
</body>
</html>