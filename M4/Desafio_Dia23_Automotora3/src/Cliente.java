public class Cliente extends Persona {
    private int edad;

    public Cliente() {}

    public Cliente(String rut, String nombre, int edad) {
        super(rut, nombre, edad);
        this.edad = edad;
    }

    @Override
    public int getEdad() {
        return edad;
    }

    @Override
    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "edad=" + edad +
                "} " + super.toString();
    }
}
