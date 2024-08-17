package cl.praxis.veterinaria.applicationjava;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
            System.out.println("1 - Algoritmo Stock");
            System.out.println("2 - Algoritmo Mascota");
            System.out.println("3 - Salir...");
            System.out.println("-------------------------------------------------");
            opcion = inputInt("Ingrese una Opcion:");

            if (opcion == 1) {
                menuStock();
            } else if (opcion == 2) {
                menuPaciente();
            } else if (opcion == 3)
                System.out.println("Saliedo...");
            else {
                System.out.println("Ingrese una Opcion Valida (Menu)");
                opcion = 0;
            }
        } while (opcion != 3);
    }

    private void menuStock() {
        int idSucursal;

        do {
            idSucursal = inputInt("Indique el Id Sucursal:");

            if (idSucursal == 1)
                System.out.println("Id Sucursal 1");
            else if (idSucursal == 2)
                System.out.println("Id Sucursal 2");
            else
                System.out.println("Ingrese una Opcion Valida (Stock)");
        } while (idSucursal != 1 && idSucursal != 2);

        servicio.checkStrock(idSucursal);
    }

    private void menuPaciente() {
        LocalDate date;

        date = inputDate("Ingrese fecha (yyyy-MM-dd):");

        servicio.verificarCita(date);
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

    private String inputStr(String msge) {
        String str = "";

        do{
            System.out.println(msge);
            if (sc.hasNextInt()) {
                System.out.println("Ingrese un Valor Valido (str)");
                sc.nextLine();
            } else {
                str = sc.nextLine();
            }
        } while (str.isEmpty());

        return str;
    }

    private LocalDate inputDate(String msge) {
        LocalDate date = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        do {
            System.out.println(msge);
            String input = sc.nextLine();
            try {
                date = LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Ingrese una fecha válida en el formato yyyy-MM-dd");
            }
        } while (date == null);

        return date;
    }
}
