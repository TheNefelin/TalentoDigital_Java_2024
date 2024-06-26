<%@ page import="cl.praxis.model.Habitacion" %>
<%@ page import="java.util.List" %>
<%@ page import="cl.praxis.business.HabitacionBusiness" %>
<%@ page import="cl.praxis.utils.Util" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    HabitacionBusiness habitacionB = new HabitacionBusiness();
    List<Habitacion> listaHabitaciones = habitacionB.getHabitaciones();

    Util util = new Util();
%>

<!DOCTYPE html>
<html lang="es">

<%@include file="assets/html/head.jsp"%>

<body>
    <%@include file="assets/html/header.jsp"%>

    <form method="post" action="procesa.jsp">

        <!-- Section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">

                <div class="row justify-content-center">
                    <h1>
                        Eventos Disponibles (<%=listaHabitaciones.size()%>)
                    </h1>
                    <hr/>
                </div>

                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    <%
                        for (int x = 0; x < listaHabitaciones.size(); x++) {
                    %>

                    <div class="col mb-5">
                        <div class="card h-100">
                            <img class="card-img-top"
                                 src="<%=listaHabitaciones.get(x).getImagen()%>"
                                 alt="<%=listaHabitaciones.get(x).getNombre()%>" />
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <h5 class="fw-bolder"><%=listaHabitaciones.get(x).getNombre()%></h5>
                                    <p><%=listaHabitaciones.get(x).getDescripcion()%></p>
                                    CL$ <%=listaHabitaciones.get(x).getPrecio()%>
                                </div>
                            </div>
                            <input type="radio" id="html" name="idhabitacion"
                                   value="<%=listaHabitaciones.get(x).getId()%>" checked>
                            <br>
                        </div>
                    </div>
                    <%
                        }
                    %>

                </div>
            </div>
        </section>

        <!--  Formulario -->
        <section>
            <div class="container px-4 px-lg-5 mt-5">
                <h1>Información de Reserva Habitacíon</h1>
                <hr />

                <div class="row g-3">
                    <div class="col-md-6">
                        <label for="nombre" class="form-label">Nombre</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" value="Arturo Erasmo">
                    </div>

                    <div class="col-md-6">
                        <label for="apellido" class="form-label">Apellido</label>
                        <input type="text" class="form-control" id="apellido" name="apellido" value="Vidal Pardo">
                    </div>

                    <div class="col-md-6">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" name="email" value="arturo.vidal@anfp.cl">
                    </div>

                    <div class="col-md-2">
                        <label for="pago" class="form-label">Medio de Pago</label>
                        <select id="pago" name="pago" class="form-select">
                            <option value="Contado">Contado</option>
                            <option value="Débito">Débito</option>
                            <option value="Crédito">Crédito</option>
                        </select>
                    </div>

                    <div class="col-md-2">
                        <label for="dias" class="form-label">Días</label>
                        <select id="dias" name="dias" class="form-select">
                            <% for (int x = 1; x <= 28; x++) { %>
                            <option value="<%= x %>"><%= x %> día(s)</option>
                            <% } %>
                        </select>
                    </div>

                    <div class="col-md-2">
                        <label for="fecha" class="form-label">Fecha Entrada</label>
                        <input value="<%= util.getDateNow()%>" type="date" class="form-control" id="fecha" name="fecha">
                    </div>

                    <div class="col-12">
                        <hr />
                        <button type="submit" class="btn btn-primary">Enviar Solicitud de Compra</button>
                    </div>
                </div>
            </div>
        </section>

        <br /> <br />
    </form>

    <%@include file="assets/html/footer.jsp"%>
</body>
</html>