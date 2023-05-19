package ejerciciopeluqueria;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Peluquero3 extends Thread {
    Semaphore S;
    Semaphore sillas;
    String nombre;
    

    public Peluquero3(Semaphore S, Semaphore sillas, String nombre) {
        this.S = S;
        this.sillas = sillas;
        this.nombre = nombre;
    }
    
    public void run(){
        while (true){
            try {
                System.out.println(nombre + " - Ejecutando");
                System.out.println(nombre + " - Esperando Permiso");
                S.acquire(); //El peluquero se despierta
                System.out.println(" El cliente se sienta listo para cortarse el pelo ");
                System.out.println(nombre + " - Cortando cabello");
                Thread.sleep(1000);
                S.release(); //Se termino de cortar el pelo el cliente
                sillas.release();//El cliente se va
              
            } catch (InterruptedException ex) {
                Logger.getLogger(nombre + Peluquero3.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
}}
