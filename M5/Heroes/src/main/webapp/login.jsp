<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <%@include file="assets/components/meta.jsp"%>

    <title>Iniciar Sesión</title>
</head>
<body>

    <header class="pico-background-azure-850">
        <%@include file="assets/components/nav.jsp"%>
    </header>

    <main>
        <h1 class="container">Iniciar Sesión!!!</h1>

        <article class="container">
            <form method="post" action="user-login-servlet" class="container-fluid">
                <c:if test="${msg != null}">
                    <article class="pico-background-lime-200">${msg}</article>
                </c:if>

                <c:if test="${msgLogin != null}">
                    <article class="pico-background-red-500">${msgLogin}</article>
                </c:if>

                <fieldset>
                    <label>
                        Email
                        <input type="email" name="email" placeholder="Correo" required/>
                    </label>
                    <label>
                        Clave
                        <input type="password" name="password" placeholder="Clave" required/>
                    </label>
                </fieldset>

                <input type="submit" value="Iniciar Sesión"/>
            </form>
        </article>
    </main>

</body>
</html>
