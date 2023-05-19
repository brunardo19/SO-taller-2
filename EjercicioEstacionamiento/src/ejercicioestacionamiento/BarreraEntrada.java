package ejercicioestacionamiento;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BarreraEntrada extends Thread {

    Semaphore Estacionamiento;
    Semaphore sinc;
    Semaphore[] entradaSinc;
    int barId;
    public static final String G = "\033[1;32m";  // GREEN
    public static final String R = "\033[1;31m";    // RED

    public BarreraEntrada(Semaphore Estacionamiento, Semaphore sinc, Semaphore[] entradaSinc, int barId) {
        this.Estacionamiento = Estacionamiento;
        this.sinc = sinc;
        this.entradaSinc = entradaSinc;
        this.barId = barId;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (Estacionamiento.availablePermits() > 0) {
                    System.out.println("- Esperando en entrada" + barId);
                    Estacionamiento.acquire(); //Llega auto
                    System.out.println(G + "- Auto ingresado en entrada" + barId);
                    int espera = (int) (Math.random() * 1000);
                    System.out.println(" - Ingresa Auto");
                    System.out.println("Tiempo de espera: " + espera + "milisegundos");
                    sleep(espera);
                    sinc.release();
                } else {
                    System.out.println(R + "Estacionamiento Lleno");
                    if (barId !=0) {
                    System.out.println("- Esperando en entrada" + barId + " - Por turno de entrada");
                        entradaSinc[barId].acquire();
                    System.out.println(G + "- Auto ingresado en entrada" + barId + " - Tras esperar turno");
                    }
                    Estacionamiento.acquire(); //Llega auto
                    int espera = (int) (Math.random() * 1000);
                    System.out.println(" - Ingresa Auto");
                    System.out.println("Tiempo de espera: " + espera + "milisegundos");
                    sleep(espera);
                    sinc.release();
                    if (barId != entradaSinc.length) {
                        entradaSinc[barId + 1].release();
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Estacionamiento.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
