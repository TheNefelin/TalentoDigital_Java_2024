import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Clase13 {
    public static void main(String[] args) {

        ListaElementos();
        ListaElementos();
        Arreglos();
        System.out.println(Suma1());
        System.out.println(Suma2());
    }

    public static  void ListaElementos(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> listaEnteros = new ArrayList<>();
        listaEnteros.add(1);
        listaEnteros.add(2);
        listaEnteros.add(4);
        listaEnteros.add(3);

        listaEnteros.remove(2);
        System.out.println(listaEnteros);

        ArrayList<String> listaString = new ArrayList<>();
        listaString.add("a");
        listaString.add("b");
        listaString.add("c");
        listaString.add("c");
        listaString.add("c");
        listaString.add("a");
        listaString.add("d");

        ArrayList<String> listaBorrar = new ArrayList<>();
        listaBorrar.add("a");
        listaBorrar.add("c");

        listaBorrar.add("d");
        listaString.removeAll(listaBorrar);
        System.out.println(listaString);
    }

    public static void ListaIngredientes() {
        ArrayList<String> listaString = new ArrayList<String>();
        listaString.add("1");
        listaString.add("2");
        listaString.add("3");
        System.out.println(listaString);

        ArrayList<String> listaIngredientes = new ArrayList<>();
        listaIngredientes.add("Salsa de Tomate");
        listaIngredientes.add("Tomate");
        listaIngredientes.add("Jamon");
        listaIngredientes.add("Queso");
        listaIngredientes.add("Champiñones");

        System.out.println(listaIngredientes);

        Scanner sc = new Scanner(System.in);
        String ingrediente = sc.nextLine();

        if (ingrediente.equals("clear")) {
            listaIngredientes.clear();
        } else if (listaIngredientes.contains(ingrediente)) {
            System.out.println("El Ingrediente ya Existe");
            listaIngredientes.remove(0); // borra por indice
            listaIngredientes.remove(ingrediente); // por texto
        } else {
            listaIngredientes.add(ingrediente);
            System.out.println("Ingrediente Agregado");
        }

        System.out.println(listaIngredientes);
    }

    public static void Arreglos() {
        int [] edades;
        String [] nombres;
        ArrayList<Integer> lista = new ArrayList();

        edades = new int [5];
        //nombres = new String[5];

        edades[0] = 37;
        edades[1] = 38;
        edades[2] = 39;

        nombres = new String[] {"Rudi", "Fco", "Caro", "Ion", "Nico"};

        lista.add(37);
        lista.add(38);
        lista.remove(0);
        lista.add(39);

        for (int i = 0; i < nombres.length; i++) {
            System.out.println(nombres[i]);
        }

        System.out.println(Arrays.toString(edades));
        System.out.println(Arrays.toString(nombres));
        System.out.println(lista);
        System.out.println(Arrays.toString(lista.toArray()));
    }

    public static double Suma1() {
        double suma = 0;
        double [] numeros = new double[] {(Math.random()), (Math.random()), (Math.random())};

        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
        }

        return Math.round(suma * 10);
    }

    public static double Suma2() {
        double suma = 0;
        double[] numeros = new double[10];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Math.random() * 100;
        }

        System.out.println(Arrays.toString(numeros));

        for (double numero : numeros) {
            suma += numero;
        }

        return Math.round(suma);
    }
}