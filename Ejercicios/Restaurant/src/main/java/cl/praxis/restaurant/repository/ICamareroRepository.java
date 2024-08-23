package cl.praxis.restaurant.repository;

import cl.praxis.restaurant.entities.Camarero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ICamareroRepository extends JpaRepository<Camarero, Integer> {
    @Query("SELECT DISTINCT c.fechaInicio FROM Camarero c ORDER BY c.fechaInicio DESC")
    List<LocalDate> findAllDates();
}
