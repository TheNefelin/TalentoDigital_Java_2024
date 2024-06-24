import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Clase16 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1,4,8,5,5,10,2);
        List<Integer> numeros2 = new ArrayList<>();
        numeros2.add(1);
        numeros2.add(2);
        numeros2.add(3);
        numeros2.add(12);
        numeros2.add(5);
        numeros.forEach(System.out::println);
        System.out.println("------------------------------");
        numeros2.forEach(System.out::println);

        System.out.println("------------------------------");
        numeros.stream()
                .filter(num -> num % 2 == 0)
                .forEach(System.out::println);

        System.out.println("------------------------------");
        numeros2.stream()
                .filter(num -> num % 2 == 0)
                .forEach(System.out::println);
    }
}
