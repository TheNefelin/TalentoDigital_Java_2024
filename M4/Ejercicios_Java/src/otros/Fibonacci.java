package otros;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cant;
        int actual = 1;
        int anterior = 0;
        int suma;
        cant = sc.nextInt();

        System.out.println("-------------------------------");

        for(int i = 1; i <= cant; i++){
            System.out.println(anterior);
            suma = anterior + actual;
            anterior = actual;
            actual = suma;
        }
    }
}
