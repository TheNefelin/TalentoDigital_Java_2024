<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h1><%= "Hello World!" %></h1>
    <br/>
    <a href="hello-servlet">Hello Servlet</a>

    <%--
        set: etiqueta para definir variables y asignar valores
        var; atributo donde se establece el nombre de la variable
        scope: atributo que determina el ambito enb la se almacenara la variable (page, request, session, application)
        value: atributo que contiene el valor de la variable
    --%>
    <c:set var = "sueldo" scope = "session" value = "${ 500 }"/>

    <%--
        out: etiqueta que implime
        value: atributo que especifica el valor a mostrar
    --%>
    <p>Si tu sueldo es : <c:out value = "${sueldo}"/></p>

    <%--
        choose: etiqueta contenedora, tipo switch
        when: etiqueta condicional que evalua la condicion
        otherwise: etiqueta que se ejecuta si ninguna condicion se aplicó
        test: atributo contiene una exprecion EL que evalua como true o false en la condicion
    --%>
    <c:choose>
        <c:when test = "${sueldo <= 0}">
            Sueldo demasiado bajo para tomar
        </c:when>

        <c:when test = "${sueldo > 1000}">
            Vamos al Anfiteatro
        </c:when>

        <c:otherwise>
            Sueldo alcanza para una chela
        </c:otherwise>
    </c:choose>

</body>
</html>