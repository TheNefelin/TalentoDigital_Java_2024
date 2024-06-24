package informatica;

public class Programador extends Persona {
    private String lenguaje;

    public Programador(String nombre, String rut, int altura, String lenguaje) {
        super(nombre, rut, altura);
        this.lenguaje = lenguaje;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    @Override
    public String toString() {
        return "Programador{" +
                "lenguaje='" + lenguaje + '\'' +
                "} " + super.toString();
    }
}
