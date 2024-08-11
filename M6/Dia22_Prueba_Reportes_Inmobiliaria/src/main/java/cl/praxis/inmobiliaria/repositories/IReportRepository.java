package cl.praxis.inmobiliaria.repositories;

import cl.praxis.inmobiliaria.entities.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReportRepository extends JpaRepository<ReportEntity, Long> {
}
