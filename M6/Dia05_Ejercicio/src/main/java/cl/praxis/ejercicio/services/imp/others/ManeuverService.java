package cl.praxis.ejercicio.services.imp.others;

import cl.praxis.ejercicio.entities.others.Maneuver;

import java.util.ArrayList;
import java.util.List;

public class ManeuverService {
    List<Maneuver> maneuvers = new ArrayList<>();

    public ManeuverService() {
        maneuvers.add(new Maneuver(1, "Extinción de incendios"));
        maneuvers.add(new Maneuver(2, "Rescate en estructuras colapsadas"));
        maneuvers.add(new Maneuver(3, "Rescate en altura"));
        maneuvers.add(new Maneuver(4, "Rescate acuático"));
        maneuvers.add(new Maneuver(5, "Rescate vehicular"));
        maneuvers.add(new Maneuver(6, "Control de materiales peligrosos (HAZMAT)"));
        maneuvers.add(new Maneuver(7, "Primera respuesta médica"));
    }

    public List<Maneuver> getAll() {
        return maneuvers;
    }
}
