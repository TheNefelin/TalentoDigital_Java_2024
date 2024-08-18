package cl.praxis.tiendadiscos.services;

import java.util.List;

public interface IServiceCRUD<T> {
    List<T> findAll();
}
