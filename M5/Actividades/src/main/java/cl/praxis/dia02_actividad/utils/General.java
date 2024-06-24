package cl.praxis.dia02_actividad.utils;

public class General {
    public General() {}

    public String getNombreMes(int numNes) {
        String[] nombresMeses = {
                "Enero",
                "Febrero",
                "Marzo",
                "Abril",
                "Mayo",
                "Junio",
                "Julio",
                "Agosto",
                "Septiembre",
                "Octubre",
                "Noviembre",
                "Diciembre"
        };

        return nombresMeses[numNes];
    }

    public String getEfemeridesMes(int numNes) {
        String[] efemeridesMes = {
                "Efeméride 1 Enero, " + "Efeméride 2 Enero, " + "Efemerid 3 Enero",
                "Efeméride 1 Febrero, Efeméride 2 Febrero", "Efeméride 1 Marzo, Efeméride 2 Marzo",
                "Abril - Sin Efemerides", "Efemeride 1 Mayo",
                "Efemeride 1 Junio, Efemeride 2 Julio",
                "Efeméride 1 Julio, Efeméride 2 Julio", "Agosto - Sin Efemerides",
                "Efeméride 1 Septiembre, Efeméride 2, Efeméride 3",
                "Octubre - Sin Efemerides",
                "Efemeride 1 Noviembre, Efemeride 2 Noviembre",
                "Efemeride 1 Diciembre"
        };

        return efemeridesMes[numNes];
    }
}
