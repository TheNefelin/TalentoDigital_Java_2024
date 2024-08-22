package cl.praxis.gestionclinica.services;

import cl.praxis.gestionclinica.entities.Doctor;

import java.util.List;

public interface IDoctorService {
    List<Doctor> findDoctoresPrototipe(int idEspecialidad, String buscar);
    List<Doctor> findDoctoresByIdAndText(int idEspecialidad, String buscar);
}
