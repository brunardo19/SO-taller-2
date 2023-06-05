package ejercicioatletas;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Atleta extends Thread {

    String nombre;
    int meta;
    float tiempo, distancia = 0;

    public Atleta(String nombre) {
        this.nombre = nombre;
    }

    public void run() {
        meta = 5;
        while (distancia <= meta) {
            try {
                distancia += Math.random();
                Thread.sleep(1000);
                System.out.println(nombre + " - Va corriendo : " + distancia + " - en: " + tiempo + " segundos");
                tiempo += 1;
                if (distancia >= meta) {
                    System.out.println(nombre + "Llego a la meta en " + tiempo + " segundos");
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Atleta.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
