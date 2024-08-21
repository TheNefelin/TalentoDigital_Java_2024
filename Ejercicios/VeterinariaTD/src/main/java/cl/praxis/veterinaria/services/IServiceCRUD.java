package cl.praxis.veterinaria.services;

import java.util.List;

public interface IServiceCRUD<T> {
    List<T> getAll();
}
