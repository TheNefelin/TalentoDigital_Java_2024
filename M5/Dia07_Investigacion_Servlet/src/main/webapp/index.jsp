<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>

<%@include file="assets/html/head.jsp"%>

<body>
  <section class="container ">
    <h1 class="text-center"><%= "HEROES!" %></h1>

    <div class="row">
      <div class="col-md-6">
        <%@include file="assets/html/header.jsp"%>
      </div>

      <div class="col-md-6">
        <%@include file="assets/html/formulario.jsp"%>
      </div>
    </div>
  </section>

  <section class="container ">
    <%@include file="assets/html/lista.jsp"%>
  </section>

  <%@include file="assets/html/footer.jsp"%>

  <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
    crossorigin="anonymous">
  </script>

  </body>
</html>