import java.util.ArrayList;
import java.util.Scanner;

public class Clase15 {
    private static ArrayList<String> elementos = new ArrayList<>();
    private static ArrayList<String> listaNombres = new ArrayList<>();

    public static void main(String[] args) {
        elementos.add("mesa");
        elementos.add("Refrigerador");
        elementos.add("Cocina");
        elementos.add("lavadora");

        buscarNombre("Netero");
        buscarNombre("Netero");
        buscarNombre("Hizoka");
        buscarNombre("Gon");
        System.out.println("-------------------------------------");
        System.out.println(listaNombres);

        notaMaxMin();
        agregaElemento();
        promedio();
    }

    private static void buscarNombre(String nombre) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------------------------");

        if (listaNombres.contains(nombre))
            System.out.println("El nombre: " + nombre + " ya existe");
        else {
            System.out.println("Nuevo Nombre: " + nombre);
            listaNombres.add(nombre);
        }
    }

    private static void notaMaxMin() {
        ArrayList<Double> notas = new ArrayList<>();
        notas.add(4.7);
        notas.add(2.2);
        notas.add(5.4);
        notas.add(6.9);
        notas.add(4.4);
        notas.add(2.6);

        double mayor = notas.get(0);
        double menor = notas.get(0);

        for (double nota : notas) {
            if (nota > mayor)
                mayor = nota;
            if (nota < menor)
                menor = nota;
        }

        System.out.println("-- Notas ----------------------------");
        System.out.println(notas);
        System.out.println("-------------------------------------");
        System.out.printf("Nota Mayor: %.1f\n", mayor);
        System.out.printf("Nota Menor %.1f\n", menor);
    }

    private static void agregaElemento() {
        Scanner sc = new Scanner(System.in);
        String nuevoElemento = "";

        do {
            System.out.println("-------------------------------------");
            System.out.println("Para sali ingrese 'salir'");
            System.out.println("De lo Contrario, Ingrese nuevo Elemento");
            System.out.println("-------------------------------------");
            nuevoElemento = sc.next();

            if (!nuevoElemento.equals("salir")){
                if (elementos.contains(nuevoElemento)) {
                    System.out.println("El elemento ya existe");
                } else {
                    elementos.add(nuevoElemento);
                }
            }
        } while(!nuevoElemento.equals("salir"));

        System.out.println("-------------------------------------");
        System.out.println(elementos);
        System.out.println("-------------------------------------");
    }

    public static void promedio() {
        ArrayList<Double> total = new ArrayList<>();
        int[] sueldos = { 400000, 760000, 1100000, 650000, 654980, 987300, 700450, 442300 };

        for (int sueldo : sueldos) {
            if (sueldo > 500000) {
                total.add((double)sueldo);
            }
        }

        System.out.println(total.stream().reduce(0.0, Double::sum) / total.size());
    }
}
