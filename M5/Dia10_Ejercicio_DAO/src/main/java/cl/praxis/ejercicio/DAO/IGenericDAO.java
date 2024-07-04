package cl.praxis.ejercicio.DAO;

import cl.praxis.ejercicio.models.UserDTO;

import java.util.List;

public interface IGenericDAO<T> {
    public List<UserDTO> getAll();
    public UserDTO getById(int id);
    public UserDTO insert(T obj);
    public UserDTO update(T obj);
    public boolean delete(int id);
}
