import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LibroVenta {
    private final String path = "src/cl/praxis/curso/M4/desafio_m4_dia25/ficheros";
    private String nombreVenta;
    private String fechaVenta;

    public LibroVenta(String nombreVenta, String fechaVenta) {
        this.nombreVenta = nombreVenta.trim();
        this.fechaVenta = fechaVenta;
    }

    public void guardarVenta(Cliente cliente, Vehiculo vehiculo) {
        boolean estado = false;
        File file = new File(path, getNombreVenta().concat(".txt"));

        try {
            if (!file.exists()){
                if (file.createNewFile()) {
                    estado = true;
                    System.out.println("El archivo se ha guardado correctamente");
                } else {
                    System.out.println("El archivo no se ha guardado correctamente");
                }
            }
        } catch (IOException e) {
            System.out.println("Error I/O: " + e.getMessage());
        }

        if (estado) {
            try {
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write("Patente,Edad,Fecha,NombreDeVenta");
                bw.newLine();

                bw.write(
                        vehiculo.getPatente() + "," +
                                cliente.getEdad() + "," +
                                getFechaVenta() + "," +
                                getNombreVenta()
                );

                bw.close();
                fw.close();
            } catch (IOException e) {
                System.out.println("Error I/O: " + e.getMessage());
            }
        } else {
            System.out.println("Los datos no se ha guardado correctamente");
        }
    }

    public String getNombreVenta() {
        return nombreVenta;
    }

    public void setNombreVenta(String nombreVenta) {
        this.nombreVenta = nombreVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    @Override
    public String toString() {
        return "LibroVenta{" +
                "path='" + path + '\'' +
                ", nombreVenta='" + nombreVenta + '\'' +
                ", fechaVenta='" + fechaVenta + '\'' +
                '}';
    }
}
