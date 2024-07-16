<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <%@include file="assets/components/meta.jsp"%>

    <title>Heroes</title>
</head>
<body>

    <header class="pico-background-azure-850">
        <%@include file="assets/components/nav.jsp"%>
    </header>

    <main>
        <h1 class="container">Crear Heroe!!!</h1>

        <article class="container">
            <form action="hero-servlet" method="post" class="container-fluid">
                <c:choose>
                    <c:when test="${user != null}">
                        <article class="pico-background-lime-200">Bienvenido ${user.email}!!!</article>
                    </c:when>
                    <c:otherwise>
                        <article class="pico-background-red-500">Por favor, inicia sesión.</article>
                    </c:otherwise>
                </c:choose>

                <fieldset>
                    <label>Nombre
                        <input type="text" name="name" placeholder="Nombre" required/>
                    </label>
                    <label>Clase
                        <select name="id_class" aria-label="Selecciona la Clase..." required>
                            <option selected disabled value="">
                                Selecciona la Clase...
                            </option>
                            <c:forEach var="clase" items="${classList}">
                                <option value="${clase.id}">${clase.name}</option>
                            </c:forEach>
                        </select>
                    </label>
                    <label>Genero
                        <select onchange="updateImg()" id="id_gender"  name="id_gender" aria-label="Selecciona el Genero..." required>
                            <option selected disabled value="">
                                Selecciona el Genero...
                            </option>
                            <c:forEach var="gender" items="${genderList}">
                                <option value="${gender.id}" data-url="${gender.name}">${gender.name}</option>
                            </c:forEach>
                        </select>
                    </label>

                    <img id="hero_img" class="container" src="assets/img/notfound.png" alt="background">
                </fieldset>

                <input type="submit" value="Crear Heroe"/>
            </form>
        </article>

        <table class="container">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Correo</th>
                <th scope="col">Nombre</th>
                <th scope="col">Clase</th>
                <th scope="col">Genero</th>
                <th scope="col">Imagen</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="hero" items="${listHero}" >
                <tr>
                    <th scope="row">${hero.id}</th>
                    <td>${hero.user.email}</td>
                    <td>${hero.name}</td>
                    <td>${hero.clase.name}</td>
                    <td>${hero.gender.name}</td>
                    <td class="hero_img" >
                        <img class="hero_img" src="assets/img/${hero.gender.name}.png" alt="algo">
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </main>

    <script>
        function updateImg() {
            var select = document.querySelector("#id_gender");
            var img = document.querySelector("#hero_img");

            var opt = select.options[select.selectedIndex];
            var imgName = opt.getAttribute("data-url");

            if (imgName) {
                img.src = "assets/img/" + imgName + ".png";
            }
        }
    </script>

</body>
</html>
