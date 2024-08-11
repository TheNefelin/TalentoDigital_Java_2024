package cl.praxis.inmobiliaria.services.imp;

import cl.praxis.inmobiliaria.entities.ReportEntity;
import cl.praxis.inmobiliaria.repositories.IReportRepository;
import cl.praxis.inmobiliaria.services.IServiceCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService implements IServiceCRUD<ReportEntity> {
    @Autowired
    private IReportRepository reportRepository;

    @Override
    public List<ReportEntity> findAll() {
        return reportRepository.findAll();
    }

    @Override
    public ReportEntity findById(Long id) {
        return reportRepository.findById(id).orElse(null);
    }

    @Override
    public ReportEntity create(ReportEntity reportEntity) {
        return reportRepository.save(reportEntity);
    }

    @Override
    public ReportEntity update(ReportEntity reportEntity) {
        return reportRepository.save(reportEntity);
    }

    @Override
    public void delete(Long id) {
        reportRepository.deleteById(id);
    }
}
