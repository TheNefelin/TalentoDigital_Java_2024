<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="ISO-8859-1">

    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css"
    />

    <title>Desafio M5 Dia09</title>
</head>
<body>

    <main class="container">
        <%@include file="assets/html/calculadora.jsp"%>
    </main>

    <dialog>
        <article>
            <h2>Confirm Your Membership</h2>
            <p>
                Thank you for signing up for a membership!
                Please review the membership details below:
            </p>
            <ul>
                <li>Membership: Individual</li>
                <li>Price: $10</li>
            </ul>
            <footer>
                <button id="btnCalc" className="secondary">
                    Cancel
                </button>
                <button>Confirm</button>
            </footer>
        </article>
    </dialog>

    <script src="assets/js/modal.js"></script>

</body>
</html>