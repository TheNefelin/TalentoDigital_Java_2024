<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<a href="supplier_servlet" class="btn btn-primary mb-2">Refrescar Lista</a>

<h1>Lista Proveedores</h1>

<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Nombre</th>
      <th scope="col">Rut</th>
      <th scope="col">Dirección</th>
      <th scope="col">Correo</th>
      <th scope="col">Teléfono</th>
      <th scope="col">Contacto</th>
      <th scope="col">TelContacto</th>
      <th scope="col">Activo</th>
      <th scope="col">Acciones</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="supplier" items="${suppliers}">
      <tr>
        <th scope="row">${supplier.id}</th>
        <td>${supplier.name}</td>
        <td>${supplier.rut}</td>
        <td>${supplier.address}</td>
        <td>${supplier.email}</td>
        <td>${supplier.phone}</td>
        <td>${supplier.contact}</td>
        <td>${supplier.contactPhone}</td>
        <td>
          <input type="checkbox" <c:if test="${supplier.active}">checked</c:if> class="form-check-input" disabled>
        </td>
        <td>
          <a href="supplier_servlet?action=edit&id=${supplier.id}" class="btn btn-warning">
            <i class="fa-solid fa-pen"></i>
          </a>
          <a href="supplier_servlet?action=delete&id=${supplier.id}" class="btn btn-danger">
            <i class="fa-solid fa-trash"></i>
          </a>
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>