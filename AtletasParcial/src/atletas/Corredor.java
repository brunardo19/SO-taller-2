package atletas;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Corredor extends Thread {

    Semaphore ant;
    Semaphore s;
    int Equipo;
    int idC;

    public Corredor(Semaphore ant, Semaphore s, int id, int idC) {
        this.s = s;
        this.ant = ant;
        this.Equipo = id;
        this.idC = idC;
    }

    @Override
    public void run() {
        try {
            System.out.println("Equipo " + Equipo + ", Corredor " + idC + ": Esperando largada/posta");
            ant.acquire();
            System.out.println("Equipo " + Equipo + ", Corredor " + idC + ": Corriendo");
            sleep((long) (Math.random()*500));
            System.out.println("Equipo " + Equipo + ", Corredor " + idC +  ": Termina de correr, Descansando");
            s.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Corredor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
