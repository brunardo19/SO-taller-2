package atletas;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Meta extends Thread {

    Semaphore m;
    Semaphore g;
    int Equipo;

    public Meta(Semaphore m, Semaphore g, int id) {
        this.m = m;
        this.g = g;
        this.Equipo = id;
    }

    @Override
    public void run() {
        try {
            System.out.println("Esperando Ganador");
            m.acquire();
            g.acquire();
            System.out.println("Ganador: Equipo " + Equipo);
            System.out.println("Tirando Papelitos para Equipo " + Equipo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Meta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
