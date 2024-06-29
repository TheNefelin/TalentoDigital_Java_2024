<%@ page import="cl.praxis.game.models.Genero" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="generos" value="<%= Genero.values() %>"/>

<form method="post" action="heroe-servlet">
    <h1>Nuevo Heroe</h1>

    <fieldset class="mb-0">
        <input type="text" name="nombre" placeholder="Nombre" required/>
        <select name="genero" required>
            <option selected disabled value="">Seleccione el Genero</option>
            <c:forEach var="genero" items="${generos}">
                <option value="${genero}">${genero}</option>
            </c:forEach>
        </select>
        <input type="number" name="fuerza" placeholder="Fuerza" required/>
        <input type="number" name="defensa" placeholder="Defensa" required/>
        <input type="number" name="vida" placeholder="Vida" required/>
        <input type="submit" value="CREAR!"/>
    </fieldset>
</form>
