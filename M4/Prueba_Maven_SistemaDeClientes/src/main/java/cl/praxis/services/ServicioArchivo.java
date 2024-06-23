package cl.praxis.services;

import cl.praxis.modelos.CategoriaEnum;
import cl.praxis.modelos.Cliente;
import cl.praxis.utils.Colores;

import java.io.*;
import java.util.List;

public class ServicioArchivo extends Exportador {
    private static ServicioArchivo instancia;

    private ServicioArchivo() {}

    public static synchronized ServicioArchivo getInstancia() {
        if (instancia == null) {
            instancia = new ServicioArchivo();
        }
        return instancia;
    }

    @Override
    public void exportar(String fileName, List<Cliente> listaClientes) {
        System.out.println(Colores.FONT_YELLOW + "--------------- Datos Exportados ----------------");

        File archivo = new File(fileName);

        try {
            if (!archivo.exists() && !archivo.createNewFile()) {
                    System.out.println("No se pudo crear el archivo " + fileName);
                    return;
            }

            FileWriter fw = new FileWriter(archivo.getAbsolutePath());
            PrintWriter pw = new PrintWriter(fw);

            for (Cliente cliente : listaClientes) {
                pw.println(cliente.toString());
            }

            pw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println(Colores.FONT_RED + "No se pudo escribr en el archivo");
        }
    }

    public void cargarDatos(String fileName) {
        System.out.println(Colores.FONT_YELLOW + "------------- Datos Importartados ---------------");

        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            br.lines().forEach(fila -> {
                String[] data = fila.split(",");

                if (data.length == 5) {
                    Cliente cliente = new Cliente();

                    cliente.setRun(Integer.parseInt(data[0]));
                    cliente.setNombre(data[1]);
                    cliente.setApellido(data[2]);
                    cliente.setAnios(Integer.parseInt(data[3]));
                    cliente.setCategoria(CategoriaEnum.valueOf(data[4]));

                    ServicioCliente sc = ServicioCliente.getInstancia();
                    sc.agregarCliente(cliente);
                }
            });

            fr.close();
            br.close();

            System.out.println("Datos Cargados Correctamente");
        } catch (IOException e) {
            System.out.println(Colores.FONT_RED + e.getMessage());
        }
    }
}
