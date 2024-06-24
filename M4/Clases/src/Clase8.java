import java.util.Scanner;

public class Clase8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i;
        int suma;
        int num = 0;
        boolean estado;

        System.out.println("-- Ingrese un Numero --------- ");

        do {
            if (sc.hasNextInt()){
                num = sc.nextInt();
                estado = false;
            } else {
                estado = true;
            }
        } while (estado);

        System.out.println("-- Desde el 5 ---------------- ");
        suma = 0;
        for (i=5; i<=num; i++) {
            suma += i;
            System.out.println(i + " - " + suma);
        }

        System.out.println("-- Numeros Pares ------------- ");
        suma = 0;
        for (i=1; i<=num; i++) {
            suma += i * 2;
            System.out.println(i + " - " + suma);
        }

        System.out.println("-- Todos los Numeros --------- ");
        suma = 1;
        for (i=1; i<=num; i++) {
            suma *= i;
            System.out.println(i + " - " + suma);
        }
    }
}
