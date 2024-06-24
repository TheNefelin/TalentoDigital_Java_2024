package cl.praxis.persona.servicios;


import cl.praxis.persona.modelos.Persona;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Tests Clase ServicioPersona")
public class ServicioPersonaTest {

    private static Logger logger = Logger.getLogger("cl.desafiolatam.servicios.ServicioPersonaTest");
    private final ServicioPersona servicioPersona = new ServicioPersona();

    @Test
    public void testCrearPersona() {
        logger.info("info test crear persona");
        Persona juanito = new Persona("1234-1", "Juanito");
        String respuestaServicio = servicioPersona.crearPersona(juanito);
        assertEquals("Creada", respuestaServicio);
    }

    @Test
    public void testActualizarPersona() {
        logger.info("info actualizar persona");
        Persona pepe = new Persona("1234-1", "Pepe");
        String respuestaServicio = servicioPersona.actualizarPersona(pepe);
        assertEquals("Actualizada", respuestaServicio);
    }

    @Test
    public void testEliminarPersona() {
        logger.info("info eliminar persona");
        Persona pepe = new Persona("1234-1", "Pepe");
        String respuestaServicio = servicioPersona.eliminarPersona(pepe);
        assertEquals("Eliminada", respuestaServicio);
    }

    @Test
    public void testListarPersona() {
        logger.info("info listar persona");

        Persona juanito = new Persona("1234-1", "Juanito");
        Persona pepe = new Persona("5678-1", "Pepe");

        Map<String, String> respuestaServicio = servicioPersona.listarPersonas();
        servicioPersona.crearPersona(juanito);
        servicioPersona.crearPersona(pepe);

        Map<String, String> respuestaEsperada = new HashMap<>();
        respuestaEsperada.put(juanito.getRut(), juanito.getNombre());
        respuestaEsperada.put(pepe.getRut(), pepe.getNombre());

        assertEquals(respuestaEsperada, respuestaServicio);
    }

    @Test
    public void testListarPersona2() {
        logger.info("info listar persona");
        Map<String, String> respuestaServicio = servicioPersona.listarPersonas();
        assertNotNull(respuestaServicio);
    }
}
