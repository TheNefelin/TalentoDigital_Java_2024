package informatica;

import java.util.List;

public class Oficina {
    private List<Programador> programadores;
    private Jefe jefeProyecto;
    private int cantidadPuesto;

    public Oficina(List<Programador> programadores, Jefe jefeProyecto, int cantidadPuesto) {
        this.programadores = programadores;
        this.jefeProyecto = jefeProyecto;
        this.cantidadPuesto = cantidadPuesto;
    }

    public List<Programador> getProgramadores() {
        return programadores;
    }

    public void setProgramadores(List<Programador> programadores) {
        this.programadores = programadores;
    }

    public Jefe getJefeProyecto() {
        return jefeProyecto;
    }

    public void setJefeProyecto(Jefe jefeProyecto) {
        this.jefeProyecto = jefeProyecto;
    }

    public int getCantidadPuesto() {
        return cantidadPuesto;
    }

    public void setCantidadPuesto(int cantidadPuesto) {
        this.cantidadPuesto = cantidadPuesto;
    }

    @Override
    public String toString() {
        return "Oficina{" +
                "programadores=" + programadores +
                ", jefeProyecto=" + jefeProyecto +
                ", cantidadPuesto=" + cantidadPuesto +
                '}';
    }
}
