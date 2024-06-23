import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    ArrayList<String> opciones = new ArrayList<>();

    public Menu() {
        opciones.add("1. Listar Producto");
        opciones.add("2. Agregar Producto");
        opciones.add("3. Exportar Datos");
        opciones.add("4. Salir");

        getOpciones();
    }

    private void getMenu() {
        System.out.println("--------------------- Menu ----------------------");
        for (String op: opciones)
            System.out.println(op);
        System.out.println("-------------------------------------------------");
    }

    public void getOpciones() {
        int opcion;

        getMenu();

        do {
            opcion = inputInt("Ingrese una Opcion:");

            if (opcion >= 1 && opcion <= 3) {
                System.out.println(opciones.get(opcion - 1));
                if (opcion == 1)
                    listarProducto();
                if (opcion == 2)
                    agregarProducto();
                if (opcion == 3)
                    exportarProducto();
                getMenu();
            } else if (opcion == 4)
                System.out.println("Saliedo...");
            else {
                System.out.println("Ingrese una Opcion Valida (Menu)");
                opcion = 0;
            }
        } while (opcion != 4);
    }

    private void listarProducto() {
        System.out.println("------------- Listar Producto -------------------");
        ProductoServicio productoServicio = ProductoServicio.getInstance();
        productoServicio.listarProductos();
    }

    private void agregarProducto() {
        System.out.println("------------- Agregar Producto ------------------");
        String articulo = inputStr("Ingresar nombre articulo:");
        int precio = inputInt("Ingresar precio:");
        String descripcion = inputStr("Ingresar descripción:");
        int codigo = inputInt("Ingresar código::");
        String talla = inputStr("Ingresar talla:");
        String marca = inputStr("Ingresar marca:");
        String color = inputStr("Ingresar color:");
        System.out.println("--------------- Producto Agregado ---------------");

        Producto producto = new Producto(articulo, precio, descripcion, codigo, talla, marca, color);
        ProductoServicio productoServicio = ProductoServicio.getInstance();
        productoServicio.agregarProductos(producto);
    }

    private void exportarProducto() {
        ExportadorTxt exportador = new ExportadorTxt();
        exportador.exportar();
    }

    private int inputInt(String msge) {
        Scanner sc = new Scanner(System.in);
        int num = 0;

        do{
            System.out.println(msge);
            if (sc.hasNextInt()) {
                num = sc.nextInt();
            } else {
                System.out.println("Ingrese un Valor Valido (int)");
                sc.nextLine();
            }
        } while (num == 0);

        return num;
    }

    public String inputStr(String msge) {
        Scanner sc = new Scanner(System.in);
        String str = "";

        do{
            System.out.println(msge);
            if (sc.hasNextInt()) {
                System.out.println("Ingrese un Valor Valido (str)");
                sc.nextLine();
            } else {
                str = sc.nextLine();
            }
        } while (str.isEmpty());

        return str;
    }
}
