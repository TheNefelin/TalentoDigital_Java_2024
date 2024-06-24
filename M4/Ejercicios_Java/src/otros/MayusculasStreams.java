package otros;

import java.util.List;
import java.util.stream.Collectors;

public class MayusculasStreams {
    public static void main(String[] args) {
        List<String> palabras = List.of("hola", "mundo");
        // Transforma cada elemento a mayúsculas.
        List<String> mayusculas = palabras.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(mayusculas);  // Salida: [HOLA, MUNDO]
    }
}