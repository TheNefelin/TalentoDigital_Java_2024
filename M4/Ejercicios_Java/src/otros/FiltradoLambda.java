package otros;

import java.util.List;
import java.util.stream.Collectors;

public class FiltradoLambda {
    public static void main(String[] args) {
        //List.of -> Este método permite crear listas inmutables de manera rápida
        List<String> palabras = List.of("manzana", "banana", "cereza", "jugo");
        // Filtra palabras que contienen 'a', usando una expresión lambda.
        List<String> resultado = palabras.stream()
                .filter(s -> s.contains("a"))//La expresión lambda s -> s.contains("a") define la condición para el método filter, que es parte del API de Streams.
                //collect() -> transforma los elementos de un stream en una lista o en otro tipo de colección.
                .collect(Collectors.toList()); //Collectors.toList() se utiliza para recoger todos los elementos del stream en una nueva lista.
        System.out.println(resultado);  // Salida: [manzana, banana, cereza]
    }
}
