package cl.praxis.restorant.services;

import cl.praxis.restorant.entities.ComandaDetalle;

import java.util.List;

public interface IComandaDetalleService {
    List<ComandaDetalle> findByIdComanda(int idComanda);
}
