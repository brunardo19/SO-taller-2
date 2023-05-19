package actividad1relojes;

import java.time.LocalTime;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RelojArg extends Thread {
    LocalTime horaactual = LocalTime.now();
    Semaphore S;
   
     public RelojArg(Semaphore S1) {
        this.S = S1;
    }
    
    public void run(){
        
        while (true){
            try {
                System.out.println(" - Ejecutando");
                System.out.println(" - Esperando Permiso");
                S.acquire(); //Espera
                System.out.println(" - Hora Argentina: "+ horaactual );
                S.release(); //Señal
            } catch (InterruptedException ex) {
                Logger.getLogger(RelojArg.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    }
    
}
