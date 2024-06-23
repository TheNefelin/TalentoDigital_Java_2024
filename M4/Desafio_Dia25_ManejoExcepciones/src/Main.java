import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vendedor vendedor = new Vendedor("123456", "Anakin Skywalker", 45, "Imperio");

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("111111", "Storm Trooper", 25));
        clientes.add(new Cliente("222222", "Jabba de Hutt", 265));
        clientes.add(new Cliente("333333", "Boba Fett", 62));

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Taxi("Verde", "A654321", 450));
        vehiculos.add(new MiniBus("Azul", "A111111", 6, "Vip"));
        vehiculos.add(new Bus("Negro", "A112233", 45));

        Tienda tienda = new Tienda(vendedor, clientes, vehiculos.toArray().length, vehiculos);

        List<LibroVenta> libroVentas = new ArrayList<>();
        libroVentas.add(new LibroVenta("VentaTrooper", "20240517"));
        libroVentas.add(new LibroVenta("VentaJabba", "20240505"));
        libroVentas.add(new LibroVenta("VentaFett", "20240515"));

        for (int i = 0; i < libroVentas.size(); i++) {
            libroVentas.get(i).guardarVenta(tienda.getCliente().get(i), tienda.getVehiculos().get(i));
        }

        System.out.println("-----------------------------------------------");
        System.out.println(tienda);
        System.out.println("-----------------------------------------------");
        System.out.println(libroVentas);
        System.out.println("-----------------------------------------------");
        for (Vehiculo vehiculo: vehiculos){
            if (vehiculo instanceof Taxi){
                Taxi taxi = (Taxi) vehiculo;
                System.out.println(taxi);
            } else if (vehiculo instanceof MiniBus miniBus){
                System.out.println(miniBus);
            } else if (vehiculo instanceof Bus bus){
                System.out.println(bus);
            }
        }
        System.out.println("-----------------------------------------------");

        ArrayList<LibroVenta> pruebas = new ArrayList<>();
        List<LibroVenta> prueba2 = new ArrayList<>();

        LibroVenta prueba3 = new LibroVenta("VentaTrooper", "20240517");
        List<LibroVenta> lb1 = new ArrayList<>();
        lb1.add(prueba3);

        ArrayList<LibroVenta> lb2 = new ArrayList<>();
        lb2.add(prueba3);

        prueba3.setNombreVenta("Cualquier cosa");

        System.out.println("****************************");
        System.out.println(prueba3);
        System.out.println(lb1.get(0));
        System.out.println(lb2.getFirst());
        System.out.println("****************************");
    }
}