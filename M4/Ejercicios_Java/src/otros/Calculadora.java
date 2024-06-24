package otros;


import java.util.Scanner;

public class Calculadora {
    private Scanner sc = new Scanner(System.in);
    private float total = 0;
    private int contador;
    private int asciiOperador = -1;
    private float numero = 0;

    public void Iniciar() {
        this.contador = 0;
        boolean continuar = true;

        do {
            if (contador % 2 == 0) {
                System.out.println(Colores.FONT_PURPLE + "Ingrese un Numero: ");
                if (this.sc.hasNextFloat()) {
                    this.numero = this.sc.nextFloat();
                    this.contador++;
                    Calcular();
                } else {
                    System.out.println(Colores.FONT_RED + "Numero Invalido");
                    sc.next();
                }
            } else {
                System.out.println(Colores.FONT_PURPLE + "Ingrese un Operador (+, -, =)");
                this.asciiOperador = (int) this.sc.next().charAt(0);
                if (this.asciiOperador == 43 || this.asciiOperador == 45)
                    this.contador++;
                else if (this.asciiOperador == 61)
                    continuar = false;
                else
                    System.out.println(Colores.FONT_RED + "Operador Invalido");
            }
        } while (continuar);

        System.out.printf(Colores.FONT_YELLOW + "El Resultado es: %f", total);
    }

    private void Calcular() {
        if (asciiOperador == 43 || asciiOperador == -1)
            this.total = this.total + this.numero;

        if (asciiOperador == 45)
            this.total = this.total - this.numero;
    }
}