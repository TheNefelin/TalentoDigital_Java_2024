package cl.praxis.heroes.services.imp;

import cl.praxis.heroes.daos.imp.GenderDAO;
import cl.praxis.heroes.models.GenderDTO;
import cl.praxis.heroes.services.IGenderService;

import java.util.List;

public class GenderService implements IGenderService {
    GenderDAO genderDAO = new GenderDAO();

    @Override
    public List<GenderDTO> getAllGender() {
        return genderDAO.getAllRol();
    }
}
