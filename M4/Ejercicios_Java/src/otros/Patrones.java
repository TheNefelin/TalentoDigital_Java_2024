package otros;


import java.util.Scanner;

public class Patrones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean estado;
        int numero = 0;

        do {
            System.out.println("Ingrese un numero para dibujar");
            if (sc.hasNextInt()) {
                numero = sc.nextInt();
                estado = false;
            }else {
                estado = true;
                sc.next();
            }
        } while (estado);


        Cuadrado(numero);
        System.out.println("\n");
        Estrella(numero);
        System.out.println("\n");
        Bandera(numero);
        System.out.println("\n");
        Grafico(numero);
        System.out.println("\n");
        Abuela(numero);
    }

    public static void Cuadrado(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n*3; j++) {
                if (((j == ((n*3)/2) + i) || j == ((n*3)/2) - i) || i == n/3 || i == (j/4) + (n/3)) //i == j/3
                    System.out.print("\u001B[31m" + "*"); //blanco
                else
                    System.out.print("\u001B[34m" + "*"); //azul
            }
            System.out.print("\n");
        }
    }

    public static void Estrella(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n*2; j++) {
                if (j == n + i || j == n - i -1 || i == n/3 || i == (j/3) + (n/3) || i == n - (j/3) - (n/3) +1)
                    System.out.print("\u001B[31m" + "*"); //blanco
                else
                    System.out.print("\u001B[34m" + "*"); //azul
            }
            System.out.print("\n");
        }
    }

    public static void Bandera(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n*4; j++) {
                if (i >= n/2) {
                    System.out.print("\u001B[31m" + "*"); // rojo
                } else {
                    if ((j <= (n*5)/3) ) {
                        System.out.print("\u001B[34m" + "*"); //azul
                    } else {
                        System.out.print("\u001B[37m" + "*"); //blanco
                    }
                }
            }
            System.out.print("\n");
        }
    }

    public static void Grafico(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n*5; j++) {
                if (j == i*i)
                    System.out.print("\u001B[31m" + "*" + "\u001B[0m");
                else
                    System.out.print("\u001B[32m" + "*" + "\u001B[0m");
            }
            System.out.print("\n");
        }
    }

    public static void Abuela(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n*3; j++) {
                if (i % 2 == 0)
                    if (j == j-i) {
                        System.out.print("\u001B[33m" + "-" + "\u001B[0m");
                    } else if (j == i || j*3 == i || j == n-j+i) {
                        System.out.print("\u001B[33m" + "|" + "\u001B[0m");
                    } else {
                        System.out.print("\u001B[32m"+"*"+"\u001B[0m");
                    }
                else
                    System.out.print("\u001B[31m"+"."+"\u001B[0m");
            }
            System.out.print("\n");
        }
    }
}
