package otros;

public class LambdaDemo {
    public static void main(String[] args) {
        //Implementa la operción utilizando Lambda para sumar dos número
        //podría ser cualquier operación
        Operacion suma =(a,b)->a+b;
        System.out.println("La suma es: "+suma.operar(5,3));
    }
}
//Interface para funcional para operar con dos enteros
interface Operacion{
    int operar(int a, int b);
}
