package cl.praxis.mvc.daos;

import cl.praxis.mvc.models.RolDTO;

import java.util.List;

public interface IRolDAO {
    public List<RolDTO> getAll();
}
