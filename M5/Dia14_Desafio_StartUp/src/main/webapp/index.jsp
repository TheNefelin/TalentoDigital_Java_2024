<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
  <%@include file="assets/components/meta.jsp"%>
  <%@include file="assets/components/bootstrap_css.jsp"%>

  <title>Dia04 M5 Desafío MVC</title>
</head>
<body>

  <header>
    <%@include file="assets/components/nav.jsp"%>
  </header>

  <main class="container my-4">
    <div class="card">

      <div class="card-header">
        StarUp
      </div>

      <div class="card-body">
        <h5 class="card-title text-center">Bienvenidos a StarUp...</h5>
        <p class="card-text text-center">Inicia Sesión o Regístrate!</p>
        <div class="text-center">
          <a href="login.jsp" class="btn btn-primary">Iniciar Sesión</a>
          <a href="register.jsp" class="btn btn-primary">Regístrate</a>
        </div>
      </div>

    </div>
  </main>

  <%@include file="assets/components/bootstrap_css.jsp"%>
</body>
</html>