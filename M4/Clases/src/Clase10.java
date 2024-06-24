import java.util.Scanner;

public class Clase10 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.printf(ANSI_YELLOW + "%d * %d = " + ANSI_PURPLE + " %d\n", i, j, i * j);
            }
        }

        Scanner sc = new Scanner(System.in);
        int n = 0;

        do {
            if (sc.hasNextInt()) {
                n = sc.nextInt();
            }else {
                n = 0;
                sc.next();
            }
        } while (n < 0);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n -i; j++) {
                System.out.print(ANSI_PURPLE + "*");
            }
            System.out.print("\n");
        }
    }

    public void prueba() {

    }
}
