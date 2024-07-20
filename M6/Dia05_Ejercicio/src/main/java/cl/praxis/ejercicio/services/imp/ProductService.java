package cl.praxis.ejercicio.services.imp;

import cl.praxis.ejercicio.entities.Product;
import cl.praxis.ejercicio.repositories.IProductRepository;
import cl.praxis.ejercicio.services.IBaseCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IBaseCRUD<Product> {
    @Autowired
    private IProductRepository repo;

    @Override
    public List<Product> getAll() {
        return repo.findAll();
    }

    @Override
    public Product getById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Product add(Product entity) {
        return repo.save(entity);
    }

    @Override
    public Product update(int id, Product entity) {
        if (repo.existsById(id)) {
            entity.setId(id);
            return repo.save(entity);
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
