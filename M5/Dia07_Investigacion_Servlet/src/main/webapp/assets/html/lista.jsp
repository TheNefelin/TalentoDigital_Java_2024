<%@ page import="cl.praxis.game.services.ServicioHeroe" %>
<%@ page import="cl.praxis.game.models.Personaje" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%
    ServicioHeroe sh = ServicioHeroe.getInstancia();
%>

<table class="table table-dark table-striped">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Nombre</th>
        <th scope="col">Sexo</th>
        <th scope="col">Fuerza</th>
        <th scope="col">Defensa</th>
        <th scope="col">Vida</th>
    </tr>
    </thead>
    <tbody>

        <% for (Personaje personaje : sh.listaHeroes()) { %>
        <tr>
            <th scope="row"><%= personaje.getId() %></th>
            <td><%= personaje.getNombre() %></td>
            <td><%= personaje.getGenero() %></td>
            <td><%= personaje.getFuerza() %></td>
            <td><%= personaje.getDefensa() %></td>
            <td><%= personaje.getVida() %></td>
        </tr>
        <% } %>

        <%--
        <c:forEach var="personaje" items="${heroes}">
            <tr>
                <th scope="row">${personaje.id}</th>
                <td>${personaje.nombre}</td>
                <td>${personaje.genero}</td>
                <td>${personaje.fuerza}</td>
                <td>${personaje.defensa}</td>
                <td>${personaje.vida}</td>
            </tr>
        </c:forEach>
        --%>
    </tbody>
</table>
