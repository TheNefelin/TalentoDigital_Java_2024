package cl.praxis.ejercicio.services;

import java.util.List;

public interface IBaseServiceCRUD<T> {
    List<T> findAll();
    T findById(int id);
    T create(T t);
    T update(T t);
    boolean delete(int id);
}
