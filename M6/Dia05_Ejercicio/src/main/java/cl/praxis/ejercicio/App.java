package cl.praxis.ejercicio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {
    private final static Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        LOG.info("Primer Hola Mundo");
        LOG.error("Mensaje de Error");
        LOG.warn("Mensaje de Advertencia");
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Se Inicio el Software");
    }
}
