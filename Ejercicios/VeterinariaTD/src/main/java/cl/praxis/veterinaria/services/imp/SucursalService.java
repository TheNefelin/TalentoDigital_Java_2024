package cl.praxis.veterinaria.services.imp;

import cl.praxis.veterinaria.models.entities.Sucursal;
import cl.praxis.veterinaria.repositories.ISucursalRepository;
import cl.praxis.veterinaria.services.IServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class SucursalService implements IServiceCRUD<Sucursal> {
    @Autowired
    ISucursalRepository sucursalRepository;

    @Override
    public List<Sucursal> getAll() {
        List<Sucursal> sucursales = sucursalRepository.findAll();
        sucursales.sort(Comparator.comparing(Sucursal::getNombre));
        return sucursales;
    }
}
