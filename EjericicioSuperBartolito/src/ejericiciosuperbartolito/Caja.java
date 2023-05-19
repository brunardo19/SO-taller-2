package ejericiciosuperbartolito;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Caja extends Thread {
    Semaphore Canasta;

    public Caja(Semaphore Carrera) {
        this.Canasta = Carrera;
   
    }  
    public void run(){
        while (true){
            try {
                System.out.println("- Esperando");
                Canasta.acquire(); //Espera a la Canasta
                System.out.println(" - Vendiendo");
                Canasta.release(); //Señal
            } catch (InterruptedException ex) {
                Logger.getLogger(Caja.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    }
}
