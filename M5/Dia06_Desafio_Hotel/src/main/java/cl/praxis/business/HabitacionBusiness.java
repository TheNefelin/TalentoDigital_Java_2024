package cl.praxis.business;

import cl.praxis.model.Habitacion;

import java.util.ArrayList;
import java.util.List;

public class HabitacionBusiness {
    private ArrayList<Habitacion> habitaciones = new ArrayList<>();

    public HabitacionBusiness() {
        Habitacion habitacion1 = new Habitacion();
        habitacion1.setId(1);
        habitacion1.setNombre("Habitación 1, Simple");
        habitacion1.setDescripcion("Habitación Clásica con cama extragrande,vistas al océano y balcón");
        habitacion1.setImagen("https://cf.bstatic.com/xdata/images/hotel/max1024x768/461652315.jpg?k=f51a6b496658d7625896c48445c617885c8580f67c1625d52434253413a15423&o=&hp=1");
        habitacion1.setPrecio(10000);
        habitacion1.setHabitaciones(1);
        habitacion1.setMetraje(1);

        Habitacion habitacion2 = new Habitacion();
        habitacion2.setId(2);
        habitacion2.setNombre("Habitación 2,Doble Simple");
        habitacion2.setDescripcion("Habitación Clásica con 2 camas grandes o dobles, vistas al océano y balcón");
        habitacion2.setImagen("https://static11.com-hotel.com/uploads/hotel/11063/photo/sheraton-lima-hotel-convention-center_155183515633.jpg");
        habitacion2.setPrecio(20000);
        habitacion2.setHabitaciones(1);
        habitacion2.setMetraje(1);

        Habitacion habitacion3 = new Habitacion();
        habitacion3.setId(3);
        habitacion3.setNombre("Habitación 3 ,Doble Normal");
        habitacion3.setDescripcion("Habitación Superior en planta alta con vistas al océano y 2 camas dobles");
        habitacion3.setImagen("https://y.cdrst.com/foto/hotel-sf/a8f9/granderesp/sheraton-miramar-hotel-convention-center-habitacion-123fdbe3.jpg");
        habitacion3.setPrecio(30000);
        habitacion3.setHabitaciones(1);
        habitacion3.setMetraje(1);

        Habitacion habitacion4 = new Habitacion();
        habitacion4.setId(4);
        habitacion4.setNombre("Habitacion 4, Doble King");
        habitacion4.setDescripcion("Suite Executive en planta superior con cama extragrande y vistas al océano");
        habitacion4.setImagen("https://cf.bstatic.com/xdata/images/hotel/max1024x768/470213577.jpg?k=e518e030cafa455eed6415b0a6d9e8b0b0c6b895ce3ad619aece3a4b7c33962b&o=&hp=1");
        habitacion4.setPrecio(40000);
        habitacion4.setHabitaciones(1);
        habitacion4.setMetraje(1);

        Habitacion habitacion5 = new Habitacion();
        habitacion5.setId(5);
        habitacion5.setNombre("Habitacion 5, Doble King");
        habitacion5.setDescripcion("Suite Executive en planta superior con cama extragrande y vistas al océano");
        habitacion5.setImagen("https://dynamic-media-cdn.tripadvisor.com/media/photo-s/02/7f/66/bd/governor-s-suite-bedroom.jpg?w=600&h=-1&s=1");
        habitacion5.setPrecio(50000);
        habitacion5.setHabitaciones(1);
        habitacion5.setMetraje(1);

        Habitacion habitacion6 = new Habitacion();
        habitacion6.setId(6);
        habitacion6.setNombre("Habitacion 6, Doble King");
        habitacion6.setDescripcion("Suite Executive en planta superior con cama extragrande y vistas al océano");
        habitacion6.setImagen("https://static11.com-hotel.com/uploads/hotel/10610/photo/sheraton-miramar-hotel-convention-center_15126747881.jpg");
        habitacion6.setPrecio(60000);
        habitacion6.setHabitaciones(1);
        habitacion6.setMetraje(1);

        Habitacion habitacion7 = new Habitacion();
        habitacion7.setId(7);
        habitacion7.setNombre("Habitacion 7, Doble King");
        habitacion7.setDescripcion("Suite Executive en planta superior con cama extragrande y vistas al océano");
        habitacion7.setImagen("https://cf.bstatic.com/xdata/images/hotel/max1024x768/470194367.jpg?k=f524894e1948bf192a336f69385fa12709252c616c671af5a8bf576bca7943eb&o=&hp=1");
        habitacion7.setPrecio(70000);
        habitacion7.setHabitaciones(1);
        habitacion7.setMetraje(1);

        Habitacion habitacion8 = new Habitacion();
        habitacion8.setId(8);
        habitacion8.setNombre("Habitacion 8, Doble King");
        habitacion8.setDescripcion("Suite Executive en planta superior con cama extragrande y vistas al océano");
        habitacion8.setImagen("https://cf.bstatic.com/xdata/images/hotel/max1024x768/465573749.jpg?k=e1d2196e21a3fbe94f2bf4a2f6b5daa87f2086916584957b8b370d9fc110bbb7&o=&hp=1");
        habitacion8.setPrecio(80000);
        habitacion8.setHabitaciones(1);
        habitacion8.setMetraje(1);

        habitaciones.add(habitacion1);
        habitaciones.add(habitacion2);
        habitaciones.add(habitacion3);
        habitaciones.add(habitacion4);
        habitaciones.add(habitacion5);
        habitaciones.add(habitacion6);
        habitaciones.add(habitacion7);
        habitaciones.add(habitacion8);
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public Habitacion getHabitacionById(int idHabitacion) {
        List<Habitacion> listaHabitaciones = getHabitaciones();

        return listaHabitaciones.stream().filter(h -> h.getId() == idHabitacion).findFirst().orElse(null);
    }

    public int calculaValorCompra(int valorHabitacion, int cantidadTickets) {
        int valor = valorHabitacion * cantidadTickets;
        return valor;
    }
}
