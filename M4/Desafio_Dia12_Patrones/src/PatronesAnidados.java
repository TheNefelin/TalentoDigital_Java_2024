import java.util.Scanner;

public class PatronesAnidados {
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

        System.out.println("\n" + "-- Patron 1 ---------------------------");
        Patron1(n);
        System.out.println("\n" + "-- Patron 2 ---------------------------");
        Patron2(n);
        System.out.println("\n" + "-- Patron 3 ---------------------------");
        Patron3(n);
        System.out.println("\n" + "-- Patron 4 ---------------------------");
        Patron4(n);
        System.out.println("\n" + "-- Repeticion Patron 4 ----------------");
        Patron5(n);

        sc.close();
    }

    private static void Patron1(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == n || i == 1 || j == 1 || j == n)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

    private static void Patron2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == n || i == 1 || i == n - j + 1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

    private static void Patron3(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j || i == n - j + 1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

    private static void Patron4(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if ((i == 1 && j < n) || (i == n && j > 1) || (i > 1 && j > 1 && j < n))
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

    private static void Patron5(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if ((i > 1 && j == 1) || (i < n && j == n))
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
