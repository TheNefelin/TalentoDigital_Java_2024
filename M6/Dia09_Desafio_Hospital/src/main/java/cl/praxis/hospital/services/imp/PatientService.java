package cl.praxis.hospital.services.imp;

import cl.praxis.hospital.entities.Patient;
import cl.praxis.hospital.repositories.IPatientRepository;
import cl.praxis.hospital.services.IBaseServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements IBaseServiceCRUD<Patient> {
    @Autowired
    private IPatientRepository repo;

    @Override
    public List<Patient> findAll() {
        return repo.findAll();
    }

    @Override
    public Patient findById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Patient save(Patient patient) {
        return repo.save(patient);
    }

    @Override
    public boolean update(Patient patient) {
        if (repo.findById(patient.getId()).isPresent()) {
            repo.save(patient);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
