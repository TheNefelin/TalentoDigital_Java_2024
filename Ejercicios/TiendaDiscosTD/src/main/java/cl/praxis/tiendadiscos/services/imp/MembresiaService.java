package cl.praxis.tiendadiscos.services.imp;

import cl.praxis.tiendadiscos.entities.Membresia;
import cl.praxis.tiendadiscos.repositories.IMembresiaRepository;
import cl.praxis.tiendadiscos.services.IServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class MembresiaService implements IServiceCRUD<Membresia> {
    @Autowired
    IMembresiaRepository membresiaRepository;

    @Override
    public List<Membresia> findAll() {
        List<Membresia> membresias = membresiaRepository.findAll();
        membresias.sort(Comparator.comparing(Membresia::getNombre));
        return membresias;
    }
}
