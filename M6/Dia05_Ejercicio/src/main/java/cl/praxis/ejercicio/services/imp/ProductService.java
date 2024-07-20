package cl.praxis.ejercicio.services.imp;

import cl.praxis.ejercicio.entities.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final static Logger LOG = LoggerFactory.getLogger(ProductService.class);
    List<Product> products;

    public ProductService() {
        products = List.of(
                new Product(1, "Manzana", 100, 50),
                new Product(2, "Leche", 150, 30),
                new Product(3, "Pan", 50, 100),
                new Product(4, "Arroz", 80, 60),
                new Product(5, "Café", 200, 40),
                new Product(6, "Azúcar", 70, 80),
                new Product(7, "Jugo de Naranja", 120, 20)
        );
    }

    public List<Product> getAll() {
        return products;
    }

    public Product getById(int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }
}
