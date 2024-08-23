package cl.praxis.restaurant.services;

import java.util.List;

public interface IServiceCRUD<T> {
    List<T> getAll();
    T getById(int id);
    T create(T t);
    T update(T t);
    void delete(int id);
}
