<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<form>
  <h1>Fromulario</h1>

  <input type="hidden"
         id="id" name="id"
         value="">

  <div class="mb-3">
    <label for="name" class="form-label">Nombre</label>
    <input type="text" class="form-control" required
           id="name" name="name" placeholder="Isaac Netero"
           value="">
  </div>
  <div class="mb-3">
    <label for="name" class="form-label">Rut</label>
    <input type="text" class="form-control" required
           id="rut" name="rut" placeholder="12354678-K"
           value="">
  </div>
  <div class="mb-3">
    <label for="name" class="form-label">Dirección</label>
    <input type="text" class="form-control" required
           id="address" name="address" placeholder="Valparaíso 123"
           value="">
  </div>
  <div class="mb-3">
    <label for="name" class="form-label">Correo</label>
    <input type="email" class="form-control" aria-describedby="emailHelp" required
           id="email" name="email" placeholder="praxis@praxis.cl"
           value="">
  </div>
  <div class="mb-3">
    <label for="name" class="form-label">Teléfono</label>
    <input type="number" class="form-control" required
           id="phone" name="phone" placeholder="987654321"
           value="">
  </div>
  <div class="mb-3">
    <label for="name" class="form-label">Contacto</label>
    <input type="text" class="form-control" required
           id="contact" name="contact" placeholder="Zeno Zoldyck"
           value="">
  </div>
  <div class="mb-3">
    <label for="name" class="form-label">Teléfono de Contacto</label>
    <input type="number" class="form-control" required
           id="contact_phone" name="contact_phone" placeholder="987654321"
           value="">
  </div>

  <button type="submit" class="btn btn-primary mt-2">Crear | Editar</button>
</form>
