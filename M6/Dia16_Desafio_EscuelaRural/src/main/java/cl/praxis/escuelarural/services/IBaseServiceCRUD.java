package cl.praxis.escuelarural.services;

import java.util.List;

public interface IBaseServiceCRUD<T> {
    List<T> getAll();
    T getById(Long id);
    T create(T t);
    T update(T t);
    boolean delete(Long id);
}
