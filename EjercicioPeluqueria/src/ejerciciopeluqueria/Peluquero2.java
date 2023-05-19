package ejerciciopeluqueria;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Peluquero2 extends Thread {
    Semaphore S;
    String nombre;
    

    public Peluquero2(Semaphore S1,String nombre) {
        this.S = S1;
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
              
            } catch (InterruptedException ex) {
                Logger.getLogger(nombre + Peluquero2.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    }}
