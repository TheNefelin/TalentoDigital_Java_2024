package cl.praxis.view;

import cl.praxis.modelos.CategoriaEnum;
import cl.praxis.modelos.Cliente;
import cl.praxis.services.ExportarCsv;
import cl.praxis.services.ExportarTxt;
import cl.praxis.services.ServicioArchivo;
import cl.praxis.services.ServicioCliente;
import cl.praxis.utils.Colores;
import cl.praxis.utils.Consola;

import java.util.ArrayList;

public class Menu {
    private ServicioCliente servicioCliente;
    private ServicioArchivo servicioArchivo;
    private ExportarCsv exportarCsv; // sin usar para evitar codigo repetido
    private ExportarTxt exportarTxt; // sin usar para evitar codigo repetido
    private final String FILE_NAME_EXPORTAR = "Clientes";
    private final String FILE_NAME_IMPORTAR = "DBClientes.csv";

    public Menu() {
        servicioCliente = ServicioCliente.getInstancia();
        servicioArchivo = ServicioArchivo.getInstancia();
    }

    public void iniciarMenu() {
        int opcion;
        ArrayList<String> opciones = new ArrayList<>();
        opciones.add("1. Listar Clientes");
        opciones.add("2. Agregar Cliente");
        opciones.add("3. Editar Cliente");
        opciones.add("4. Cargar Datos");
        opciones.add("5. Exportar Datos");
        opciones.add("6. Salir");

        do {
            Consola.limpiarConsola();

            System.out.println(Colores.FONT_YELLOW + "--------------------- Menu ----------------------");
            for (String op: opciones) {
                System.out.println(Colores.FONT_PURPLE + op);
            }
            System.out.println(Colores.FONT_YELLOW + "-------------------------------------------------");

            opcion = Consola.inputInt("Ingrese una Opcion:");

            if (opcion >= 1 && opcion <= opciones.size() -1) {
                System.out.println(opciones.get(opcion -1));

                if (opcion == 1)
                    listarCliente();
                if (opcion == 2)
                    agregarCliente();
                if (opcion == 3)
                    editarCliente();
                if (opcion == 4)
                    importarDatos();
                if (opcion == 5)
                    exportarDatos();
            } else if (opcion == opciones.size()) {
                System.out.println(opciones.get(opcion - 1));
                terminarPrograma();
            } else {
                System.out.println(Colores.FONT_RED + "Ingrese una Opcion Valida (Menu)");
                opcion = 0;
            }
        } while (opcion != opciones.size());
    }

    public void listarCliente() {
        servicioCliente.listarClientes();
    }

    public void agregarCliente() {
        System.out.println(Colores.FONT_YELLOW + "----------------- Crear Cliente -----------------");
        int rut = Consola.inputInt("Ingresa RUN del Cliente:");
        String nombre = Consola.inputStr("Ingresa Nombre del Cliente:");
        String apellido = Consola.inputStr("Ingresa Apellido del Cliente:");
        int anio = Consola.inputInt("Ingresa Años como Cliente:");

        Cliente nuevoCliente = new Cliente(rut, nombre, apellido, anio, CategoriaEnum.ACTIVO);
        servicioCliente.agregarCliente(nuevoCliente);

        System.out.println("Cliente Creado Correctamente");
    }

    public void editarCliente() {
        int opcion;

        System.out.println(Colores.FONT_YELLOW + "---------------- Editar Cliente -----------------");
        System.out.println(Colores.FONT_PURPLE + "Seleccione que Desea Hacer:");
        System.out.println("1.- Cambiar el Estado del Cliente");
        System.out.println("2.- Editar los Datos Ingresados del Cliente");
        System.out.println(Colores.FONT_YELLOW + "-------------------------------------------------");

        do {
            opcion = Consola.inputInt("Ingrese una Opcion");
            if (opcion == 1 || opcion == 2){
                int run = Consola.inputInt("Ingrese el Rut del Cliente a Editar");
                Cliente cliente = servicioCliente.getClienteByRun(run);

                if (cliente == null) {
                    System.out.println(Colores.FONT_RED + "El Cliente no Existe");
                    return;
                }

                if (opcion == 1)
                    editarClienteEstado(run, cliente);
                if (opcion == 2)
                    editarClienteDatos(run, cliente);
            }
            else
                System.out.println(Colores.FONT_RED + "Ingrese una Opcion Valida (menuEditar)");
        } while (opcion != 1 && opcion != 2);
    }

    private void editarClienteEstado(int run, Cliente cliente) {
        int opcion;

        System.out.println(Colores.FONT_YELLOW + "-------- Actualizando Estado del Cliente --------");
        System.out.println(Colores.FONT_PURPLE + "El Estado actual del cliente es: " + cliente.getCategoria());
        System.out.println("1.- Si Desea Cambiar el Estado del Cliente a Inactivo");
        System.out.println("2.- Si Desea Mantener el Estado del Cliente Aactivo");
        System.out.println(Colores.FONT_YELLOW + "-------------------------------------------------");

        do {
            opcion = Consola.inputInt("Ingrese una Opcion");
            if (opcion == 1) {
                cliente.setCategoria(CategoriaEnum.INACTIVO);
                // servicioCliente.editarCliente(run, cliente); // opcion redundante
                System.out.println("Estado Modificado Correctamente a Inactivo");
            } else if (opcion == 2) {
                cliente.setCategoria(CategoriaEnum.INACTIVO);
                // servicioCliente.editarCliente(run, cliente); // opcion redundante
                System.out.println("Estado Modificado Correctamente a Activo");
            } else
                System.out.println(Colores.FONT_RED + "Ingrese una Opcion Valida (menuEditarEstado)");
        } while (opcion != 1 && opcion != 2);
    }

    private void editarClienteDatos(int run, Cliente cliente) {
        int opcion;

        System.out.println(Colores.FONT_YELLOW + "-------- Actualizando Datos del Cliente ---------");
        System.out.println(Colores.FONT_PURPLE + "1.- El RUN del Cliente es: " + cliente.getRun());
        System.out.println("2.- El Nombre del Cliente es: " + cliente.getNombre());
        System.out.println("3.- El Apellido del Cliente es: " + cliente.getApellido());
        System.out.println("4.- Los Años como Cliente son: " + cliente.getAnios());
        System.out.println(Colores.FONT_YELLOW + "-------------------------------------------------");

        do {
            opcion = Consola.inputInt("Ingrese una Opcion");
            if (opcion == 1) {
                int nuevoRut = Consola.inputInt("Ingrese Nuevo Rut del Cliente");
                cliente.setRun(nuevoRut);
                // servicioCliente.editarCliente(run, cliente); // opcion redundante
                System.out.println("RUT Modificado Correctamente");
            }
            else if (opcion == 2) {
                String nombre = Consola.inputStr("Ingrese Nuevo Nombre del Cliente");
                cliente.setNombre(nombre);
                // servicioCliente.editarCliente(run, cliente); // opcion redundante
                System.out.println("Nombre Modificado Correctamente");
            }
            else if (opcion == 3) {
                String apellido = Consola.inputStr("Ingrese Nuevo Apellido del Cliente");
                cliente.setApellido(apellido);
                // servicioCliente.editarCliente(run, cliente); // opcion redundante
                System.out.println("Apellido Modificado Correctamente");
            }
            else if (opcion == 4) {
                int anios = Consola.inputInt("Ingrese Nuevo Años como Cliente");
                cliente.setAnios(anios);
                // servicioCliente.editarCliente(run, cliente); // opcion redundante
                System.out.println("Años como Cliente Modificado Correctamente");
            }
            else
                System.out.println(Colores.FONT_RED + "Ingrese una Opcion Valida (menuEditarEstado)");
        } while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4);
    }

    public void importarDatos() {
        servicioArchivo.cargarDatos(obtenerRuta(true, FILE_NAME_IMPORTAR));
    }

    private String obtenerRuta(boolean isImportar, String fileName) {
        String ruta;
        String os = System.getProperty("os.name").toLowerCase();

        String mensaje = isImportar ? "Ingrese la ruta en donde se encuentra el archivo " + fileName
                                    : "Ingrese la ruta en donde desea exportar el archivo " + fileName;

        String mensaje2 = isImportar ? "Importar" : "Exportar";

        if (os.contains("win")) {
            do {
                System.out.println(Colores.FONT_YELLOW + "----------- " + mensaje2 + " Datos en Windows -----------");
                System.out.println(mensaje);
                ruta = Consola.inputStr("C:\\usuario\\equipo\\Desktop");
            } while (!validarRutaWin(ruta));

            ruta = ruta.endsWith("\\") ? ruta : ruta.concat("\\");
        } else {
            do {
                System.out.println(Colores.FONT_YELLOW + "---------- " + mensaje2 + " Datos en Linux o Mac ----------");
                System.out.println(mensaje);
                ruta = "/home/usuario/Desktop"; // ruta ejemplo
            } while (!validarRutaLinuxMac(ruta));

            ruta = ruta.endsWith("/") ? ruta : ruta.concat("/");
        }

        return ruta.concat(fileName);
    }

    private boolean validarRutaWin(String ruta) {
        return ruta.matches("^[a-zA-Z]:\\\\.*$");
    }

    private boolean validarRutaLinuxMac(String ruta) {
        return ruta.startsWith("/") || ruta.startsWith("~/");
    }

    public void exportarDatos() {
        int opcion;
        String extencion;

        System.out.println(Colores.FONT_YELLOW + "---------------- Exportar Datos -----------------");
        System.out.println(Colores.FONT_PURPLE + "1.- Formato csv");
        System.out.println("2.- Formato txt");
        System.out.println(Colores.FONT_YELLOW + "-------------------------------------------------");

        do {
            opcion = Consola.inputInt("Ingrese una Opcion");

            if (opcion == 1 || opcion == 2) {
                extencion = opcion == 1 ? ".csv" : ".txt";

                servicioArchivo.exportar(obtenerRuta(false, FILE_NAME_EXPORTAR.concat(extencion)), servicioCliente.listaClientes());
                System.out.println("Datos de " + FILE_NAME_EXPORTAR + " Exportados correctamente en formato " + extencion);
            }
            else
                System.out.println(Colores.FONT_RED + "Ingrese una Opcion Valida (menuExportarDatos)");
        } while (opcion != 1 && opcion != 2);
    }

    private void terminarPrograma() {
        System.out.println("Saliendo del sistema...");
    }
}
