package cl.praxis.persona.services;

import cl.praxis.persona.entities.Person;
import cl.praxis.persona.repositories.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private IPersonRepository iPersonRepository;

    public List<Person> findAll() {
        return iPersonRepository.findAll();
    }

    public Person findById(int id) {
        return iPersonRepository.findById(id).get();
    }
}
