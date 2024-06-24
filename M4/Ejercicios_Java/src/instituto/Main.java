package instituto;

public class Main {
    public static void main(String[] args) {
        Runnable tarea = () -> {
            InstitutoEducativo objInstancia = InstitutoEducativo.getInstancia();
            objInstancia.mostrarMensaje();
        };
        //Se crean los hilos de tareas que van a obtener la instancia

        Thread hilo1 = new Thread(tarea);
        System.out.println("** Instancia 1 *********************");
        Thread hilo2 = new Thread(tarea);
        System.out.println("** Instancia 2 *********************");
        Thread hilo3 = new Thread(tarea);
        System.out.println("** Instancia 3 *********************");

        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}
