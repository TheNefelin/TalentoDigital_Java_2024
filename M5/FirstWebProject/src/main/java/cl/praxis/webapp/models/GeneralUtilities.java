package cl.praxis.webapp.models;

import java.time.LocalDate;

public class GeneralUtilities {
    public GeneralUtilities() {}

    public String getDate() {
        LocalDate date = LocalDate.now();
        return date.toString();
    }
}
