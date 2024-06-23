import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String fecha1, fecha2;

        System.out.println("---------------------------------------------");
        System.out.println("Debe Ingresar 2 Fechas en formato DD/MM/YYYY");
        System.out.println("---------------------------------------------");

        System.out.println("Ingrese la fechas 1: ");
        fecha1 = EvaluarInput();

        System.out.println("Ingrese la fechas 2: ");
        fecha2 = EvaluarInput();

        System.out.println("Fecha1: " + fecha1 + " - Fecha2: " + fecha2);

        fecha1 = fecha1.substring(6, 10) + fecha1.substring(3, 5) + fecha1.substring(0, 2);
        fecha2 = fecha2.substring(6, 10) + fecha2.substring(3, 5) + fecha2.substring(0, 2);

        System.out.println("Se evalua: " + fecha1 + " - " + fecha2);

        int eval = fecha1.compareTo(fecha2);

        if (eval > 0) {
            System.out.println("La Segunda persona es Mayor");
        } else if (eval < 0) {
            System.out.println("La primera persona es Mayor");
        } else {
            System.out.println("Las Dos Persona Tiene la Misma Edad");
        }
    }

    private static String EvaluarInput(){
        Scanner sc = new Scanner(System.in);
        String str;
        boolean estado = false;

        do {
            str = sc.nextLine();

            if (IsFormat(str)) {
                if (IsNumeric(str)){
                    if (IsDate(str)) {
                        estado = true;
                    }
                }
            }

            if (!estado) {
                System.out.println("Ingrese una Fecha Valida");
            }
        }while (!estado);

        //sc.close();
        return str;
    }

    private static boolean IsDate(String str){
        int dia, mes, anio;

        dia = Integer.parseInt(str.substring(0, 2));
        mes = Integer.parseInt(str.substring(3, 5));
        anio = Integer.parseInt(str.substring(6, 10));

        if (dia > 0 && dia <= 31 && mes > 0 && mes <= 12 && anio > 1900 && anio <=2024) {
            return true;
        } else {
            System.out.println("El Dia o el Mes o el Año estan Fuera de Rango");
            return false;
        }
    }

    private static boolean IsFormat(String str){

        if (str.length() == 10 && str.indexOf("/") == 2 && str.substring(3, 10).indexOf("/") == 2 && str.chars().filter(e -> e == '/').count() == 2) {
            return true;
        }else {
            System.out.println("El Formato de la Fecha Debe Ser: DD/MM/YYYY");
            return false;
        }
    }

    private static boolean IsNumeric(String str){
        try {
            Integer.parseInt(str.substring(0, 2));
            Integer.parseInt(str.substring(3, 5));
            Integer.parseInt(str.substring(6, 10));
            return  true;
        } catch (Exception e) {
            //System.out.println(e.getMessage());
            System.out.println("La Fecha Solo debe tener Numeros y El Signo /");
            return false;
        }
    }
}