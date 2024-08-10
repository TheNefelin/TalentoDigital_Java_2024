package cl.praxis.reclamos.repositories;

import cl.praxis.reclamos.entities.UserEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserEntitiy, Long> {
   Optional<UserEntitiy> findByEmail(String email);
}
