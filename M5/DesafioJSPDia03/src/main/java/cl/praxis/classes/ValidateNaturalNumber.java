package cl.praxis.classes;

public class ValidateNaturalNumber {
    private boolean status;
    private String message;
    private int natularNumber = 0;

    public ValidateNaturalNumber(String numberStr) {
        status = false;
        message = "";

        try {
            natularNumber = Integer.parseInt(numberStr);

            if (natularNumber < 0)
                message = "Error: El número no puede ser negativo";
            else
                status = true;
        } catch (NumberFormatException e) {
            message = "Error: El parámetro 'number' debe ser un numerico";
        }
    }

    public boolean isValid() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public int getNatularNumber() {
        return natularNumber;
    }
}
