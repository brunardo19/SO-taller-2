package ejerciciopeluqueria;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente extends Thread {

    Semaphore sillas;
    Semaphore pelu;
    String nombre;
    String B = "\u001B[34m";

    public Cliente(Semaphore sillas, Semaphore pelu, String nombre, int SE, boolean disp) {
        this.sillas = sillas;
        this.pelu = pelu;
        this.nombre = nombre;
    }

    public void run() {
        try {
            System.out.println(B + nombre + " - Ejecutando");
            System.out.println(nombre + " - Esperando Permiso");
            sillas.acquire(); //Espera a saber si hay asientos dispnibles en la sala de espera
            System.out.println("Cantidad de Sillas disponibles: " + sillas.availablePermits());
            pelu.acquire();
            sillas.release(); //Libera silla
            System.out.println(B + nombre + "- Cortandose el pelo");
            System.out.println("Cantidad de Peluqueros disponibles: " + pelu.availablePermits());
            pelu.release();
            System.out.println(B + nombre + "- Termino de cortarse el pelo");
            System.out.println(B + nombre + "- Sale de la peluqueria");

        } catch (InterruptedException ex) {
            Logger.getLogger(nombre + Peluquero1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
