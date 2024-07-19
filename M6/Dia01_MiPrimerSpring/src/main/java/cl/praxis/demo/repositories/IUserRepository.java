package cl.praxis.demo.repositories;

import cl.praxis.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
