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
        for (Producto producto : listaProductos) {
            System.out.println(producto);
        }
    }

    public void agregarProductos(Producto producto) {
        listaProductos.add(producto);
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
