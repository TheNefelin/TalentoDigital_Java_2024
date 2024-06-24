package cl.praxis.futbol;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//---- TDD ----
//(Rojo): Escribir el/los test
//(Verde): Escribir codigo minimo para que el test pase (Clase)
//(Refactorización) Mejorar el codigo de la clase:
// ------------
@DisplayName("Test TDD Equipo de Fútbol")
public class EquipoFutbolTest {
    private static final int CUATRO_JUEGOS_GANADOS = 4;
    private static final int CINCO_JUEGOS_EMPATADOS = 5;
    private static final int TRES_JUEGOS_PERDIDOS = 3;

    @Test
    @DisplayName("Test Juegos Ganados")
    public void constructorDebeSetearJuegosGanados() {
        EquipoFutbol equipo = new EquipoFutbol(CUATRO_JUEGOS_GANADOS, CINCO_JUEGOS_EMPATADOS, TRES_JUEGOS_PERDIDOS);
        assertEquals(CUATRO_JUEGOS_GANADOS, equipo.getJuegosGanados());
    }

    @Test
    @DisplayName("Test Juegos Empatados")
    public void constructorDebeSetearJuegosEmpatados() {
        EquipoFutbol equipo = new EquipoFutbol(CUATRO_JUEGOS_GANADOS, CINCO_JUEGOS_EMPATADOS, TRES_JUEGOS_PERDIDOS);
        assertEquals(CINCO_JUEGOS_EMPATADOS, equipo.getJuegosEmpatados());
    }

    @Test
    @DisplayName("Test Juegos Perdidos")
    public void constructorDebeSetearJuegosPerdidos() {
        EquipoFutbol equipo = new EquipoFutbol(CUATRO_JUEGOS_GANADOS, CINCO_JUEGOS_EMPATADOS, TRES_JUEGOS_PERDIDOS);
        assertEquals(TRES_JUEGOS_PERDIDOS, equipo.getJuegosPerdidos());
    }
}