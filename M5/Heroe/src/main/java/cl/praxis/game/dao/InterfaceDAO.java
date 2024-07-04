package cl.praxis.game.dao;

import java.util.List;

public interface InterfaceDAO<T> {
    T getById(int id);
    List<T> getAll();
    void insert(T obj);
    void update(T obj);
    void delete(int id);
}
