package clases;

public class Hola {
    private boolean saludando= Boolean.FALSE;

    public synchronized void jugar(){
    //aca debo considerar que entran todos los hilos. Hay uno que va a lograr pasar la condicion mientras que el resto se quedara en el wait
        while (saludando) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        saludando=Boolean.TRUE;
        System.out.println("Hola, soy el hilo "+ Thread.currentThread().getName());
        saludando=Boolean.FALSE;
        notifyAll();

        //linea agregada

    }
}
