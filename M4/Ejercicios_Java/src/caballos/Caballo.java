package caballos;

public class Caballo {
    private String nombre;
    private String fechaNaciemiento;

    public Caballo(String nombre, String fechaNaciemiento) {
        this.nombre = nombre;
        this.fechaNaciemiento = fechaNaciemiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaNaciemiento() {
        return fechaNaciemiento;
    }

    @Override
    public String toString() {
        return "Caballo{" +
                "nombre='" + nombre + '\'' +
                ", fechaNaciemiento='" + fechaNaciemiento + '\'' +
                '}';
    }
}
