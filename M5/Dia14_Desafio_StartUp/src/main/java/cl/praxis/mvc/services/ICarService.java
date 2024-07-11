package cl.praxis.mvc.services;

import cl.praxis.mvc.models.CarDTO;
import cl.praxis.mvc.utils.ServiceResponse;

import java.util.List;

public interface ICarService {
    public ServiceResponse<List<CarDTO>> getAllCars();
}
