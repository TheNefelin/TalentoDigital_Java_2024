package cl.praxis.hospital.services;

import java.util.List;

public interface IBaseServiceCRUD<T> {
    List<T> findAll();
    T findById(int id);
    T save(T t);
    boolean update(T t);
    boolean delete(int id);
}
