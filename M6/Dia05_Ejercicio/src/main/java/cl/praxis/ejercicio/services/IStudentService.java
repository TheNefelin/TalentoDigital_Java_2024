package cl.praxis.ejercicio.services;

import cl.praxis.ejercicio.entities.Student;

import java.util.List;

public interface IStudentService {
    Student getStudentById(int id);
    List<Student> getAllStudents();
    Student addStudent(Student student);
    Student updateStudent(Student student);
    void deleteStudent(int id);
}
