package cl.praxis.game.controllers;

import cl.praxis.game.classes.Genero;
import cl.praxis.game.models.Personaje;
import cl.praxis.game.services.PersonajeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/personaje-servlet")
public class PersonajeServlet extends HttpServlet {
    private PersonajeService personajeService;

    public void init() throws ServletException {
        super.init();
        personajeService = new PersonajeService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        Genero genero = Genero.valueOf(request.getParameter("genero"));
        int fuerza = Integer.parseInt(request.getParameter("fuerza"));
        int defensa = Integer.parseInt(request.getParameter("defensa"));
        int vida = Integer.parseInt(request.getParameter("vida"));

        Personaje personaje = new Personaje();
        personaje.setNombre(nombre);
        personaje.setGenero(genero);
        personaje.setFuerza(fuerza);
        personaje.setDefensa(defensa);
        personaje.setVida(vida);

        personajeService.insert(personaje);
    }
}
