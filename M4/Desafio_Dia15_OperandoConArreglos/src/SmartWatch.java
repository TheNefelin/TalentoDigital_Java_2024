import java.util.ArrayList;

public class SmartWatch {
    public static void main(String[] args) {
        if (args.length > 0) {
            clearSteps(args);
        }
    }

    private static void clearSteps(String[] numeros) {
        ArrayList<Integer> numLimpios = new ArrayList<>();
        int evaluar = 0;

        for (String numero : numeros) {
            evaluar = Integer.parseInt(numero);

            if (evaluar >= 200 && evaluar <= 100000) {
                numLimpios.add(evaluar);
            }
        }
        System.out.println("-------------------------");
        System.out.println(numLimpios);
        System.out.println("-------------------------");
        System.out.println(numLimpios.stream().reduce(0, Integer::sum) / numLimpios.size());
        System.out.println("-------------------------");
    }
}
