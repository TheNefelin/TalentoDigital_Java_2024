package cl.praxis.inmobiliaria.controllers;

import cl.praxis.inmobiliaria.entities.ReportEntity;
import cl.praxis.inmobiliaria.services.imp.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportRestController {
    @Autowired
    private ReportService reportService;

    @GetMapping
    private List<ReportEntity> getAllReports() {
        return reportService.findAll();
    }

    @GetMapping("/{id}")
    private ReportEntity getReportById(@PathVariable Long id) {
        return reportService.findById(id);
    }

    @PostMapping
    private ReportEntity createReport(@RequestBody ReportEntity report) {
        return reportService.create(report);
    }

    @PutMapping
    private ReportEntity updateReport(@RequestBody ReportEntity report) {
        return reportService.update(report);
    }

    @DeleteMapping
    private void deleteReport(@PathVariable Long id) {
        reportService.delete(id);
    }
}
