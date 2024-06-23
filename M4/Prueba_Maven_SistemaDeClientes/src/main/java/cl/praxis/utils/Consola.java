package cl.praxis.utils;

import java.util.Scanner;

public class Consola {

    public static int inputInt(String msge) {
        Scanner sc = new Scanner(System.in);
        int num = 0;

        do{
            System.out.println(Colores.FONT_GREEN + msge);
            if (sc.hasNextInt()) {
                num = sc.nextInt();
            } else {
                System.out.println(Colores.FONT_RED + "Ingrese un Valor Valido (int)");
                sc.nextLine();
            }
        } while (num == 0);

        return num;
    }

    public static String inputStr(String msge) {
        Scanner sc = new Scanner(System.in);
        String str = "";

        do{
            System.out.println(Colores.FONT_GREEN + msge);
            if (sc.hasNextInt()) {
                System.out.println(Colores.FONT_RED + "Ingrese un Valor Valido (str)");
                sc.nextLine();
            } else {
                str = sc.nextLine();
            }
        } while (str.isEmpty());

        return str;
    }

    public static void delay(long seg)
    {
        try {
            Thread.sleep(seg * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
