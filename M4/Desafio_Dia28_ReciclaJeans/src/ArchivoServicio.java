import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ArchivoServicio {
    private static ArchivoServicio archivoServicio;

    private ArchivoServicio() {}

    public static ArchivoServicio getInstance() {
        if (archivoServicio == null) {
            archivoServicio = new ArchivoServicio();
        }

        return archivoServicio;
    }

    public void cargarDatos(String ruta){
        ruta = "src/cl/praxis/curso/M4/desafio_m4_dia28/" + ruta;
        File archivo = new File(ruta);

        if (archivo.exists()){
            try {
                FileReader fr = new FileReader(ruta);
                BufferedReader br = new BufferedReader(fr);

                br.lines().forEach(row -> {
                    String[] data = row.split(",");

                    if (data.length == 7) {
                        ProductoServicio productoServicio = ProductoServicio.getInstance();
                        productoServicio.agregarProductos(new Producto(data[0], Integer.parseInt(data[1]), data[2], Integer.parseInt(data[3]), data[4], data[5], data[6]));
                    }
                });

                fr.close();
                br.close();

                System.out.println(Utilidad.FONT_GREEN + "Datos cargados correctamente en la lista:");
            } catch (IOException e) {
                System.out.println(Utilidad.FONT_RED + "Error I/O: " + e.getMessage());
            }
        } else {
            System.out.println(Utilidad.FONT_RED + "El Archivo No existe:");
        }
    }
}
