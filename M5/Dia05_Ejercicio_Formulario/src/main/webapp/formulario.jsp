<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <title>Formulario</title>
</head>
<body>

    <header></header>

    <main>
        <form method="post" action="procesa.jsp">
            <div>
                <label>Nombre: </label>
                <input type="text" placeholder="Ingrese Nombre" name="nombre">
            </div>
            <div>
                <label>Apellido: </label>
                <input type="text" placeholder="Ingrese Apellido" name="apellido">
            </div>
            <div>
                <label>Email: </label>
                <input type="email" placeholder="Ingrese Email" name="email">
            </div>

            <div>
                <label>Seleccione Cargo: </label>
                <select name="cargo">
                    <option value="Analista">Analista</option>
                    <option value="Diseñador">Diseñador</option>
                </select>

            </div>

            <input type="submit" value="Enviar">
        </form>
    </main>

    <footer></footer>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>
