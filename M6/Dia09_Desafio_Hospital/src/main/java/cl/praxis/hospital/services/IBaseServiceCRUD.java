package cl.praxis.hospital.services;

import java.util.List;

public interface IBaseServiceCRUD<T> {
    List<T> findAll();
}
