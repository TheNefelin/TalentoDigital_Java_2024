package cl.praxis.veterinaria.services;

import cl.praxis.veterinaria.models.entities.Atencion;

import java.util.List;

public interface IAtencionService {
    List<Atencion> getAllByIdSucursalAndIdTipoAtencion(int idSucursal, int idTipoAtencion);
}
