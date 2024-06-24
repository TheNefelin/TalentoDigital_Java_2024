package otros;

public class Main {
    //Esto es un comentario en línea

    /*
    Esto me permite
    comentarios en
    más de una línea. */
    public static void main(String[] args) {

        //tipos de datos primitivos
        int numero1 = 6;
        int numero2 = 2;
        int numero3 = 3;
        char caracter;
        boolean booleano;
        float decimal1 = 1.7f;
        double decimal2;
        long numeroLargo1 = 98723648;
        int suma;
        //final se utiliza para declarar constantes
        final int DIAS_DE_LA_SEMANA = 7;
        //tipos de datos que vienen Clases
        String texto = "Hola Mundo";
        String vacio = ""; //String vacío
        Double decimalLargo;
        Integer numeroEntero2 = 5;
        String texto2 = new String("¡Hola Mundo 2 !"); //Crea una referencia a un objeto
        String nulo = null; // objeto nulo
        nulo = new String(); // inicializacion del objeto nulo
        System.out.println(texto+'!');
        System.out.println(texto2);

        //<operadores
        suma = numero1 + numero2;
        System.out.println(suma);
        System.out.println((numero1+numero3)/decimal1);
        System.out.println(17.8);
        System.out.println(9/1.5f);
        System.out.println(3+5);
        vacio = texto + texto2;
        System.out.println(vacio);
        System.out.println(vacio.substring(2, 13));
        numero3 = texto.length();
        System.out.println(numero3);
        System.out.println(vacio.startsWith("Hola"));
        System.out.println(vacio.indexOf('z'));
        //Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa un texto gil");
        //texto = sc.nextLine();
        System.out.println(texto);
        //Casting o casteo de datos
        numero2 = (int) decimal1;
        System.out.println(numero2);
        vacio = String.valueOf(numeroLargo1);
        System.out.println(vacio);
        //Parseo
        numero2 = Integer.parseInt(vacio);
        System.out.println(numero2);

        int edad = 18;

        if (edad < 18) {
            System.out.println("Es menor de edad");
        } else if (edad > 18) {
            System.out.println("Es menor de edad");
        } else {
            System.out.println("No es ni mayor ni menor");
        }

        String txt1 = "Hola";
        String txt2 = "Hola";

        if (txt1.equals(txt2)) {
            System.out.println("Textos Iguales");
        }

        if (txt1.equalsIgnoreCase(txt2)) {
            System.out.println("Textos Iguales");
        }

        txt1 = "Hola";
        txt2 = "Hola";

        if (txt1.compareTo(txt2) == 0) {
            System.out.println("Textos Iguales");
        } else if (txt1.compareTo(txt2) > 0){
            System.out.println("Valor Positivo");
        } else if (txt1.compareTo(txt2) < 0){
            System.out.println("Valor Negativo");
        }
    }
}