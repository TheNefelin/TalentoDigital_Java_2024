import java.util.List;

public class Tienda {
    private Vendedor vendedor;
    private List<Cliente> cliente;
    private int stock;
    private List<Vehiculo> vehiculos;

    public Tienda() {}

    public Tienda(Vendedor vendedor, List<Cliente> clientes, int stock, List<Vehiculo> vehiculos) {
        this.vendedor = vendedor;
        this.cliente = clientes;
        this.stock = stock;
        this.vehiculos = vehiculos;
    }

    public String existeStock() {
        return "Cantidad de Stock es: " + this.stock;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "vendedor=" + vendedor +
                ", cliente=" + cliente +
                ", stock=" + stock +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
