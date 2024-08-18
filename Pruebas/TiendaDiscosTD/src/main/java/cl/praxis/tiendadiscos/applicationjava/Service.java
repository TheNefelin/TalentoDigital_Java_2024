package cl.praxis.tiendadiscos.applicationjava;

import java.util.List;

public class Service implements IValidarMiembro, IValidarInventario {
    private Repository repo;

    public Service() {
        repo = new Repository();
    }

    @Override
    public void validarMiembro(int idMembresia) {
        List<Miembro> miembros = repo.getMiembros()
                .stream()
                .filter(e -> e.getIdMembresia() == idMembresia)
                .toList();

        if (idMembresia == 1) {
            System.out.println("Los siguientes Miembros deben ser promovidos a Vinil II");
            for (Miembro miembro : miembros) {
                if (miembro.getTotal() >= 50000) {
                    System.out.println(miembro.getNombre() + " " + miembro.getApellido() + " (" + miembro.getTotal() + ")");
                }
            }
        } else if (idMembresia == 2) {
            System.out.println("Los siguientes Miembros deben ser promovidos a Vinil III");
            for (Miembro miembro : miembros) {
                if (miembro.getTotal() >= 75000) {
                    System.out.println(miembro.getNombre() + " " + miembro.getApellido()+ " (" + miembro.getTotal() + ")");
                }
            }
        } else {
            System.out.println("Busqueda no Valida");
        }

    }

    @Override
    public void validarInventario() {
        List<Disco> discos = repo.getDiscos();
        System.out.println("Los siguientes Discos deben ser Repuestos:");

        discos.forEach(e -> {
            if (e.getStock() < 5) {
                System.out.println(e.getNombre() + " " + e.getArtista() + ": quedan " + e.getStock() + " en stock");
            }
        });
    }
}
