<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<h1>Soy un formulario de Login</h1>
<div class="grid">
    <form name="formulario" action="login-servlet" method="post" >
        <div class="field">
            <label for="username">Nombre de usuario</label>
            <input type="text" id="username" name="username" placeholder="usuario">
        </div>
        <div class="field">
            <label for="password">Contraseña</label>
            <input type="password" id="password" name="password" placeholder="******">
        </div> <div class="actions">
        <input type="submit" value="Enviar">
    </div>
    </form>
</div>