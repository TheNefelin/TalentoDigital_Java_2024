package instituto;

public class InstitutoEducativo {
    private static InstitutoEducativo instancia;

    private InstitutoEducativo() {
        try{
            Thread.sleep(4000);
            System.out.println("************************************");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static InstitutoEducativo getInstancia() {
        if (instancia == null) {
            synchronized (InstitutoEducativo.class) {
                if (instancia == null) {
                    instancia = new InstitutoEducativo();
                    System.out.println("Instancia inicializada");
                }
            }
        }

        System.out.println("LLamado a la instancia finalizado");
        return instancia;
    }

    public void mostrarMensaje(){
        System.out.println("Soy la única instancia de la clase InstitutoEducativo");
    }
}
