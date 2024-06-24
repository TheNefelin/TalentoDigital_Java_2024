package informatica;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Programador> programadores = new ArrayList<Programador>();
        programadores.add(new Programador("Isaac Netero", "111111", 160, "Java"));
        programadores.add(new Programador("Zeno Zoldyck", "222222", 150, "C#"));
        programadores.add(new Programador("Biscuit Krueger", "333333", 190, "C++"));

        Jefe jefeProyecto = new Jefe("Don Freecss", "000000", 169, "Cloud Computing");

        Oficina oficina = new Oficina(programadores, jefeProyecto, 10);

        System.out.println("---------------------------------------------");
        System.out.println(oficina);
        System.out.println("---------------------------------------------");
    }
}
