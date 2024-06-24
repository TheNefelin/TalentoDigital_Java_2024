package caballos;

import autos.AutoConRuedas;
import autos.Rueda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AutoConRuedas auto1 = new AutoConRuedas();

        Rueda rueda1 = new Rueda("Michelin",  15);
        Rueda rueda2 = new Rueda("Michelin", "Nieve", 15);
        Rueda rueda3 = new Rueda("Michelin", "Nieve", 15);
        Rueda rueda4 = new Rueda("Michelin", "Nieve", 15);
        Rueda ruedaRepuesto = new Rueda("Michelin", "Nieve", 15);

        List<Rueda> ruedas = new ArrayList<Rueda>();
        ruedas.add(rueda1);
        ruedas.add(rueda2);
        ruedas.add(rueda3);
        ruedas.add(rueda4);
        ruedas.add(ruedaRepuesto);

        auto1.setAnio(2024);
        auto1.setCatalitico(true);
        auto1.setColor("Azul");
        auto1.setComustible("95 Octanos");
        auto1.setMarca("Ñuñuqui");
        auto1.setModelo("Expresso");
        auto1.setOrigen("India");
        auto1.setRuedas(ruedas);

        PuraSangre padre = new PuraSangre("Caballo Papa", "2004-01-01");
        PuraSangre madre = new PuraSangre("Caballo Mama", "2004-01-02");
        PuraSangre hijo1 = new PuraSangre("Caballo Hijo1", "2024-02-04", madre, padre);
        PuraSangre hijo2 = new PuraSangre("Caballo Hijo2", "2024-02-04", madre, padre);
        PuraSangre hijo3 = new PuraSangre("Caballo Hijo3", "2024-02-04", madre, padre);
        PuraSangre nieto = new PuraSangre("Caballo Nieto", "2024-02-04", hijo1, hijo3);

        System.out.println("----------------------------------------------------");
        System.out.println(rueda1);
        System.out.println(auto1);
        System.out.println("----------------------------------------------------");
        //System.out.println(padre);
        //System.out.println(madre);
        System.out.println(hijo1);
        //System.out.println(nieto);
        System.out.println("----------------------------------------------------");
    }
}
