import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cant = 0;
        int n0 = 0;
        int n1 = 1;
        int suma;

        do {
            System.out.println("Ingrese un numero mayor a 0");

            if (sc.hasNextInt()) {
                cant = sc.nextInt();
            } else {
                System.out.println("Numero invalido");
                sc.next();
            }
        } while (cant <= 0);

        System.out.println("-------------------------------");

        for(int i = 0; i < cant; i++){
            System.out.println(n0);
            suma = n0 + n1;
            n0 = n1;
            n1 = suma;
        }
    }
}
