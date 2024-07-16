package cl.praxis.persona;

import cl.praxis.persona.entities.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        Person person = new Person(0, "Isaac", "Netero", 666);
        System.out.println(person.toString());
    }

}
