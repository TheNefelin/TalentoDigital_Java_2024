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
        Registrarse
      </div>

      <form method="post" action="register_servlet" class="m-4">
        <div class="row row-cols-1 row-cols-md-3">
          <div class="mb-3">
            <label for="email" class="form-label">Correo</label>
            <input type="email" class="form-control" aria-describedby="emailHelp" required
                   id="email" name="email">
          </div>
          <div class="mb-3 col">
            <label for="password1" class="form-label">Clave</label>
            <input type="password" class="form-control" required
                   id="password1" name="password1">
          </div>
          <div class="mb-3 col">
            <label for="password2" class="form-label">Confirmar Clave</label>
            <input type="password" class="form-control" required
                   id="password2" name="password2">
          </div>
          <div class="mb-3 col">
            <label for="name" class="form-label">Nombre</label>
            <input type="text" class="form-control" required
                   id="name" name="name">
          </div>
          <div class="mb-3 col">
            <label for="nick" class="form-label">Apodo</label>
            <input type="text" class="form-control" required
                   id="nick" name="nick">
          </div>
          <div class="mb-3 col">
            <label for="weight" class="form-label">Peso</label>
            <input type="number" class="form-control" required
                   id="weight" name="weight">
          </div>
        </div>

        <c:if test="${response.isError()}">
          <div class="alert alert-danger" role="alert">
              ${response.msg}
          </div>
        </c:if>

        <button type="submit" class="btn btn-primary my-2">Registrarse</button>
      </form>

    </div>
  </main>

  <%@include file="assets/components/bootstrap_css.jsp"%>
</body>
</html>