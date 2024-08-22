package cl.praxis.gestionclinica.controllers.rests;

import cl.praxis.gestionclinica.entities.Doctor;
import cl.praxis.gestionclinica.services.imp.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorRestController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.findAll();
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable int id) {
        return doctorService.findById(id);
    }

    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.create(doctor);
    }

    @PutMapping
    public Doctor updateDoctor(@RequestBody Doctor doctor) {
        return doctorService.update(doctor);
    }

    @DeleteMapping
    public void deleteDoctor(@RequestBody Doctor doctor) {
        doctorService.delete(doctor.getId());
    }
}
