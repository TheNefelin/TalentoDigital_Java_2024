<%@ page import="cl.praxis.tickets.business.EventoBusiness" %>
<%@ page import="cl.praxis.tickets.model.Evento" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<%
//Recepcion valores dede request
int idEvento = Integer.parseInt(request.getParameter("idevento"));

//Librerias requeridas
EventoBusiness eventob = new EventoBusiness();

//Crea Evento
Evento evento = new Evento();
evento.setId(idEvento);

//Busca evento
evento = eventob.getEventoById(evento);
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
						Mapa Evento: <strong><%=evento.getNombre()%></strong>
					</h1>
					<hr>
				</div>
			</div>

			<div class="container px-4 px-lg-5 mt-5">

				<iframe src="<%=evento.getMapa()%>" width="100%" height="900"
					style="border: 0;" allowfullscreen="" loading="lazy"
					referrerpolicy="no-referrer-when-downgrade"></iframe>
			</div>

		</section>

		<br /> <br />

	</form>

	<%@include file="assets/html/footer.jsp"%>

</body>
</html>





