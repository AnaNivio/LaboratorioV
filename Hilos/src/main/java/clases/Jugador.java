package clases;

public class Jugador implements Runnable{

    private Hola hola;

    public Jugador(Hola hola) {
        this.hola = hola;
    }

    @Override
    public void run() {

        for(int i=0;i <6;i++)
        {
            hola.jugar();
        }
    }
}
