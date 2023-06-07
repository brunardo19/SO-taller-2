package actividadimpresoras;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProcesoAB extends Thread {

    Semaphore S1;
    Semaphore S2;
    String nombre;

    public ProcesoAB(Semaphore S1, Semaphore S2, String nombre) {
        this.S1 = S1;
        this.S2 = S2;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep((long) (Math.random() * 1000));
                System.out.println(nombre + " - Ejecutando");
                System.out.println(nombre + " - Esperando Permiso");
                if (S1.tryAcquire()) {
                    System.out.println(nombre + " - Imprimiendo");
                    S1.release(); //Señal
                } else {
                    S2.acquire(); //Espera
                    System.out.println(nombre + " - Imprimiendo");
                    S2.release(); //Señal
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(nombre + ProcesoAB.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
