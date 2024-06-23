public class CambiarWhile {
    public static void main(String[] args) {
        CambiarWhile();
        CambiarWhile();
    }

    private static void CambiarWhile() {
        int i = 0;

//        System.out.println("-- While  -----------------------------");
//        while (i < 50)
//        {
//            i += 1;
//            System.out.printf("Iteración %d\n", i);
//        }

        System.out.println("-- Do While ---------------------------");
        do {
            i += 1;
            System.out.printf("Iteración %d\n", i);
        } while (i < 50);

        System.out.println("---------------------------------------");
    }
}