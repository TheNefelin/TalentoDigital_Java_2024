package cl.praxis.veterinaria.applicationjava;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Servicio implements IAlgoritmoStock, IAlgoritmoMascota {
    private Repositorio repositorio;

    public Servicio() {
        repositorio = new Repositorio();
    }

    @Override
    public void checkStrock(int idSucursal) {
        List<Producto> productos = repositorio.getProductos()
                .stream()
                .filter(e -> e.getIdSucursal() == idSucursal)
                .collect(Collectors.toList());

        System.out.println("-- Inventario -----------------------------------");
        productos.forEach(producto -> {
            if (idSucursal == 1 && producto.getStock() < 15) {
                System.out.println(producto.getNombre() + " Quedan: " + producto.getStock() + " Usidades (reposición inmediata)");
            } else if (idSucursal == 2 && producto.getStock() <= 5) {
                System.out.println(producto.getNombre() + " Quedan: " + producto.getStock() + " Usidades (reposición inmediata)");
            } else {
                System.out.println(producto.getNombre() + " Quedan: " + producto.getStock() + " Usidades");
            }
        });
        System.out.println("-------------------------------------------------");
    }

    @Override
    public void verificarCita(LocalDate fecha) {
        List<Mascota> mascotas = repositorio.getMascotas()
                .stream()
                .filter(e -> e.getFecha().equals(fecha))
                .collect(Collectors.toList());


        System.out.println("-- Cita Mascota ---------------------------------");
        mascotas.forEach(mascota -> {
            System.out.println(mascota.getTipo() + " " + mascota.getNombre() + " tiene " + mascota.getAtencion());
        });
        System.out.println("-------------------------------------------------");
    }
}
