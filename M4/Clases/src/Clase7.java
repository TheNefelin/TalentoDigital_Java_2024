import java.util.Scanner;

public class Clase7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int numero = 0;
//
//        System.out.println("Ingrese un numero entre 1 y 10");
//
//        do {
//            if (sc.hasNextInt()) {
//                numero = sc.nextInt();
//
//                while (!(numero >= 1 && numero <= 10)) {
//                    System.out.println("Ingrese un numero entre 1 y 10");
//                    Sc
//                }
//
//            } else {
//                sc.next();
//            }
//        }while (numero == 0);

//        for (int i = 0; i <= 10; i++) {
//            System.out.println(i);
//        }

        System.out.println("----------------------------------");

        int i;
        int total;
        int cant;

        i = 0;
        total = 0;
        for (i = 1; i <= 10; i++) {
            total += i;
            System.out.println(i + " - " + total);
        }

        System.out.println("----------------------------------");

        i = 1;
        total = 0;
        cant = 10;
        while (i <= cant) {
            total += i;

            System.out.println(i + " - " + total);
            i++;
        }

        System.out.println("----------------------------------");

        i = 1;
        total = 0;
        cant = 20;
        while (i <= cant) {
            if(i%2 == 0) {
                total += i;
                System.out.println(i + " - " + total);
            }
            i++;
        }

        System.out.println("----------------------------------");
    }
}