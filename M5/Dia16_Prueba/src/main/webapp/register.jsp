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
        Registrarse
      </div>

      <c:if test="${user.isError()}">
        <div class="alert alert-danger m-4" role="alert">
            ${user.msg}
        </div>
      </c:if>

      <form method="post" action="register_servlet" class="m-4">
        <div class="row row-cols-1 row-cols-md-2">
          <div class="mb-3">
            <input type="email" class="form-control mb-3" aria-describedby="emailHelp" required
                   id="email" name="email" placeholder="Correo">

            <input type="password" class="form-control mb-3" required
                   id="password1" name="password1" placeholder="Clave">

            <input type="password" class="form-control mb-3" required
                   id="password2" name="password2" placeholder="Confirmar Clave">

            <select id="id_rol" name="id_rol" class="form-select mb-3" aria-label="Default select example" required>
              <option selected disabled value="">Seleccione un Rol</option>
              <c:forEach var="rol" items="${roles.getObj()}">
                <option value="${rol.id}">${rol.name}</option>
              </c:forEach>
            </select>

            <input type="text" class="form-control mb-3" required
                   id="name" name="name" placeholder="Nombre">

            <input type="text" class="form-control mb-3" required
                   id="nick" name="nick" placeholder="Apodo">

            <input type="number" class="form-control mb-3" required
                   id="weight" name="weight" placeholder="Peso">

            <input type="text" class="form-control mb-3" required
                   id="address" name="address" placeholder="Dirección">

            <input type="number" class="form-control" required
                   id="address_number" name="address_number" placeholder="Número Dirección">

          </div>

          <div class="mb-3 col">
            <select id="id_car" name="id_car" onchange="updateCarImage()" class="form-select" aria-label="Default select example" required>
              <option selected disabled value="">Seleccione un Auto</option>
              <c:forEach var="car" items="${cars.getObj()}">
                <option value="${car.id}" data-url="${car.url}">${car.name}</option>
              </c:forEach>
            </select>

            <img id="car-image" src="assets/img/img.webp" class="img mt-4 rounded" alt="imagen de autos">

            <div class="text-center m-4">
              <button type="submit" class="btn btn-primary my-2">Registrarse</button>
            </div>
          </div>
        </div>
      </form>
    </div>
  </main>

  <%@include file="assets/components/bootstrap_js.jsp"%>

  <script>
    function updateCarImage() {
      var select = document.getElementById("id_car");
      var image = document.getElementById("car-image");
      var selectedOption = select.options[select.selectedIndex];
      var imageUrl = selectedOption.getAttribute("data-url");

      console.log(imageUrl)

      if (imageUrl) {
        image.src = "assets/img/" + imageUrl;
      }
    }
  </script>
</body>
</html>