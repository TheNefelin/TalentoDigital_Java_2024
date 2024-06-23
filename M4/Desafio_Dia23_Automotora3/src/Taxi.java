public class Taxi extends Vehiculo {
    private int valorPasaje;

    public  Taxi() {}

    public Taxi(String color, String patente, int valorPasaje) {
        super(color, patente);
        this.valorPasaje = valorPasaje;
    }

    public void pagarPasaje(int pasaje) {
        if (pasaje > valorPasaje)
            System.out.println("Vuelto: " + (valorPasaje - pasaje));
        else
            System.out.println("Pasaje Original: " + valorPasaje);
    }

    public int getValorPasaje() {
        return valorPasaje;
    }

    public void setValorPasaje(int valorPasaje) {
        this.valorPasaje = valorPasaje;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "valorPasaje=" + valorPasaje +
                "} " + super.toString();
    }
}
