<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <%@include file="assets/components/meta.jsp"%>

    <title>Registrarse</title>
</head>
<body>

    <header class="pico-background-azure-850">
        <%@include file="assets/components/nav.jsp"%>
    </header>

    <main>
        <h1 class="container">Regístrate!!!</h1>

        <article class="container">
            <form method="post" action="user-register-servlet" class="container-fluid">

                <c:if test="${msg != null}">
                    <article class="pico-background-red-500">${msg}</article>
                </c:if>

                <fieldset>
                    <label>
                        Correo
                        <input type="email" name="email" placeholder="Correo" required/>
                    </label>
                    <label>
                        Clave
                        <input type="password" name="password" placeholder="Clave" required/>
                    </label>
                    <label>
                        Confirmar Clave
                        <input type="password" name="password2" placeholder="Confirmar Clave" required/>
                    </label>
                </fieldset>

                <input type="submit" value="Registrarse"/>
            </form>
        </article>
    </main>

</body>
</html>
