package cl.praxis.university.services;

import java.util.List;

public interface IServiceCRUD<T> {
    List<T> findAll();
}
