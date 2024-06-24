package autos;


public class Rueda {
    private String marca;
    private String modelo;
    private int aro;

    public Rueda() {
    }

    public Rueda(String marca, int aro) {
        this.marca = marca;
        this.aro = aro;
    }

    public Rueda(String marca, String modelo, int aro) {
        this.marca = marca;
        this.modelo = modelo;
        this.aro = aro;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAro() {
        return aro;
    }

    public void setAro(int aro) {
        this.aro = aro;
    }

    @Override
    public String toString() {
        return "Rueda{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", aro=" + aro +
                '}';
    }
}
