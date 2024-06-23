import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Vendedor vendedor = new Vendedor("123456", "Anakin Skywalker", 45, "Imperio");

        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(new Cliente("111111", "Storm Trooper", 25));
        clientes.add(new Cliente("222222", "Jabba de Hutt", 265));
        clientes.add(new Cliente("333333", "Boba Fett", 62));

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Taxi("Rojo", "A123456", 350));
        vehiculos.add(new Taxi("Verde", "A654321", 450));
        vehiculos.add(new MiniBus("Azul", "A111111", 6, "Vip"));
        vehiculos.add(new MiniBus("Amarillo", "A222222", 6, "Plebeyos"));
        vehiculos.add(new Bus("Negro", "A112233", 45));
        vehiculos.add(new Bus("Blanco", "A332211", 45));

        Tienda tienda = new Tienda(vendedor, clientes, vehiculos.toArray().length, vehiculos);

        System.out.println("-----------------------------------------------");
        System.out.println(tienda);
        System.out.println("-----------------------------------------------");
    }
}