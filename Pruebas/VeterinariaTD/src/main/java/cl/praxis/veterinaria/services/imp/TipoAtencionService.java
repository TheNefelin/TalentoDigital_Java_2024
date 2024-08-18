package cl.praxis.veterinaria.services.imp;

import cl.praxis.veterinaria.models.entities.TipoAtencion;
import cl.praxis.veterinaria.repositories.ITipoAtencionRepository;
import cl.praxis.veterinaria.services.IServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class TipoAtencionService implements IServiceCRUD<TipoAtencion> {
    @Autowired
    private ITipoAtencionRepository tipoAtencionRepository;

    @Override
    public List<TipoAtencion> getAll() {
        List<TipoAtencion> tipoAtenciones = tipoAtencionRepository.findAll();
        tipoAtenciones.sort(Comparator.comparing(TipoAtencion::getNombre));
        return tipoAtenciones;
    }
}
