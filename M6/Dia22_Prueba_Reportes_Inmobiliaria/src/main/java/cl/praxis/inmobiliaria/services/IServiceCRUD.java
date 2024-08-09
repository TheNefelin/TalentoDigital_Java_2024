package cl.praxis.inmobiliaria.services;

import java.util.List;

public interface IServiceCRUD<T> {
    List<T> findAll();
    T findById(Long id);
    T create(T t);
    T update(T t);
    void delete(Long id);
}
