<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
  <%@include file="assets/components/meta.jsp"%>
  <%@include file="assets/components/bootstrap_css.jsp"%>

  <title>Iniciar Sesión</title>
</head>
<body>

<header>
  <%@include file="assets/components/nav.jsp"%>
</header>

  <main class="container my-4">
    <div class="card">

      <div class="card-header">
        Iniciar Sesión
      </div>

      <form method="post" action="login-servlet" class="m-4">
        <div class="row row-cols-1 row-cols-md-2">
          <div class="mb-3 col">
            <label for="email" class="form-label">Correo</label>
            <input type="email" class="form-control" aria-describedby="emailHelp" required
                   id="email" name="email">
          </div>
          <div class="mb-3 col">
            <label for="password" class="form-label">Clave</label>
            <input type="password" class="form-control" required
                   id="password" name="password">
          </div>
        </div>

        <c:if test="${response.isError()}">
          <div class="alert alert-danger" role="alert">
              ${response.msg}
          </div>
        </c:if>

        <button type="submit" class="btn btn-primary my-2">Iniciar Sesión</button>
      </form>

    </div>
  </main>

  <%@include file="assets/components/bootstrap_css.jsp"%>
</body>
</html>