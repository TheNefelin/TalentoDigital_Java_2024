package cl.praxis.tiendadiscos.services.imp;

import cl.praxis.tiendadiscos.entities.Miembro;
import cl.praxis.tiendadiscos.repositories.IMiembroRepository;
import cl.praxis.tiendadiscos.services.IMiembroService;
import cl.praxis.tiendadiscos.services.IServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MiembroService implements IServiceCRUD<Miembro>, IMiembroService {
    @Autowired
    IMiembroRepository miembroRepository;

    @Override
    public List<Miembro> findAll() {
        return miembroRepository.findAll();
    }

    @Override
    public List<Miembro> findAllByIdSucursalAndIdMembresia(int idSucursal, int idMembresia) {
        return miembroRepository.findAllByIdSucursalAndIdMembresia(idSucursal, idMembresia);
    }
}
