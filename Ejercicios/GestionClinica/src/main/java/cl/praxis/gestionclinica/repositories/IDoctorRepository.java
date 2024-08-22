package cl.praxis.gestionclinica.repositories;

import cl.praxis.gestionclinica.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
    @Query("SELECT d FROM Doctor d WHERE " +
            "(" +
                "CAST(d.id AS string) LIKE %:buscar% OR " +
                "d.nombre LIKE %:buscar% OR " +
                "d.especialidad.nombre LIKE %:buscar% OR " +
                "CAST(d.experiencia AS string) LIKE %:buscar% " +
            ") AND (" +
                ":idEspecialidad = 0 OR " +
                "d.especialidad.id = :idEspecialidad" +
            ")")
    List<Doctor> findDoctoresPrototipe(int idEspecialidad , String buscar);
}
