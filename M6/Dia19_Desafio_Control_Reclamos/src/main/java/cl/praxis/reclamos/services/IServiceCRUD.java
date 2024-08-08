package cl.praxis.reclamos.services;

import cl.praxis.reclamos.entities.User;

import java.util.List;

public interface IServiceCRUD<T> {
    List<User> getAll();
    User getById(Long id);
    User create(User user);
    User update(User user);
    void delete(Long id);
}
