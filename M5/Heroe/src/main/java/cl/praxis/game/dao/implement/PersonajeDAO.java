package cl.praxis.game.dao.implement;

import cl.praxis.game.classes.Genero;
import cl.praxis.game.dao.InterfaceDAO;
import cl.praxis.game.models.Personaje;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonajeDAO implements InterfaceDAO<Personaje> {
    private Connection connection;

    public PersonajeDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Personaje> getAll() {
        List<Personaje> personajes = new ArrayList<>();
        String query = "SELECT * FROM personajes";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Personaje personaje = new Personaje();

                personaje.setId(resultSet.getInt("id"));
                personaje.setNombre(resultSet.getString("nombre"));
                personaje.setGenero(Genero.valueOf(resultSet.getString("genero")));
                personaje.setFuerza(resultSet.getInt("fuerza"));
                personaje.setVida(resultSet.getInt("vida"));
                personaje.setDefensa(resultSet.getInt("defensa"));

                personajes.add(personaje);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personajes;
    }

    @Override
    public Personaje getById(int id) {
        Personaje personaje = null;
        String query = "SELECT * FROM personajes WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                personaje = new Personaje();

                personaje.setId(resultSet.getInt("id"));
                personaje.setNombre(resultSet.getString("nombre"));
                personaje.setGenero(Genero.valueOf(resultSet.getString("genero")));
                personaje.setFuerza(resultSet.getInt("fuerza"));
                personaje.setVida(resultSet.getInt("vida"));
                personaje.setDefensa(resultSet.getInt("defensa"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personaje;
    }

    @Override
    public void insert(Personaje personaje) {
        String query = "INSERT INTO personajes (nombre, genero, fuerza, defensa, vida) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, personaje.getNombre());
            statement.setString(2, personaje.getGenero().toString());
            statement.setInt(3, personaje.getFuerza());
            statement.setInt(4, personaje.getDefensa());
            statement.setInt(5, personaje.getVida());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Personaje personaje) {
        String query = "UPDATE personajes nombre = ?, genero = ?, fuerza = ?, defensa = ?, vida = ? WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, personaje.getNombre());
            statement.setString(2, personaje.getGenero().toString());
            statement.setInt(3, personaje.getFuerza());
            statement.setInt(4, personaje.getDefensa());
            statement.setInt(5, personaje.getVida());
            statement.setInt(6, personaje.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM heroes WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
