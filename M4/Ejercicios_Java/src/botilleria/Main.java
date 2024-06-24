package botilleria;

public class Main {
    public static void main(String[] args) {
        Cerveza cerveza = new Cerveza("Chica", "Charcha", 1500);
        Botilleria botilleria = new Botilleria(cerveza, "La tia Carlota");

        System.out.println("-------------------------------");
        System.out.println(botilleria);
        System.out.println("-------------------------------");
    }
}
