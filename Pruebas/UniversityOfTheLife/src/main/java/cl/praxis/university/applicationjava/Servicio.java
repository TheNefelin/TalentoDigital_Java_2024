package cl.praxis.university.applicationjava;

import java.text.DecimalFormat;
import java.util.List;

public class Servicio implements IValidacionCupos, IValidarNotas {
    Repositorio repositorio = new Repositorio();


    @Override
    public void validarCupo(int idEspecialidad) {
        List<Entidad> entidads = repositorio.getEntidades()
                .stream()
                .filter(e -> e.getIdEspecialidad() == idEspecialidad)
                .toList();

        int cant = entidads.size();

        if (entidads.isEmpty()) {
            System.out.println("La Especialidad NO Existe");
            return;
        }

        if (cant > 25)
            System.out.println(entidads.getFirst().getCurso() + " tiene " + cant + " alumnos debe habilitar una nueva seccion");
        else
            System.out.println(entidads.getFirst().getCurso() + " tiene " + cant + " alumnos, esta OK");
    }

    @Override
    public void validarNotas(int idAlumno) {
        List<Entidad> entidads = repositorio.getEntidades()
                .stream()
                .filter(e -> e.getId() == idAlumno)
                .toList();

        if (entidads.isEmpty()) {
            System.out.println("El Registros NO Existen");
        } else {
            System.out.println("Las notas de " + entidads.getFirst().getNombre() + " " + entidads.getFirst().getApellido() + " son:");

            double sum = 0;
            int cant = 0;
            for (Entidad entidad : entidads) {
                System.out.println(entidad.getCurso() + " : " + entidad.getNota());
                sum += entidad.getNota();
                cant += 1;
            }

            double res = sum / cant;
            DecimalFormat df = new DecimalFormat("#.0");

            System.out.println("Promedio Final: " + df.format(res));

            if (res > 4) {
                System.out.println("Estado Final: Aprobado");
            } else {
                System.out.println("Estado Final: Reprobado");
            }
        }
    }
}
