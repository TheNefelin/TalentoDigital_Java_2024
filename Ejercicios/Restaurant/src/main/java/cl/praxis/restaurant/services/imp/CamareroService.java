package cl.praxis.restaurant.services.imp;

import cl.praxis.restaurant.entities.Camarero;
import cl.praxis.restaurant.repository.ICamareroRepository;
import cl.praxis.restaurant.services.ICamareroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CamareroService implements ICamareroService {
    @Autowired
    ICamareroRepository camareroRepository;

    @Override
    public List<Camarero> getAll() {
        return camareroRepository.findAll();
    }

    @Override
    public List<Camarero> getAllByDateAndText(String date, String text) {
        return camareroRepository.findAll()
                .stream()
                .filter(e ->
                        (
                            String.valueOf(e.getFechaInicio()).contains(date) || date.equals("0000-00-00")
                        ) && (
                            String.valueOf(e.getId()).contains(text) ||
                            e.getNombre().toLowerCase().contains(text.toLowerCase()) ||
                            String.valueOf(e.getEdad()).contains(text) ||
                            String.valueOf(e.getFechaInicio()).contains(text)
                        )
                )
                .toList();
    }

    @Override
    public List<LocalDate> getAllDates() {
        return camareroRepository.findAllDates();
    }

}
