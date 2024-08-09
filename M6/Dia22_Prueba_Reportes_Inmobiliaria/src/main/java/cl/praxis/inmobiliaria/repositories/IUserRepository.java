package cl.praxis.inmobiliaria.repositories;

import cl.praxis.inmobiliaria.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
}
