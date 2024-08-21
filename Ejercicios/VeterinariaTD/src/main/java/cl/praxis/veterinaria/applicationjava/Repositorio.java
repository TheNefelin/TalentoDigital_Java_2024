package cl.praxis.veterinaria.applicationjava;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    private List<Producto> productos = new ArrayList<>();
    private List<Mascota> mascotas = new ArrayList<>();

    public Repositorio(){
        productos.add(new Producto(1, "Collar Rojo", "BrandPig", 4, 1));
        productos.add(new Producto(2, "Analgesico", "Bayer", 12, 1));
        productos.add( new Producto(3, "Hueso Goma", "BrandPig", 2, 2));
        productos.add(new Producto(4, "Multi Vitaminico", "Bayer", 8, 2));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        mascotas.add(new Mascota(1, "Perro", "wolf" , LocalDate.parse("2024-08-17", formatter), "Atencion Medica"));
        mascotas.add(new Mascota(2, "Loro", "Plover", LocalDate.parse("2024-08-19", formatter), "Atencion Medica"));
        mascotas.add(new Mascota(3, "Hamster", "ferret" , LocalDate.parse("2024-08-18", formatter), "Atencion Medica"));
        mascotas.add(new Mascota(4, "Gato", "Squirrel", LocalDate.parse("2024-08-17", formatter), "Cirugia"));
        mascotas.add(new Mascota(5, "Caballo", "pilot", LocalDate.parse("2024-08-17", formatter), "Cirugia"));
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }
}
