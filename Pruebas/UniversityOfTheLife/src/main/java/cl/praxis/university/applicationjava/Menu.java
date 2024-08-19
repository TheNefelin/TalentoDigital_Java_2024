package cl.praxis.university.applicationjava;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    Servicio servicio = new Servicio();

    public Menu() {
        getMenu();
    }

    private void getMenu() {
        int opcion;

        do {
            System.out.println("--------------------- Menu ----------------------");
            System.out.println("1 - Algoritmo Validar Cupos");
            System.out.println("2 - Algoritmo Validar Notas");
            System.out.println("3 - Salir...");
            System.out.println("-------------------------------------------------");
            opcion = inputInt("Ingrese una Opcion:");

            if (opcion == 1) {
                int idEspecialidad = inputInt("Indique el Id de la Especialidad:");
                servicio.validarCupo(idEspecialidad);
            } else if (opcion == 2) {
                int idAlumno = inputInt("Indique el Id del Alumno:");
                servicio.validarNotas(idAlumno);
            } else if (opcion == 3)
                System.out.println("Saliedo...");
            else {
                System.out.println("Ingrese una Opcion Valida (Menu)");
                opcion = 0;
            }
        } while (opcion != 3);
    }

    private int inputInt(String msge) {
        int num = 0;

        do{
            System.out.println(msge);
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Ingrese un Valor Valido (int)");
                sc.nextLine();
            }
        } while (num == 0);

        return num;
    }
}
