package otros;

public class Ejercitar {
    public static void main(String[] args) {
        int numero = 5;

        sumarA(numero);

        int res = sumarB(numero);
        System.out.println("Resultado de la Funcion: " + res);

        OtraClase prueba = new OtraClase("");

        System.out.println(prueba.sumaCe(numero));
    }

    // Metodo tipo Procedimiento
    private static void sumarA(int num) {
        num = num * 2;
        System.out.println("Resultado del Procedimiento: " + num);
    }

    // Metodo tipo Funcion
    private static int sumarB(int num) {
        num = num * 2;

        return num;
    }
}
