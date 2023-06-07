package actividadimpresoras;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Proceso extends Thread {

    Semaphore S;
    String nombre;

    public Proceso(Semaphore S1, String nombre) {
        this.S = S1;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep((long) (Math.random() * 1000));
                System.out.println(nombre + " - Ejecutando");
                System.out.println(nombre + " - Esperando Permiso");
                S.acquire(); //Espera
                System.out.println(nombre + " - Imprimiendo");
                S.release(); //Señal
            } catch (InterruptedException ex) {
                Logger.getLogger(nombre + Proceso.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
