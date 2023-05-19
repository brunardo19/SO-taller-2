package ejercicioestacionamiento;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BarreraEntrada extends Thread {

    Semaphore Estacionamiento;
    Semaphore sinc;
    int barId;

    public BarreraEntrada(Semaphore Estacionamiento, Semaphore sinc, int entrada) {
        this.Estacionamiento = Estacionamiento;
        this.sinc = sinc;
        this.barId = entrada;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("- Esperando en entrada" + barId);
                System.out.println("Capacidad: " + Estacionamiento.availablePermits());
                Estacionamiento.acquire(); //Se espera que se liberen plazas para el ingreso de autos
                int espera = (int) (Math.random() * 10000);
                System.out.println(" - Ingresa Auto");
                System.out.println("Tiempo de espera: " + espera/1000 + " segundos");
                sleep(espera);
                sinc.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Estacionamiento.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
