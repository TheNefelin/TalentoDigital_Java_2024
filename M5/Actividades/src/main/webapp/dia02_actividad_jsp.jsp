<%@ page import="cl.praxis.dia02_actividad.utils.General" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    General utilesgeneral = new General();
    final int nMes = 12;
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
        crossorigin="anonymous">


    <title>Actividad Dia 2 (JSP) Efemérides</title>
</head>
<body>

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

    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous">
    </script>
</body>
</html>
