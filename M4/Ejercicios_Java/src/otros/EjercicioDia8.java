package otros;


import java.util.Scanner;

public class EjercicioDia8 {
    public static void main(String[] args) {
        Menu();
    }

    private static void Menu(){
        Scanner sc = new Scanner(System.in);
        boolean estado;
        int numero1 = 0;
        int numero2 = 0;
        String opcion = "";

        System.out.println("--------------------------------------------------");
        System.out.println(" Operaciones Matimaticas");
        System.out.println("--------------------------------------------------");

        do {
            System.out.println("Ingrese el Primer Numero");
            if (sc.hasNextInt()) {
                numero1 = sc.nextInt();
                sc.nextLine();
                estado = false;
            }else {
                System.out.println("Error: Ingrese un Numero Valido");
                estado = true;
            }
        } while (estado);

        do {
            System.out.println("Ingrese el Segundo Numero");
            if (sc.hasNextInt()) {
                numero2 = sc.nextInt();
                sc.nextLine();
                estado = false;
            }else {
                System.out.println("Error: Ingrese un Numero Valido");
                estado = true;
            }
        } while (estado);

        System.out.println("-- Elige Operacion ---------- \n a. Sumar. \n b. Restar. \n c. Multiplicar. \n d. Dividir. \n e. Salir.");
        System.out.println("----------------------------- \n " + numero1 + " Operacion " + numero2);

        do {
            System.out.println("Ingrese una operacion");
            opcion = sc.nextLine();
            if (opcion.length() == 1 && (opcion.equals("a") || opcion.equals("b") || opcion.equals("c") || opcion.equals("d") || opcion.equals("e"))) {
                estado = false;
            }else {
                System.out.println("Error: Ingrese una Opcion Valido");
                estado = true;
            }
        } while (estado);

        System.out.println("-----------------------------");

        switch (opcion) {
            case "a" -> System.out.printf("La Suma entre %d y %d es: " + (numero1 + numero2), numero1, numero2);
            case "b" -> System.out.printf("La Resta entre %d y %d es: " + (numero1 - numero2), numero1, numero2);
            case "c" -> System.out.printf("La Multiplicacion entre %d y %d es: " + (numero1 * numero2), numero1, numero2);
            case "d" -> {
                if (numero2 == 0) {
                    System.out.println("Esta Operacion No Esta Permitida...");
                } else {
                    System.out.printf("La Division entre %d y %d es: " + (numero1 / numero2), numero1, numero2);
                }
            }
            case "e" -> System.out.println("Saliendo...");
        }

        System.out.println("\n-----------------------------");
    }
}