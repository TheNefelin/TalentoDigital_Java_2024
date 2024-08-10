package cl.praxis.reclamos.services;

import cl.praxis.reclamos.entities.UserEntitiy;

import java.util.List;

public interface IServiceCRUD<T> {
    List<UserEntitiy> getAll();
    UserEntitiy getById(Long id);
    UserEntitiy create(UserEntitiy user);
    UserEntitiy update(UserEntitiy user);
    void delete(Long id);
}
