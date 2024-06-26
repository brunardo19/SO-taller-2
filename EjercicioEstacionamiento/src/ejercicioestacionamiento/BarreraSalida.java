package ejercicioestacionamiento;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BarreraSalida extends Thread {

    Semaphore Estacionamiento;
    Semaphore sinc;

    int barId;
    int i = 1;
    public static final String Y = "\033[1;33m"; // YELLOW

    public BarreraSalida(Semaphore Estacionamiento, Semaphore sinc, int entrada) {
        this.Estacionamiento = Estacionamiento;
        this.sinc = sinc;
        this.barId = entrada;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sinc.acquire();
                System.out.println("- Esperando en Salida" + barId);
                sleep(500);
                System.out.println(Y + " - Salida Auto");
                Estacionamiento.release(); //Se cierran las barreras
            } catch (InterruptedException ex) {
                Logger.getLogger(BarreraSalida.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
