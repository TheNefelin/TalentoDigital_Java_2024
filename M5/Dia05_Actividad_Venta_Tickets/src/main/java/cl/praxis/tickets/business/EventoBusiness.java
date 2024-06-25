package cl.praxis.tickets.business;

import cl.praxis.tickets.model.Evento;

import java.util.ArrayList;
import java.util.List;

public class EventoBusiness {

    public List<Evento> getEventos() {
        ArrayList<Evento> eventos = new ArrayList<Evento>();

        // Info Evento 1
        Evento evento1 = new Evento();
        evento1.setId(1);
        evento1.setNombre("Metallica");
        evento1.setDescripcion("Descripción Uno");
        evento1.setImagen("https://imageio.forbes.com/specials-images/imageserve/6442c4080e6821427723907e/F1-Rocks-in-India-with-Vladivar---Metallica-Concert/960x0.jpg?format=jpg&width=960");
        evento1.setPrecio(10000);
        evento1.setLugar("Estadio Nacional");
        evento1.setMapa("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3328.411793967857!2d-70.61286488437952!3d-33.46462808076988!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x9662cfed639ab813%3A0xb92488060556a1df!2sEstadio%20Nacional%20Julio%20Mart%C3%ADnez%20Pr%C3%A1danos!5e0!3m2!1ses!2scl!4v1661265818941!5m2!1ses!2scl");

        // Info Evento 2
        Evento evento2 = new Evento();
        evento2.setId(2);
        evento2.setNombre("Fiestas Patrias");
        evento2.setDescripcion("Descripción Dos");
        evento2.setImagen("https://img.freepik.com/vector-gratis/fondo-plano-fiestas-patrias-chile_23-2149539845.jpg");
        evento2.setPrecio(20000);
        evento2.setLugar("parque O'higgins");
        evento2.setMapa("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3328.411793967857!2d-70.61286488437952!3d-33.46462808076988!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x9662cfed639ab813%3A0xb92488060556a1df!2sEstadio%20Nacional%20Julio%20Mart%C3%ADnez%20Pr%C3%A1danos!5e0!3m2!1ses!2scl!4v1661265818941!5m2!1ses!2scl");

        // Info Evento 3
        Evento evento3 = new Evento();
        evento3.setId(3);
        evento3.setNombre("Iron Maiden");
        evento3.setDescripcion("Descripción Tres");
        evento3.setImagen("https://www.futuro.cl/wp-content/uploads/2023/08/iron-maiden-2023-promo-web-jpg.webp");
        evento3.setPrecio(30000);
        evento3.setLugar("Estadio Monumental");
        evento3.setMapa("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3328.411793967857!2d-70.61286488437952!3d-33.46462808076988!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x9662cfed639ab813%3A0xb92488060556a1df!2sEstadio%20Nacional%20Julio%20Mart%C3%ADnez%20Pr%C3%A1danos!5e0!3m2!1ses!2scl!4v1661265818941!5m2!1ses!2scl");

        // Info Evento 4
        Evento evento4 = new Evento();
        evento4.setId(4);
        evento4.setNombre("Delfín Hasta el Fin!");
        evento4.setDescripcion("Descripción Cuatro");
        evento4.setImagen("https://www.prensalibre.com/wp-content/uploads/2021/11/Delfin-1.jpg?quality=52&w=760&h=430&crop=1");
        evento4.setPrecio(40000);
        evento4.setLugar("Centro de Eventos Amanda");
        evento4.setMapa("https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3328.411793967857!2d-70.61286488437952!3d-33.46462808076988!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x9662cfed639ab813%3A0xb92488060556a1df!2sEstadio%20Nacional%20Julio%20Mart%C3%ADnez%20Pr%C3%A1danos!5e0!3m2!1ses!2scl!4v1661265818941!5m2!1ses!2scl");

        // Agrega Eventos a lista
        eventos.add(evento1);
        eventos.add(evento2);
        eventos.add(evento3);
        eventos.add(evento4);

        return eventos;
    }

    public Evento getEventoById(Evento evento) {
        List<Evento> listaEventos = getEventos();

        for (int x = 0; x < listaEventos.size(); x++) {
            if (listaEventos.get(x).getId() == evento.getId()) {
                evento = listaEventos.get(x);
            }
        }

        return evento;
    }

    public int calculaValorCompra(int valorEvento, int cantidadTickets) {
        int valor = valorEvento * cantidadTickets;
        return valor;
    }
}
