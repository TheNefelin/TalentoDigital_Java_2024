package cl.praxis.ejercicio;

import cl.praxis.ejercicio.entities.others.Product;
import cl.praxis.ejercicio.services.imp.others.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class App implements CommandLineRunner {
    private final static Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        //LOG.info("Mensaje de Informacion");
        //LOG.error("Mensaje de Error");
        //LOG.warn("Mensaje de Advertencia");
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Se Inicio el Software");

        superMarket();
        firefighter();
    }

    public void superMarket() {
        LOG.info("Inicio Sistema Supermercado");
        ProductService productService = new ProductService();

        LOG.info("Cotizar productos");
        for(Product product : productService.getAll()) {
            System.out.println(product);
        }

        LOG.warn("Elegir productos");
        List<Integer> idProd = List.of(1, 5, 10);
        for(Integer id : idProd) {
            System.out.println(productService.getById(id));
        }

        LOG.warn("Elegir cantidad de productos");
        List<Product> products = new ArrayList<>();
        for(Integer id : idProd) {
            Product product = productService.getById(id);
            if (product != null) {
                product.setQuantity(2);
                products.add(product);
            } else {
                products.add(null);
            }
            System.out.println(product);
        }

        LOG.warn("Comprar productos");
        for(Product product : products) {
            if (product != null) {
                LOG.info("exitoso”");
            } else {
                LOG.error("error");
            }
            System.out.println(product);
        }

        LOG.info("Fin del sistema");
    }

    private void firefighter() {
        LOG.info("Inicio Sistema Bomberos");
        LOG.info("Mensaje Alarma incendio");
        LOG.info("Hora del incendio");
        LOG.info("Lugar de ubicación de la emergencia");
        LOG.info("Llegada al lugar");
        LOG.warn("Realizar maniobras de primeros auxilios");
        Random random = new Random();
        boolean randomBoolean = random.nextBoolean();
        if (randomBoolean)
            LOG.info("se rescata personal");
        else
            LOG.error("No hay heridos");
        LOG.info("Apagar el incendio");
        LOG.info("Realizar informes");
        LOG.info("Fin del Sistema");
    }
}
