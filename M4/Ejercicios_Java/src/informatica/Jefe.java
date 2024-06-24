package informatica;

public class Jefe extends Persona {
    private String area;

    public Jefe(String nombre, String rut, int altura, String area) {
        super(nombre, rut, altura);
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Jefe{" +
                "area='" + area + '\'' +
                "} " + super.toString();
    }
}
