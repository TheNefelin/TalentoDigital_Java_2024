package cl.praxis.game.servlets;

import cl.praxis.game.models.Genero;
import cl.praxis.game.models.Personaje;
import cl.praxis.game.services.ServicioHeroe;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/heroe-servlet")
public class HeroeServlet extends HttpServlet {
    ServicioHeroe sh;

    public HeroeServlet() {
        sh = ServicioHeroe.getInstancia();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Personaje> heroes = sh.listaHeroes();
        request.setAttribute("heroes", heroes);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        Genero genero = Genero.valueOf(request.getParameter("genero"));
        int fuerza = parseOrDefault(request.getParameter("fuerza"));
        int defensa = parseOrDefault(request.getParameter("defensa"));
        int vida = parseOrDefault(request.getParameter("vida"));

        Personaje nuevoPersonaje = new Personaje();

        nuevoPersonaje.setNombre(nombre);
        nuevoPersonaje.setGenero(genero);
        nuevoPersonaje.setFuerza(fuerza);
        nuevoPersonaje.setDefensa(defensa);
        nuevoPersonaje.setVida(vida);

        sh.nuevoHeroe(nuevoPersonaje);

        response.sendRedirect(request.getContextPath());
    }

    private int parseOrDefault(String param) {
        if (param.isBlank()) {
            return 0;
        }
        try {
            return Integer.parseInt(param);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
