import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Fichero {
    private static final String RUTA = "src/cl/praxis/curso/m4/desafio_m4_dia18/";

    public static void main(String[] args) {
        String directorio = inputStr(Colores.FONT_GREEN + "Ingrese Nombre del Directorio");
        String archivo = inputStr(Colores.FONT_GREEN + "Ingrese Nombre del Archivo");
        String texto = inputStr(Colores.FONT_GREEN + "Ingrese Texto a Buscar");

        directorio = RUTA.concat(directorio);
        archivo = archivo.concat(".txt");

        crearArchivo(directorio, archivo);
        buscarTexto(directorio.concat("/").concat(archivo), texto);
    }

    private static void crearArchivo(String directorio, String fichero) {
        File dir = new File(directorio);
        File file = new File(dir, fichero);
        boolean estado;

        if (!dir.exists()) {
            estado = dir.mkdir();
            System.out.println(Colores.FONT_PURPLE + "El Directorio se creo correctamente");

            if (!estado)
                System.out.println(Colores.FONT_RED + "Error al crear directorio");
        } else {
            System.out.println(Colores.FONT_PURPLE + "El Directorio ya existe");
        }

        if (dir.exists() && !file.exists()) {
            try {
                estado = file.createNewFile();
                System.out.println(Colores.FONT_PURPLE + "El Archivo se creo correctamente");

                if (!estado)
                    System.out.println(Colores.FONT_RED + "Error al crear archivo");
            } catch (IOException e) {
                estado = false;
                System.out.println(Colores.FONT_RED + "IO Exception: " + e.getMessage());
            }
        } else {
            estado = false;
            System.out.println(Colores.FONT_PURPLE +"El Archivo ya existe");
        }

        if (estado)
            escribirTexto(file);
    }

    private static void escribirTexto(File file) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Perro");
        lista.add("Gato");
        lista.add("Juan");
        lista.add("Daniel");
        lista.add("Juan");
        lista.add("Gato");
        lista.add("Perro");
        lista.add("Camila");
        lista.add("Daniel");
        lista.add("Camila");

        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            for (String s : lista) {
                bw.write(s);
                bw.newLine();
            }

            bw.close();
            System.out.println(Colores.FONT_PURPLE + "Datos guardado correctamente");
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private static void buscarTexto(String nombreFichero, String texto) {
        File file = new File(nombreFichero);
        ArrayList<String> resultado = new ArrayList<>();

        if (file.exists()) {
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                br.lines()
                        .filter(s -> s.equals(texto))
                        .forEach(resultado::add);

                System.out.println(Colores.FONT_YELLOW + "Cantidad de Repeticiones del Texto (" + texto + ") -> " + resultado.size());
            } catch (FileNotFoundException ex) {
                System.out.println(Colores.FONT_RED + "Error: " + ex.getMessage());
            }
        } else {
            System.out.println("El fichero ingresado no existe");
        }
    }

    private static String inputStr(String msge) {
        Scanner sc = new Scanner(System.in);
        String str = "";

        do{
            System.out.println(Colores.FONT_GREEN + msge);
            if (sc.hasNextInt()) {
                System.out.println(Colores.FONT_RED + "Ingrese un Valor (str) Valido");
                sc.nextLine();
            } else {
                str = sc.nextLine();
            }
        } while (str.isEmpty());

        return str;
    }
}