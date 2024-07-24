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
}
