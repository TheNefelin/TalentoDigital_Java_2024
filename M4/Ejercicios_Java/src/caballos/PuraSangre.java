package caballos;

public class PuraSangre extends Caballo {
    private PuraSangre padre;
    private PuraSangre madre;

    public PuraSangre(String nombre, String fechaNaciemiento) {
        super(nombre, fechaNaciemiento);
    }

    public PuraSangre(String nombre, String fechaNaciemiento, PuraSangre madre, PuraSangre padre) {
        super(nombre, fechaNaciemiento);
        this.madre = madre;
        this.padre = padre;
    }

    public PuraSangre getPadre() {
        return padre;
    }

    public PuraSangre getMadre() {
        return madre;
    }

    @Override
    public String toString() {
        return "PuraSangre{" +
                super.toString() +
                "{ padre=" + padre +
                ", madre=" + madre +
                "}}";
    }
}
