package cl.praxis.ejercicio.services;

import cl.praxis.ejercicio.entities.Product;

import java.util.List;

public interface IBaseCRUD<T> {
    List<T> getAll();
    T getById(int id);
    T add(T entity);
    T update(int id, T entity);
    boolean delete(int id);
}
