package cl.praxis.persona.config;

import cl.praxis.persona.entities.Person;
import cl.praxis.persona.repositories.IPersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final IPersonRepository iPersonRepository;

    public DataLoader(IPersonRepository iPersonRepository) {
        this.iPersonRepository = iPersonRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Person person = new Person(0, "Isaac", "Netero", 666);
        iPersonRepository.save(person);
    }
}