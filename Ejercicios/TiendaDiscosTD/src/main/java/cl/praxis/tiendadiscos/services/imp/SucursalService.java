package cl.praxis.tiendadiscos.services.imp;

import cl.praxis.tiendadiscos.entities.Sucursal;
import cl.praxis.tiendadiscos.repositories.ISucursalSepository;
import cl.praxis.tiendadiscos.services.IServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class SucursalService implements IServiceCRUD<Sucursal> {
    @Autowired
    ISucursalSepository sucursalSepository;

    @Override
    public List<Sucursal> findAll() {
        List<Sucursal> sucursales = sucursalSepository.findAll();
        sucursales.sort(Comparator.comparing(Sucursal::getNombre));
        return sucursales;
    }
}
