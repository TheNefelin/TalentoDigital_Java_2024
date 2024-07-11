package cl.praxis.mvc.services.implement;

import cl.praxis.mvc.daos.implement.CarDAO;
import cl.praxis.mvc.models.CarDTO;
import cl.praxis.mvc.services.ICarService;
import cl.praxis.mvc.utils.ServiceResponse;

import java.util.List;

public class CarService implements ICarService {
    private CarDAO carDAO;

    public CarService() {
        carDAO = new CarDAO();
    }

    @Override
    public ServiceResponse<List<CarDTO>> getAllCars() {
        ServiceResponse<List<CarDTO>> serviceResponse;
        serviceResponse = new ServiceResponse<>(false, "Lista de Autos", carDAO.getAll());

        return serviceResponse;
    }
}
