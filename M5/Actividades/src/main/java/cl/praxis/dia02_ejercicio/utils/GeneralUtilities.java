package cl.praxis.dia02_ejercicio.utils;

import java.time.LocalDateTime;

public class GeneralUtilities {
    public GeneralUtilities() {}

    public String getDate() {
        LocalDateTime date = LocalDateTime.now();
        return date.toString();
    }
}
