package cl.praxis.tiendadiscos.services;

import cl.praxis.tiendadiscos.entities.Miembro;

import java.util.List;

public interface IMiembroService {
    List<Miembro> findAllByIdSucursalAndIdMembresia(int idSucursal, int idMembresia);
}
