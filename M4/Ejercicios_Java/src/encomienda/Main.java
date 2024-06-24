package encomienda;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nombre, apellido, direccion, ciudad;
        int numDireccion, telefono;

        System.out.print("Ingrese el Nombre: ");
        nombre = sc.nextLine();

        System.out.print("Ingrese el Apellido: ");
        apellido = sc.nextLine();

        System.out.print("Ingrese el Direccion: ");
        direccion = sc.nextLine();

        System.out.println("Ingrese el Numero de Direccion");
        numDireccion = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese el Ciudad: ");
        ciudad = sc.nextLine();

        System.out.print("Ingrese el Telefono: ");
        telefono = sc.nextInt();

        String etiqueta = String.format(
                "De:%s %s\n"
                        +"Dirección:%s %d\n"
                        +"Ciudad:%s\n"
                        +"Contacto:%d\n",
                nombre, apellido, direccion, numDireccion, ciudad, telefono);
        System.out.println(etiqueta);
        sc.close();
    }
}
