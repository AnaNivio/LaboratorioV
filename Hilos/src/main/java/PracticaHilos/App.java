package PracticaHilos;

import clases.Jugador;
import clases.Hola;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Hola hola=new Hola();
        //a pesar de heredar o implementar metodos propios de thres, no se convierte a los jugadores en threads. Por eso, hay que declarar nuevos threads para que puedan correr como un hilo.
        Jugador h1 = new Jugador(hola);
        Jugador h2 = new Jugador(hola);
        Thread t1 = new Thread(h1);
        Thread t2 = new Thread(h2);
        t1.setName("Primer Hilo");
        t2.setName("Segundo Hilo");
        t1.start();
        t2.start();
    }
}
