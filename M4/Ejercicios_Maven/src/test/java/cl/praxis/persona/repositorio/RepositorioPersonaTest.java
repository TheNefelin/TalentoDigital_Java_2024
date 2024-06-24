package cl.praxis.persona.repositorio;


import cl.praxis.persona.modelos.Persona;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@DisplayName("Test dobles respositorio persona")
public class RepositorioPersonaTest {
    private RepositorioPersona repositorioPersona = mock(RepositorioPersona.class);
    private static Map<String, String> db = new HashMap<>();
    private static Persona pepe;
    private static Persona juanito;

    @BeforeEach
    void setUp() {
        pepe = new Persona("123-4", "Pepe");
        juanito = new Persona("567-8", "Juanito");

        db.put(pepe.getNombre(), pepe.getNombre());
        db.put(juanito.getNombre(), juanito.getNombre());
    }

    @Test
    @DisplayName("Test crear persona")
    public void testCreaPersona() {
        // Configura el mock
        when(repositorioPersona.crearPersona(pepe)).thenReturn("Persona creada");
        // Llama al método crearPersona
        String crearPersonaRes = repositorioPersona.crearPersona(pepe);
        // Verifica que el resultado de la llamada
        assertEquals("Persona creada", crearPersonaRes);
        // Verifica que el método crearPersona fue llamado con el objeto
        verify(repositorioPersona).crearPersona(pepe);
    }

    @Test
    @DisplayName("Test crear persona null")
    public void testCreaPersonaNull() {
        when(repositorioPersona.crearPersona(null)).thenThrow(new NullPointerException());

        assertThrows(NullPointerException.class, () -> {
            repositorioPersona.crearPersona(null);
        });

        verify(repositorioPersona).crearPersona(null);
    }

    @Test
    @DisplayName("Test actualizar persona")
    public void testActualizarPersona () {
        when(repositorioPersona.actualizarPersona(juanito)).thenReturn("Persona modificada");

        String actualizarRes = repositorioPersona.actualizarPersona(juanito);
        assertEquals("Persona modificada", actualizarRes);
        verify(repositorioPersona).actualizarPersona(juanito);
    }

    @Test
    @DisplayName("Test eliminar persona")
    public void testEliminarPersona () {
        when(repositorioPersona.eliminarPersona(juanito)).thenReturn("Persona eliminada");

        String eliminarRes = repositorioPersona.eliminarPersona(juanito);
        assertEquals("Persona eliminada", eliminarRes);
        verify(repositorioPersona).eliminarPersona(juanito);
    }

    @Test
    @DisplayName("Test listar personas")
    public void testListarPersonas () {
        when(repositorioPersona.listarPersonas()).thenReturn(db);

        Map<String, String> resultado = repositorioPersona.listarPersonas();
        assertEquals(db, resultado);
        verify(repositorioPersona).listarPersonas();
    }
}
