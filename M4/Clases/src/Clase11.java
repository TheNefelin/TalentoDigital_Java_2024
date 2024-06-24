import java.util.Scanner;

public class Clase11 {
    public static void main(String[] args) {
        Calculadora();
    }

    private static void Calculadora() {
        float numero = 0f;
        float resultado = 0;
        String ingreso = null;
        int ascii = 0;

        int contador = 0;
        Scanner sc = new Scanner(System.in);

        do{
            if((contador % 2) == 0) {
                System.out.println("Ingrese un número: ");
            }else {
                System.out.println("Ingrese un operador (+, -, =): ");
                contador++;
            }

            ingreso = sc.next();
            ascii = (int) ingreso.charAt(0);

            if(contador == 0 && ascii != 43 && ascii != 45 && ascii != 61) {
                numero = Float.parseFloat(ingreso);
                resultado = numero;
                contador++;
            }else {
                if(ascii == 43) {
                    System.out.println("Ingrese un número: ");
                    ingreso = sc.next();
                    numero = Float.parseFloat(ingreso);
                    resultado = resultado + numero;
                    contador++;
                }

                if(ascii == 45) {
                    System.out.println("Ingrese un número: ");
                    ingreso = sc.next();
                    numero = Float.parseFloat(ingreso);
                    resultado = resultado - numero;
                    contador++;
                }
            }
        } while((int)ingreso.charAt(0) != 61);

        System.out.printf("El Resultado es: %f", resultado);
    }
}
