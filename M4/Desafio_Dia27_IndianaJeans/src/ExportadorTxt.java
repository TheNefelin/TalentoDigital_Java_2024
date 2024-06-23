import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ExportadorTxt extends ExportarTxt {

    @Override
    public void exportar() {
        ProductoServicio listaProductos = ProductoServicio.getInstance();

        File dir = new File("src/cl/praxis/curso/M4/desafio_m4_dia27/data");

        if (!dir.exists()){
            if (!dir.mkdir())  {
                System.out.println("Error al Crear el directorio");
                return;
            }
        }

        File file = new File(dir.getAbsolutePath(), "archivo.txt");

        try {
            if (!file.exists()){
                if (!file.createNewFile()) {
                    System.out.println("No se puede crear el archivo");
                }
            }
        } catch (IOException e) {
            System.out.println("Error I/O: " + e.getMessage());
        }

        try {
            FileWriter fw = new FileWriter(file.getAbsolutePath());
            BufferedWriter bw = new BufferedWriter(fw);

            for (Producto p : listaProductos.getListaProductos()) {
                bw.write(p.getArticulo() + "," + p.getPrecio() + "," + p.getDescripcion()  + "," + p.getCodigo() + "," + p.getTalla() + "," + p.getMarca() + "," +  p.getColor());
                bw.newLine();
            }

            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Error I/O: " + e.getMessage());
        }
    }
}
