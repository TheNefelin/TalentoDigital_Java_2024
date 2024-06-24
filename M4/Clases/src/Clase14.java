import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Clase14 {
    public static void main(String[] args) {
        Ejerccio();
        //Clase();
    }

    public static void Ejerccio() {
        ArrayList<String> random = new ArrayList<String>();
        random.add("Primero");
        random.add("Segundo");
        random.add("Tercero");
        random.add("Cuarto");
        random.add("Quinto");

        for (Iterator iterator = random.iterator(); iterator.hasNext();) {
            String elemento = (String) iterator.next();
            System.out.println("El elemento es "+ elemento);
        }
    }

    public static void Clase() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> listaAlumnos = new ArrayList<>();
        listaAlumnos.add("Matias");
        listaAlumnos.add("Francisco");
        listaAlumnos.add("Ion");
        listaAlumnos.add("Miguel");
        //listaAlumnos.add("Rudi");

        System.out.println("Ingrese un Alumno");
        String nomAlumno = sc.nextLine();

        if (listaAlumnos.size() > 4) {
            listaAlumnos.clear();
        } else if (listaAlumnos.size() < 4) {
            if (!listaAlumnos.contains(nomAlumno)) {
                listaAlumnos.add(nomAlumno);
            } else {
                System.out.println(nomAlumno + " Ya Existe el Alumno");
            }
        } else {
            System.out.println("Ingrese Numero del Alumno a Modificar");
            int numAlumno = sc.nextInt();
            listaAlumnos.set(numAlumno, nomAlumno);
        }

        System.out.println(listaAlumnos);

        ArrayList<String> paises = new ArrayList<String>();
        paises.add("Chile");
        paises.add("Argentina");
        paises.add("Colombia");
        paises.add("Perú");
        paises.add("Venezuela");
        Collections.sort(paises);
        System.out.println(paises);
        Collections.reverse(paises);
        System.out.println(paises);

        ArrayList<Integer> numeros = new ArrayList<Integer>();
        numeros.add(5);
        numeros.add(1);
        numeros.add(4);
        numeros.add(1);
        numeros.add(2);
        numeros.add(6);
        System.out.println(Collections.min(numeros));
        System.out.println(Collections.max(numeros));
    }
}
