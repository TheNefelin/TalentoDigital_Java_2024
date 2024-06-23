<%@ page import="cl.praxis.utils.General" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    General utilesgeneral = new General();
    final int nMes = 12;
%>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

    <h1><%= "Hello World!" %></h1>
    <br/>
    <a href="hello-servlet">Hello Servlet</a>

    <div class="container">
        <h1>Actividad JSP - Academia Desafío Latam</h1>
        <div class="row">
            <div class="col-12 col-sm-12">

                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Número Mes</th>
                        <th scope="col">Nombre Mes</th>
                        <th scope="col">Acciones</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        for (int x = 0; x < 12; x++) {
                    %>
                    <tr>
                        <th scope="row"><%=x + 1%></th>
                        <td>Número Mes <%=x + 1%></td>
                        <td><%=utilesgeneral.getNombreMes(x)%></td>
                        <td><a href="ObtenerEfemerides?mes=<%=x%>">Ver Efemeridas de <%=utilesgeneral.getNombreMes(x)%></a></td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <div class="container">
        <h1>Dias del Mes</h1>

        <%
            for (int n = 1; n <= nMes; n++) {
        %>
        <div>
            <a href="ObtieneDiasMes?mes=<%=n%>">Cantidad de Dias de <%=utilesgeneral.getNombreMes(n-1)%></a>
        </div>
        <%
            }
        %>
    </div>

    <div class="container">
        <h1>Feriados del Mes</h1>

        <%
            for (int n = 1; n <= nMes; n++) {
        %>
        <div>
            <a href="ObtieneCantidadFeriadosMes?mes=<%=n%>">Cantidad de Feriados de <%=utilesgeneral.getNombreMes(n-1)%></a>
        </div>
        <%
            }
        %>
    </div>

</body>
</html>