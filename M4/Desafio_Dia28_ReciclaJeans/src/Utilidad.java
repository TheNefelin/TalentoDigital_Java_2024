import java.util.Scanner;

public class Utilidad {
    public static final String FONT_RED = "\u001B[31m";
    public static final String FONT_GREEN = "\u001B[32m";
    public static final String FONT_YELLOW = "\u001B[33m";
    public static final String FONT_PURPLE = "\u001B[35m";

    public static void limpiarPantalla() {
        System.out.flush();
    }

    public static void tiempoEspera(long seg) {
        try {
            Thread.sleep(seg * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static int inputInt(String msge) {
        Scanner sc = new Scanner(System.in);
        int num = 0;

        do{
            System.out.println(Utilidad.FONT_GREEN +msge);
            if (sc.hasNextInt()) {
                num = sc.nextInt();
            } else {
                System.out.println(Utilidad.FONT_RED + "Ingrese un Valor Valido (int)");
                sc.nextLine();
            }
        } while (num == 0);

        return num;
    }

    public static String inputStr(String msge) {
        Scanner sc = new Scanner(System.in);
        String str = "";

        do{
            System.out.println(Utilidad.FONT_GREEN + msge);
            if (sc.hasNextInt()) {
                System.out.println(Utilidad.FONT_RED + "Ingrese un Valor Valido (str)");
                sc.nextLine();
            } else {
                str = sc.nextLine();
            }
        } while (str.isEmpty());

        return str;
    }
}
