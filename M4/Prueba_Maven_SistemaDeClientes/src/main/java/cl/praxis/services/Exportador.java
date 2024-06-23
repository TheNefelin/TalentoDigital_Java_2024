package cl.praxis.services;

import cl.praxis.modelos.Cliente;

import java.util.List;

public abstract class Exportador {
    public abstract void exportar(String fileName, List<Cliente> listaClientes);
}
