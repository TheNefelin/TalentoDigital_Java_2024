package cl.praxis.game.services;

import cl.praxis.game.connections.MySQLSingleton;
import cl.praxis.game.dao.implement.PersonajeDAO;
import cl.praxis.game.models.Personaje;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PersonajeService {
    private PersonajeDAO personajeDao;

    public PersonajeService() {
        try {
            Connection connection = MySQLSingleton.getInstance().getConnection();
            personajeDao = new PersonajeDAO(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Personaje> getAll() {
        return personajeDao.getAll();
    }

    public Personaje getById(int id) {
        return personajeDao.getById(id);
    }

    public void insert(Personaje personaje) {
        personajeDao.insert(personaje);
    }
}
