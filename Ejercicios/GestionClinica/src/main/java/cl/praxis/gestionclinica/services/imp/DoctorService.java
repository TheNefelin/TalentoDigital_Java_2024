package cl.praxis.gestionclinica.services.imp;

import cl.praxis.gestionclinica.entities.Doctor;
import cl.praxis.gestionclinica.repositories.IDoctorRepository;
import cl.praxis.gestionclinica.services.IDoctorService;
import cl.praxis.gestionclinica.services.IServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService implements IServiceCRUD<Doctor>, IDoctorService {
    @Autowired
    IDoctorRepository doctorRepository;

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public List<Doctor> findDoctoresPrototipe(int idEspecialidad, String buscar) {
        return doctorRepository.findDoctoresPrototipe(idEspecialidad, buscar);
    }

    @Override
    public List<Doctor> findDoctoresByIdAndText(int idEspecialidad, String buscar) {
        return doctorRepository.findAll()
                .stream()
                .filter(e ->
                        (
                            e.getId() == idEspecialidad ||
                            idEspecialidad == 0
                        ) && (
                            String.valueOf(e.getId()).contains(buscar) ||
                            e.getNombre().toLowerCase().contains(buscar.toLowerCase()) ||
                            e.getEspecialidad().getNombre().toLowerCase().contains(buscar.toLowerCase()) ||
                            String.valueOf(e.getExperiencia()).contains(buscar)
                        )
                )
                .toList();
    }

    @Override
    public Doctor findById(int id) {
        return doctorRepository.findById(id).orElse(null);
    }

    @Override
    public Doctor create(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor update(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public void delete(int id) {
        doctorRepository.deleteById(id);
    }
}
