<%@ page import="cl.praxis.game.models.Genero" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta charset="ISO-8859-1">

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css"/>
  <link rel="stylesheet" href="assets/css/styles.css" />

  <title>Game</title>
</head>
<body class="container">

  <header>
    <%@include file="assets/html/nav.jsp"%>
  </header>

  <main>
    <div class="grid">
      <img src="https://c4.wallpaperflare.com/wallpaper/909/127/751/hero-zhao-yun-skin-computer-images-video-game-king-of-glory-hd-wallpaper-1920%C3%971080-wallpaper-preview.jpg" alt="hero icon" />

      <%@include file="assets/html/form.jsp"%>
    </div>

    <hr>
    <%@include file="assets/html/list.jsp"%>
  </main>

  </body>
</html>