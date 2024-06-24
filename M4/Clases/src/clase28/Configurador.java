package clase28;

public class Configurador {
    private static Configurador config;

    private Configurador() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static Configurador getInstance() {

        if (config == null){
            synchronized(Configurador.class){
                if (config == null){
                    config = new Configurador();
                    System.out.println("Configurador instanciado");
                }
            }
        }

        System.out.println("Configurador inicializado");
        return config;
    }
}
