package cl.praxis.ejercicio.services.imp;

import cl.praxis.ejercicio.entities.Car;
import cl.praxis.ejercicio.repositories.ICarRepository;
import cl.praxis.ejercicio.services.IBaseServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements IBaseServiceCRUD<Car> {
    @Autowired
    private ICarRepository repository;

    @Override
    public List<Car> getAll() {
        return repository.findAll();
    }

    @Override
    public Car getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Car create(Car car) {
        return repository.save(car);
    }

    @Override
    public Car update(Car car) {
        return repository.save(car);
    }

    @Override
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
