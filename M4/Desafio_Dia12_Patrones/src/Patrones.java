import java.util.Scanner;

public class Patrones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;

        do {
            System.out.println("Ingrese un numero mayor a 0");

            if (sc.hasNextInt()) {
                n = sc.nextInt();
            } else {
                System.out.println("Numero invalido");
                sc.next();
            }
        } while (n <= 0);

        System.out.println("-- Patron 1 ---------------------------");
        Patron1(n);
        System.out.println("\n" + "-- Patron 2 ---------------------------");
        Patron2(n);
        System.out.println("\n" + "-- Patron 3 ---------------------------");
        Patron3(n);
    }

    private static void Patron1(int n){
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                System.out.print("*");
            else
                System.out.print(".");
        }
    }

    private static void Patron2(int n){
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (sum == 4)
                sum = 1;
            else
                sum++;

            System.out.print(sum);
        }
    }

    private static void Patron3(int n){
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0)
                System.out.print("*");
            else
                System.out.print("|");
        }
    }
}