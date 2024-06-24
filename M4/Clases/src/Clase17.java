import java.io.*;

public class Clase17 {
    private static final String DIR_PATH = "src/directory";

    public static void main(String[] args) throws IOException {
        createDirectory(DIR_PATH);
        File file = createFile("data.txt");

        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("Hello World");
        bw.newLine();
        bw.write("How are you?");
        bw.newLine();
        bw.write("What is your name?");
        bw.newLine();

        bw.close();

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        br.lines().forEach(System.out::println);
    }

    public static void createDirectory(String dir) throws IOException  {
        File newDir = new File(dir);
        if (!newDir.exists())
            newDir.mkdir();
        else
            System.out.println("Directory already exists");
    }

    public static File createFile(String file) throws IOException {
        File newFile = new File(DIR_PATH + "/" + file);
        if (!newFile.exists())
            newFile.createNewFile();
        else
            System.out.println("File already exists");

        return newFile;
    }
}
