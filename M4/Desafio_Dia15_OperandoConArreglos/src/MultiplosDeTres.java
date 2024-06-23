import java.util.ArrayList;

public class MultiplosDeTres {
    public static void main(String[] args) {
        if (args.length > 0) {
            suma(args);
        }
    }

    public static void suma(String[] args) {
        int evaluar = 0;
        ArrayList<Integer> lista = new ArrayList<>();

        for (String arg : args) {
            evaluar = Integer.parseInt(arg);

            if (evaluar % 3 == 0) {
                lista.add(evaluar);
            }
        }

        System.out.println(lista.stream().reduce(0, Integer::sum));

        promedio(lista);
    }

    public static void promedio(ArrayList<Integer> numeros) {
        System.out.println(numeros.stream().reduce(0, Integer::sum) / numeros.size());
    }
}