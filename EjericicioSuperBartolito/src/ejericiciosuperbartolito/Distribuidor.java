package ejericiciosuperbartolito;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
   
public class Distribuidor extends Thread {
    Semaphore Canasta;

    public Distribuidor(Semaphore Carrera) {
        this.Canasta = Carrera;
   
    }  
    public void run(){
        while (true){
            try {
                System.out.println("- Esperando");
                Canasta.acquire(); //Espera a la Canasta
                System.out.println(" - Actualizando Canasta");
                Canasta.release(); //Señal
            } catch (InterruptedException ex) {
                Logger.getLogger(Distribuidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    }
    
}
