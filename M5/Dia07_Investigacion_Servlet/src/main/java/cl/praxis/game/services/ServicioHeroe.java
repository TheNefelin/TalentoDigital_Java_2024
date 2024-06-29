package cl.praxis.game.services;

import cl.praxis.game.models.Personaje;
import cl.praxis.game.models.Genero;

import java.util.ArrayList;
import java.util.List;

public class ServicioHeroe {
    private static ServicioHeroe instancia;
    private List<Personaje> listaPersonajes = new ArrayList<>();

    private ServicioHeroe() {
        Personaje personaje1 = new Personaje(1, "Ion", Genero.MASCULINO, 100, 60 ,500);
        Personaje personaje2 = new Personaje(2, "Francisca", Genero.FEMENINO, 110, 50 ,400);
        Personaje personaje3 = new Personaje(3, "Carolina", Genero.FEMENINO, 90, 80 ,600);
        Personaje personaje4 = new Personaje(4, "Francisco", Genero.OTRO, 10, 10 ,10);
        Personaje personaje5 = new Personaje(5, "Andrea", Genero.OTRE, 200, 100 ,10);

        listaPersonajes.add(personaje1);
        listaPersonajes.add(personaje2);
        listaPersonajes.add(personaje3);
        listaPersonajes.add(personaje4);
        listaPersonajes.add(personaje5);
    }

    public static ServicioHeroe getInstancia() {
        if (instancia == null) {
            instancia = new ServicioHeroe();
        }
        return instancia;
    }

    public void nuevoHeroe(Personaje personaje) {
        int antId = 0;

        for (Personaje p : listaPersonajes) {
            if (p.getId() > antId) {
                antId = p.getId();
            }
        }

        personaje.setId(antId + 1);

        listaPersonajes.add(personaje);
    }

    public List<Personaje> listaHeroes() {
         return listaPersonajes;
    }

    public Personaje obtenerHeroePorId(int id) {
        for (Personaje personaje : listaPersonajes) {
            if (personaje.getId() == id) {
                return personaje;
            }
        }

        return null;
        //return listaPersonajes.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }
}
