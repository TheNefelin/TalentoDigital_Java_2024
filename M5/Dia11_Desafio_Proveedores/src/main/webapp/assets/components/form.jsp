<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<form class="container" method="post" action="supplier_servlet">
  <h1>Fromulario</h1>

  <input type="hidden"
         id="id" name="id"
         value="${supplier != null ? supplier.id : "" }">

  <div class="row row-cols-1 row-cols-md-3">
    <div class="mb-3 col">
      <label for="name" class="form-label">Nombre</label>
      <input type="text" class="form-control" required
             id="name" name="name" placeholder="Isaac Netero"
             value="${supplier != null ? supplier.name : "" }">
    </div>
    <div class="mb-3 col">
      <label for="rut" class="form-label">Rut</label>
      <input type="text" class="form-control" required
             id="rut" name="rut" placeholder="12354678-K"
             value="${supplier != null ? supplier.rut : "" }">
    </div>
    <div class="mb-3 col">
      <label for="address" class="form-label">Dirección</label>
      <input type="text" class="form-control" required
             id="address" name="address" placeholder="Valparaíso 123"
             value="${supplier != null ? supplier.address : "" }">
    </div>
    <div class="mb-3 col">
      <label for="email" class="form-label">Correo</label>
      <input type="email" class="form-control" aria-describedby="emailHelp" required
             id="email" name="email" placeholder="praxis@praxis.cl"
             value="${supplier != null ? supplier.email : "" }">
    </div>
    <div class="mb-3 col">
      <label for="phone" class="form-label">Teléfono</label>
      <input type="number" class="form-control" required
             id="phone" name="phone" placeholder="987654321"
             value="${supplier != null ? supplier.phone : "" }">
    </div>
    <div class="mb-3 col">
      <label for="contact" class="form-label">Contacto</label>
      <input type="text" class="form-control" required
             id="contact" name="contact" placeholder="Zeno Zoldyck"
             value="${supplier != null ? supplier.contact : "" }">
    </div>
    <div class="mb-3 col">
      <label for="contactPhone" class="form-label">Teléfono de Contacto</label>
      <input type="number" class="form-control" required
             id="contactPhone" name="contactPhone" placeholder="987654321"
             value="${supplier != null ? supplier.contactPhone : "" }">
    </div>
  </div>

  <div class="mb-3 col">
    <input type="checkbox" class="form-check-input"
           id="isActive" name="isActive"
           <c:if test="${supplier.active}">checked</c:if>
    >
    <label class="form-check-label" for="isActive">Activo</label>
  </div>

  <button type="submit" class="btn btn-primary mt-2">
    ${supplier == null ? "Crear" : "Editar" }
  </button>
</form>
