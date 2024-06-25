<%@ page import="cl.praxis.tickets.business.EventoBusiness" %>
<%@ page import="cl.praxis.tickets.model.Evento" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%
// Recepcion valores dede request
String nombreComprador = request.getParameter("nombre");
String apellidoComprador = request.getParameter("apellido");
String direccionComprador = request.getParameter("direccion");
int numeroComprador = Integer.parseInt(request.getParameter("numero"));
int cantidadTickets = Integer.parseInt(request.getParameter("cantidad"));
int idEvento = Integer.parseInt(request.getParameter("idevento"));

// Librerias requeridas
EventoBusiness eventob = new EventoBusiness();

// incializa Objeto Evento
Evento evento = new Evento();
evento.setId(idEvento);

// Busca y recoge informacion de evento seleccionado
evento = eventob.getEventoById(evento);

// Obtiene el valor a pagar por la cantidad de tickets seleccionados
int valorPagar = eventob.calculaValorCompra(evento.getPrecio(), cantidadTickets);
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
						Detalle Solictud Venta Ticket: <strong><%=evento.getNombre()%></strong>
					</h1>
					<hr/ >
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
							<td><%=nombreComprador%></td>
						</tr>
						<tr>
							<th scope="row">2</th>
							<td>Apellido</td>
							<td><%=apellidoComprador%></td>
						</tr>
						<tr>
							<th scope="row">3</th>
							<td>Dirección</td>
							<td><%=direccionComprador%></td>
						</tr>

						<tr>
							<th scope="row">4</th>
							<td>Numero</td>
							<td><%=numeroComprador%></td>
						</tr>

						<tr>
							<th scope="row">5</th>
							<td>Cantidad Tickets</td>
							<td><%=cantidadTickets%></td>
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