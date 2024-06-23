public class Visitas {
    public static void main(String[] args) {
        if (args.length > 0)
            promedio(args);
    }

    private static void promedio(String[] visitas) {
        int total = 0;

        for (String visita: visitas){
            total += Integer.parseInt(visita);
        }

        System.out.println("El resultado es: " + total/visitas.length);
    }
}
