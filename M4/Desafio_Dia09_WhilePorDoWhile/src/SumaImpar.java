import java.util.Scanner;

public class SumaImpar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = -1;
        int suma = 0;

        do {
            System.out.println("Ingrese un numero");

            if (sc.hasNextInt()) {
                n = sc.nextInt();
            } else {
                System.out.println("Numero invalido");
                sc.next();
            }
        } while (n < 0);

        System.out.println("-----------------------------");

        for (int i = 0; i <= n; i++)
            if (i % 2 != 0)
                suma = suma + i;

        System.out.println(suma);
    }
}
