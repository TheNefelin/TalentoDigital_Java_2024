import java.util.Scanner;

public class SoloPares2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;

        do {
            System.out.println("Ingrese un numero");

            if (sc.hasNextInt()) {
                n = sc.nextInt();
            } else {
                System.out.println("Numero invalido");
                sc.next();
            }
        } while (n <= 0);

        System.out.println("-----------------------------");

        for (int i = 1; i <= n; i++)
            System.out.println(i * 2);
    }
}
