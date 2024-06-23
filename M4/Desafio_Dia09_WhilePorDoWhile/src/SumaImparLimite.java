import java.util.Scanner;

public class SumaImparLimite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = 0;
        int n2 = 0;
        int suma = 0;

        do {
            System.out.println("Ingrese numero Min");

            if (sc.hasNextInt()) {
                n1 = sc.nextInt();
            } else {
                System.out.println("Numero invalido");
                sc.next();
            }
        } while (n1 <= 0);

        do {
            System.out.println("Ingrese numero Max");

            if (sc.hasNextInt()) {
                n2 = sc.nextInt();
                if (n1 > n2) {
                    System.out.println("Numero Max NO Puede ser Menor que Numero Min");
                    n2 = 0;
                }
            } else {
                System.out.println("Numero invalido");
                sc.next();
            }
        } while (n2 <= 0);

        System.out.println("-----------------------------");

        for (int i = n1; i <= n2; i++)
            if (i % 2 != 0)
                suma = suma + i;

        System.out.println(suma);
    }
}
