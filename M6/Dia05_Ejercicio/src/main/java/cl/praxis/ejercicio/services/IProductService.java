package cl.praxis.ejercicio.services;

import cl.praxis.ejercicio.entities.Product;

import java.util.List;

public interface IProductService {
    Product getProductById(int id);
    List<Product> getAllProducts();
    Product addProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(Product product);
}
