import java.util.ArrayList;

public class Menu {
    ArrayList<String> opciones = new ArrayList<>();

    public Menu() {
        opciones.add("1. Listar Producto");
        opciones.add("2. Agregar Producto");
        opciones.add("3. Editar Producto");
        opciones.add("4. Importar Datos");
        opciones.add("5. Salir");

        getOpciones();
    }

    private void getMenu() {
        System.out.println(Utilidad.FONT_YELLOW + "--------------------- Menu ----------------------");
        for (String op: opciones)
            System.out.println(Utilidad.FONT_PURPLE + op);
        System.out.println(Utilidad.FONT_YELLOW + "-------------------------------------------------");
    }

    public void getOpciones() {
        int opcion;

        getMenu();

        do {
            opcion = Utilidad.inputInt("Ingrese una Opcion:");

            if (opcion >= 1 && opcion <= opciones.size() - 1) {
                System.out.println(opciones.get(opcion - 1));
                if (opcion == 1)
                    listarProducto();
                if (opcion == 2)
                    agregarProducto();
                if (opcion == 3)
                    modificarProducto();
                if (opcion == 4) {
                    importarDatos();
                }
                getMenu();
            } else if (opcion == opciones.size())
                System.out.println("Saliedo...");
            else {
                System.out.println("Ingrese una Opcion Valida (Menu)");
                opcion = 0;
            }
        } while (opcion != opciones.size());
    }

    private void listarProducto() {
        System.out.println("-------------- Listar Producto ------------------");
        ProductoServicio productoServicio = ProductoServicio.getInstance();
        productoServicio.listarProductos();
    }

    private void agregarProducto() {
        System.out.println("------------- Agregar Producto ------------------");
        String articulo = Utilidad.inputStr("Ingresar nombre articulo:");
        int precio = Utilidad.inputInt("Ingresar precio:");
        String descripcion = Utilidad.inputStr("Ingresar descripción:");
        int codigo = Utilidad.inputInt("Ingresar código:");
        String talla = Utilidad.inputStr("Ingresar talla:");
        String marca = Utilidad.inputStr("Ingresar marca:");
        String color = Utilidad.inputStr("Ingresar color:");

        ProductoServicio productoServicio = ProductoServicio.getInstance();
        productoServicio.agregarProductos(new Producto(articulo, precio, descripcion, codigo, talla, marca, color));
        System.out.println("--------------- Producto Agregado ---------------");
    }

    private void modificarProducto() {
        int codigo = Utilidad.inputInt("Ingresar codigo del producto:");

        ProductoServicio productoServicio = ProductoServicio.getInstance();
        Producto producto = productoServicio.obtenerProducto(codigo);

        if (producto == null){
            System.out.println("El Producto No Existe:");
        } else {
            System.out.println("------------------- Producto --------------------");
            System.out.println("1.- El nombre del articulo actual es: " + producto.getArticulo());
            System.out.println("2.- El código del producto: " + producto.getCodigo());
            System.out.println("3.- El color del producto: " + producto.getColor());
            System.out.println("4.- La descripción del producto: " + producto.getDescripcion());
            System.out.println("5.- La marca del producto: " + producto.getMarca());
            System.out.println("6.- El precio del producto: " + producto.getPrecio());
            System.out.println("7.- La talla del producto: " + producto.getTalla());
            System.out.println("-------------------------------------------------");

            int opcion = Utilidad.inputInt("Ingrese la opción a editar de los datos del producto:");

            if (opcion == 1) producto.setArticulo(Utilidad.inputStr("Ingrese el nuevo nombre del producto:"));
            if (opcion == 2) producto.setCodigo(Utilidad.inputInt("Ingrese el nuevo código del producto:"));
            if (opcion == 3) producto.setColor(Utilidad.inputStr("Ingrese el nuevo color del producto:"));
            if (opcion == 4) producto.setDescripcion(Utilidad.inputStr("Ingrese la nueva descripción del producto:"));
            if (opcion == 5) producto.setMarca(Utilidad.inputStr("Ingrese la nueva marca del producto:"));
            if (opcion == 6) producto.setPrecio(Utilidad.inputInt("Ingrese el nuevo precio del producto:"));
            if (opcion == 7) producto.setTalla(Utilidad.inputStr("Ingrese la nueva talla del producto:"));

            productoServicio.modificarProducto(codigo, producto);
        }
    }

    private void importarDatos() {
        System.out.println("Ingresa la ruta en donde se encuentra el archivo:");

        String ruta = Utilidad.inputStr("Sugerencia: data/ProductosImportados.csv");

        ArchivoServicio archivo = ArchivoServicio.getInstance();
        archivo.cargarDatos(ruta);
    }
}
