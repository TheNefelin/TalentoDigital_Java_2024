package cl.praxis.ejercicio.services.imp;

import cl.praxis.ejercicio.entities.Product;
import cl.praxis.ejercicio.repositories.IProductRepository;
import cl.praxis.ejercicio.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Product getProductById(int id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return iProductRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return iProductRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return iProductRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        iProductRepository.delete(product);
    }
}
