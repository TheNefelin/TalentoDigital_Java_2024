package archivos;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String path = "src/archivos";
    private static String dirFile;

    public static void main(String[] args) {
        String folder = "data";
        String file = "archivos.csv";

        Persona persona1 = new Persona("Isaac", "Netero", 999, 11111111, "netero@hxh.com");
        Persona persona2 = new Persona("Don", "Freecs", 685, 22222222, "don@hxh.com");
        Persona persona3 = new Persona("Maha", "Zoldyck", 745, 22222222, "maha@hxh.com");

        List<Persona> personas = new ArrayList<>();
        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);

        String dirFolder = createDirectory(folder);

        if (dirFolder != null)
            dirFile = createFile(dirFolder, file);

        if (dirFile != null) {
            writeFile(dirFile, personas);
            readFile(dirFile);
        }
    }

    public static String createDirectory(String folderName) {
        File dir = new File(path, folderName);

        if (!dir.exists()){
            if (dir.mkdir())
                System.out.println("El directorio se ha guardado correctamente");
            else {
                System.out.println("El directorio no se ha guardado correctamente");
                return null;
            }
        }

        return dir.getAbsolutePath();
    }

    public static String createFile(String dirName, String fileName) {
        File file = new File(dirName, fileName);

        try {
            if (!file.exists()){
                if (file.createNewFile())
                    System.out.println("El archivo se ha guardado correctamente");
                else {
                    System.out.println("El archivo no se ha guardado correctamente");
                    return null;
                }
            }
        } catch (IOException e) {
            System.out.println("Error I/O: " + e.getMessage());
            return null;
        }

        return file.getAbsolutePath();
    }

    public static void writeFile(String file, List<Persona> content) {
        try {
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("nombre,apellido,edad,telefono,correo");
            bw.newLine();

            for (Persona persona : content) {
                bw.write(persona.toString());
                bw.newLine();
            }

            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Error I/O: " + e.getMessage());
        }
    }

    public static void readFile(String file) {
        List<Persona> personas = new ArrayList<>();

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            br.lines().skip(1).forEach(row -> {
                String[] datos = row.split(",");

                if (datos.length == 5) {
                    String name = datos[0];
                    String surname = datos[1];
                    int age = Integer.parseInt(datos[2]);
                    int phone = Integer.parseInt(datos[3]);
                    String email = datos[4];

                    Persona persona = new Persona(name, surname, age, phone, email);
                    personas.add(persona);
                }
            });

            fr.close();
            br.close();

            System.out.println(personas.get(0).toString());
            System.out.println(personas.get(1).toString());
            System.out.println(personas.get(2).toString());
        } catch (IOException e) {
            System.out.println("Error I/O: " + e.getMessage());
        }
    }
}
