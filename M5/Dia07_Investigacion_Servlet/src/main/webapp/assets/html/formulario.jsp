<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="cl.praxis.game.models.Genero" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<form method="post" action="heroe-servlet" class="bg-dark p-4 text-white">

    <!--  Formulario -->
    <section class="bg-dark">
        <div class="container px-4 px-lg-5">
            <h1>Agregar Nuevo Heroe</h1>
            <hr />

            <div class="row g-3">
                <div class="col-md-6">
                    <label for="nombre" class="form-label">Nombre</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" value="Arturo Erasmo">
                </div>

                <div class="col-md-6">
                    <label for="genero" class="form-label">Genero</label>
                    <select id="genero" name="genero" class="form-select">
                        <% for (Genero genero: Genero.values()) { %>
                        <option value="<%= genero %>"><%= genero %></option>
                        <% } %>
                    </select>
                </div>

                <div class="col-md-4">
                    <label for="fuerza" class="form-label">Fuerza</label>
                    <input type="number" class="form-control" id="fuerza" name="fuerza" value="arturo.vidal@anfp.cl">
                </div>

                <div class="col-md-4">
                    <label for="defensa" class="form-label">Defensa</label>
                    <input type="number" class="form-control" id="defensa" name="defensa" value="arturo.vidal@anfp.cl">
                </div>

                <div class="col-md-4">
                    <label for="vida" class="form-label">Vida</label>
                    <input type="number" class="form-control" id="vida" name="vida" value="arturo.vidal@anfp.cl">
                </div>

                <div class="col-12">
                    <hr />
                    <button type="submit" class="btn btn-primary">CREAR HEROE!</button>
                </div>
            </div>
        </div>
    </section>
</form>
