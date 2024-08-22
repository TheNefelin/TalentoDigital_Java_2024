package cl.praxis.gestionclinica.repositories;

import cl.praxis.gestionclinica.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
    List<Doctor> findDoctoresByEspecialidad_Id(int idEspecialidad);
}
