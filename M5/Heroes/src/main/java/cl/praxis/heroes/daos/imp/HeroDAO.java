package cl.praxis.heroes.daos.imp;

import cl.praxis.heroes.connections.MySqlConnection;
import cl.praxis.heroes.daos.IHeroDAO;
import cl.praxis.heroes.models.ClassDTO;
import cl.praxis.heroes.models.GenderDTO;
import cl.praxis.heroes.models.HeroDTO;
import cl.praxis.heroes.models.UserDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HeroDAO implements IHeroDAO {
    private Connection connection = MySqlConnection.getInstance().getConnection();

    @Override
    public List<HeroDTO> getAllHero() {
        List<HeroDTO> listHero = new ArrayList<>();

        String query =
            "SELECT " +
            "   a.id, " +
            "   a.nombre, " +
            "   b.id AS id_genero, " +
            "   b.nombre AS genero, " +
            "   c.id AS id_clase, " +
            "   c.nombre AS clase, " +
            "   d.id AS id_usuario, " +
            "   d.correo " +
            "FROM heroes a " +
            "   LEFT JOIN generos b ON a.id_genero = b.id " +
            "   LEFT JOIN clases c ON a.id_clase = c.id " +
            "   LEFT JOIN usuarios d ON d.id = a.id_usuario;";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                GenderDTO genderDTO = new GenderDTO();
                genderDTO.setId(rs.getInt("id_genero"));
                genderDTO.setName(rs.getString("genero"));

                ClassDTO classDTO = new ClassDTO();
                classDTO.setId(rs.getInt("id_clase"));
                classDTO.setName(rs.getString("clase"));

                UserDTO userDTO  = new UserDTO();
                userDTO.setId(rs.getInt("id_usuario"));
                userDTO.setEmail(rs.getString("correo"));

                HeroDTO hero = new HeroDTO();
                hero.setId(rs.getInt("id"));
                hero.setName(rs.getString("nombre"));
                hero.setGender(genderDTO);
                hero.setClase(classDTO);
                hero.setUser(userDTO);

                listHero.add(hero);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listHero;
    }

    @Override
    public boolean addHero(HeroDTO heroDTO) {
        String query = "INSERT INTO heroes (nombre, id_genero, id_clase, id_usuario) VALUES (?, ?, ?, ?);";

        try {
            PreparedStatement ps = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, heroDTO.getName());
            ps.setInt(2, heroDTO.getGender().getId());
            ps.setInt(3, heroDTO.getClase().getId());
            ps.setInt(4, heroDTO.getUser().getId());

            int rowAffected = ps.executeUpdate();

            if (rowAffected > 0) {
               return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }
}
