package cl.praxis.veterinaria.services.imp;

import cl.praxis.veterinaria.models.entities.Atencion;
import cl.praxis.veterinaria.repositories.IAtencionRepository;
import cl.praxis.veterinaria.services.IAtencionService;
import cl.praxis.veterinaria.services.IServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class AtencionService implements IServiceCRUD<Atencion> {
    @Autowired
    IAtencionRepository atencionRepository;

    @Override
    public List<Atencion> getAll() {
        List<Atencion> atencions = atencionRepository.findAll();
        return atencionRepository.findAll();
    }

    //@Override
    public List<Atencion> getAllByIdSucursalAndIdTipoAtencion(int idSucursal, int idTipoAtencion) {
        return atencionRepository.findBySucursalIdAndTipoAtencionId(idSucursal, idTipoAtencion);
    }
}
