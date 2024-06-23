package cl.praxis.services;

import cl.praxis.modelos.Cliente;
import cl.praxis.utils.Colores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServicioCliente {
    private static ServicioCliente instancia;
    private List<Cliente> lisaClientes;

    private ServicioCliente(){
        lisaClientes = new ArrayList<>();
    }

    public static synchronized ServicioCliente getInstancia() {
        if (instancia == null) {
            instancia = new ServicioCliente();
        }
        return instancia;
    }

    public void listarClientes() {
        if (!lisaClientes.isEmpty()) {
            for (Cliente cliente : lisaClientes) {
                System.out.println(Colores.FONT_YELLOW + "--------------- Dats del CLiente ----------------");
                System.out.println(Colores.FONT_GREEN + "Run de Cliente: " + cliente.getRun());
                System.out.println("Nombre del Cliente: " + cliente.getNombre());
                System.out.println("Apellido del Cliente: " + cliente.getApellido());
                System.out.println("Años como Cliente: " + cliente.getAnios());
                System.out.println("Categoría del Cliente: " + cliente.getCategoria());
                System.out.println(Colores.FONT_YELLOW + "-------------------------------------------------");
            }
        } else
            System.out.println(Colores.FONT_RED + "No hay clientes");
    }

    public void agregarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo");
        }
        lisaClientes.add(cliente);
    }

    public void editarCliente(int run, Cliente clienteModificado) {
        for (Cliente cliente : lisaClientes) {
            if (cliente.getRun() == run) {
                cliente.setRun(run);
                cliente.setNombre(clienteModificado.getNombre());
                cliente.setApellido(clienteModificado.getApellido());
                cliente.setAnios(clienteModificado.getAnios());
                cliente.setCategoria(clienteModificado.getCategoria());
            }
            break;
        }
    }

    public List<Cliente> listaClientes() {
        return lisaClientes;
    }

    public Cliente getClienteByRun(int run) {
        Optional<Cliente> cliente = lisaClientes.stream().filter(e -> e.getRun() == run).findAny();

        return cliente.orElse(null);
    }
}
