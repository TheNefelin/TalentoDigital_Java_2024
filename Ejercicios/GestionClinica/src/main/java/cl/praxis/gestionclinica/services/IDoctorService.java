package cl.praxis.gestionclinica.services;

import cl.praxis.gestionclinica.entities.Doctor;

import java.util.List;

public interface IDoctorService {
    List<Doctor> findDoctoresByEspecialidad_Id(int idEspecialidad);
    List<Doctor> findDoctoresByText(String buscar);
}
