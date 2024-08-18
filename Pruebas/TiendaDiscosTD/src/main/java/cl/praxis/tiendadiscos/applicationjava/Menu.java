package cl.praxis.tiendadiscos.applicationjava;

import java.util.Scanner;

public class Menu {
    Scanner sc = new Scanner(System.in);
    private Service service;

    public Menu() {
        service = new Service();
        getMenu();
    }

    private void getMenu() {
        int opcion;

        do {
            System.out.println("--------------------- Menu ----------------------");
            System.out.println("1 - Algoritmo Miembros Promovidos de Vinil");
            System.out.println("2 - Algoritmo Informe Reponer Discos");
            System.out.println("3 - Salir...");
            System.out.println("-------------------------------------------------");
            opcion = inputInt("Ingrese una Opcion:");

            if (opcion == 1) {
                promovidos();
            } else if (opcion == 2) {
                service.validarInventario();
            } else if (opcion == 3)
                System.out.println("Saliedo...");
            else {
                System.out.println("Ingrese una Opcion Valida (Menu)");
                opcion = 0;
            }
        } while (opcion != 3);
    }

    private void promovidos() {
        int idMembresia;

        do {
            idMembresia = inputInt("Indique el Id Membresia:");

            if (idMembresia == 1)
                System.out.println("Id:1 - Membresia Vinil I");
            else if (idMembresia == 2)
                System.out.println("Id:2 - Membresia Vinil II");
            else
                System.out.println("Ingrese un Id Membresia Valida");
        } while (idMembresia != 1 && idMembresia != 2);

        service.validarMiembro(idMembresia);
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
