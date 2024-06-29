<%@ page import="cl.praxis.game.models.Personaje" %>
<%@ page import="cl.praxis.game.services.ServicioHeroe" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    String nombre = request.getParameter("nombre");
    int fuerza = 0;
    int defensa = 0;
    int vida = 0;

    if (!request.getParameter("fuerza").isBlank())
        fuerza = Integer.parseInt(request.getParameter("fuerza"));

    if (!request.getParameter("defensa").isBlank())
        defensa = Integer.parseInt(request.getParameter("defensa"));

    if (!request.getParameter("vida").isBlank())
        vida = Integer.parseInt(request.getParameter("vida"));

    Personaje nuevoPersonaje = new Personaje();

    nuevoPersonaje.setNombre(nombre);
    nuevoPersonaje.setFuerza(fuerza);
    nuevoPersonaje.setDefensa(defensa);
    nuevoPersonaje.setVida(vida);

    ServicioHeroe sh = ServicioHeroe.getInstancia();
    sh.nuevoHeroe(nuevoPersonaje);
%>

<!DOCTYPE html>

<%@include file="assets/html/head.jsp"%>

<body>

    <% for (Personaje pj: sh.listaHeroes()) { %>
        <div><%= pj.getNombre() %></div>
    <% } %>

    <!-- Section-->
    <section class="py-5">
        <div class="container px-4 px-lg-5 mt-5">

            <div class="row justify-content-center">
                <h1>
                    Bienvenido Nuevo Heroe!!!:
                </h1>
                <hr />
            </div>
        </div>

        <div class="container px-4 px-lg-5 mt-5">

            <table class="table">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Item</th>
                    <th scope="col">Valor</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>Nombre</td>
                    <td><%=nombre%></td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>Fuerza</td>
                    <td><%=fuerza%></td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>Defensa</td>
                    <td><%=defensa%></td>
                </tr>
                <tr>
                    <th scope="row">4</th>
                    <td>Vida</td>
                    <td><%=vida%></td>
                </tr>
                </tbody>
            </table>

        </div>
    </section>

    <section class="container">
        <%@include file="assets/html/lista.jsp"%>
    </section>

</body>
</html>
