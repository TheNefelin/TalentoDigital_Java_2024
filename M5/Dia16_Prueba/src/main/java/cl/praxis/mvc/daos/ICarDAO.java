package cl.praxis.mvc.daos;

import cl.praxis.mvc.models.CarDTO;

import java.util.List;

public interface ICarDAO {
    public List<CarDTO> getAll();
}
