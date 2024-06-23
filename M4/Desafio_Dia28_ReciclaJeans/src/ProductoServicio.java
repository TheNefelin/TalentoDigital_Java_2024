import java.util.ArrayList;
import java.util.List;

public class ProductoServicio {
    private static ProductoServicio productoServicio;
    private List<Producto> listaProductos;

    private ProductoServicio() {
        listaProductos = new ArrayList<Producto>();
    }

    public static ProductoServicio getInstance() {
        if (productoServicio == null) {
            productoServicio = new ProductoServicio();
        }

        return productoServicio;
    }

    public void listarProductos() {
        if (listaProductos.isEmpty()) {
            System.out.println(Utilidad.FONT_RED + "No se encontraron ningun producto:");
        } else {
            for(Producto p : listaProductos) {
                System.out.print(Utilidad.FONT_YELLOW);
                System.out.println("------------- Datos del Producto ----------------");
                System.out.println("Nombre articulo: " + p.getArticulo());
                System.out.println("Código: " + p.getCodigo());
                System.out.println("Marca: " + p.getMarca());
                System.out.println("Color: " + p.getColor());
                System.out.println("Descripcion: " + p.getDescripcion());
                System.out.println("Precio: " + p.getPrecio());
                System.out.println("Talla: " + p.getTalla());
                System.out.println("-------------------------------------------------");
            }
        }
    }

    public void agregarProductos(Producto producto) {
        listaProductos.add(producto);
    }

    public Producto obtenerProducto(int codigo) {
        return listaProductos.stream().filter(e -> e.getCodigo() == codigo).findFirst().orElse(null);
    }

    public void modificarProducto(int codigo, Producto producto) {
        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getCodigo() == codigo) {
                listaProductos.set(i, producto);
                break;
            }
        }
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
