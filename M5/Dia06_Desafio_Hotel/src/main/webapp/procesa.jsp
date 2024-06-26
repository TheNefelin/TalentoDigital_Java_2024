<%@ page import="cl.praxis.model.Habitacion" %>
<%@ page import="cl.praxis.business.HabitacionBusiness" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    String nombre = request.getParameter("nombre");
    String apellido = request.getParameter("apellido");
    String email = request.getParameter("email");
    String pago = request.getParameter("pago");
    int dias = Integer.parseInt(request.getParameter("dias"));
    String fecha = request.getParameter("fecha");
    int idHabitante = Integer.parseInt(request.getParameter("idhabitacion"));

    HabitacionBusiness hb = new HabitacionBusiness();
    Habitacion habitacion = hb.getHabitacionById(idHabitante);;

    int valorPagar = 0;

    if (habitacion != null)
        valorPagar = hb.calculaValorCompra(habitacion.getPrecio(), dias);
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
                        Detalle Solictud Habitación: <strong><%=habitacion.getNombre()%></strong>
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
                            <td>Apellido</td>
                            <td><%=apellido%></td>
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>Email</td>
                            <td><%=email%></td>
                        </tr>
                        <tr>
                            <th scope="row">4</th>
                            <td>Medio de Pago</td>
                            <td><%=pago%></td>
                        </tr>
                        <tr>
                            <th scope="row">5</th>
                            <td>Dias</td>
                            <td><%=dias%></td>
                        </tr>
                        <tr>
                            <th scope="row">6</th>
                            <td>Fecha Entrada</td>
                            <td><%=fecha%></td>
                        </tr>
                        <tr>
                            <th scope="row">6</th>
                            <td>Valor a Pagar</td>
                            <td><strong>CL$ <%=valorPagar%></strong></td>
                        </tr>
                    </tbody>
                </table>

            </div>
        </section>
        <br /> <br />
    </form>

    <%@include file="assets/html/footer.jsp"%>
</body>
</html>
