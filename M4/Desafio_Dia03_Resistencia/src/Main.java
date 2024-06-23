import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int cantResistencia = 0;
        float rn = 0f;
        float rt = 0f;
        //DecimalFormat df = new DecimalFormat("#.0");
        Scanner sc = new Scanner(System.in);

        System.out.println("-----------------------------------------------");
        System.out.println("Calcula la Resistencia de un Circuito Paralelo");
        System.out.println("-----------------------------------------------");

        do {
            System.out.println("Cuantas resistencias quieres calcular?  n > 0");
            if (sc.hasNextInt()) {
                cantResistencia = sc.nextInt();
            } else {
                sc.next();
            }
        } while (cantResistencia <= 0);

        System.out.println("-----------------------------------------------");

        for (int i = 1; i <= cantResistencia; i++) {
            do {
                System.out.print("Ingrese Resistencia R" + i + ": ");
                if (sc.hasNextFloat()) {
                    rn = sc.nextFloat();
                    rt += 1/rn;
                } else {
                    rn = 0;
                    sc.next();
                }
            } while (rn <= 0);
        }

        System.out.println("-----------------------------------------------");
        System.out.println("La resistencia total es de: " + 1/rt + " (Ω)Ohm");
        System.out.println("-----------------------------------------------");

        System.out.println("Quieres hacer otro calculo? \n SI = Ingrese un numero. \n NO = Ingrese una letra.");
        if (sc.hasNextInt()) {
            menu();
        } else {
            sc.next();
            sc.close();
        }
    }
}