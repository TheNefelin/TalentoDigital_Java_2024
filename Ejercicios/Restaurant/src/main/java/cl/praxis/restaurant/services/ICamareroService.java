package cl.praxis.restaurant.services;

import cl.praxis.restaurant.entities.Camarero;

import java.time.LocalDate;
import java.util.List;

public interface ICamareroService {
    List<Camarero> getAll();
    List<Camarero> getAllByDateAndText(String date, String text);
    List<LocalDate> getAllDates();
}
