package informatica;

public class Persona {
    private String nombre;
    private String rut;
    private int altura;

    public Persona(String nombre, String rut, int altura) {
        this.nombre = nombre;
        this.rut = rut;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", rut='" + rut + '\'' +
                ", altura=" + altura +
                '}';
    }
}
