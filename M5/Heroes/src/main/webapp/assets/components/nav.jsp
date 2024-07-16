<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<nav class="container">
    <ul>
        <li><strong>Heroes</strong></li>
    </ul>
    <ul>
        <li><a href="index.jsp">Inicio</a></li>
        <c:choose>
            <c:when test="${user != null}">
                <li><a href="hero-servlet">Héroe</a></li>
                <li><a href="user-logout-servlet">Cerrar Sesión</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="login.jsp">Iniciar Sesión</a></li>
                <li><a href="register.jsp">Registrarse</a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</nav>
