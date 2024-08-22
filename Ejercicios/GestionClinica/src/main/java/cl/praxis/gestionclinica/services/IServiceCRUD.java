package cl.praxis.gestionclinica.services;

import java.util.List;

public interface IServiceCRUD<T> {
    List<T> findAll();
    T findById(int id);
    T create(T t);
    T update(T t);
    void delete(int id);
}
