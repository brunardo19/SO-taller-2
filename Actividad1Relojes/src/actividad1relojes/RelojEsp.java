package actividad1relojes;

import static actividad1relojes.RelojCol.Hora;
import java.util.Calendar;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RelojEsp extends Thread {
    static Calendar Hora = Calendar.getInstance();
    Semaphore S;
    int hora,minutos,segundos;
    String HoraActualEsp;
   
     public RelojEsp(Semaphore S1) {
        this.S = S1;
    }
    
    public void run(){
        hora = Hora.get(Calendar.HOUR_OF_DAY);
        minutos = Hora.get(Calendar.MINUTE);
        segundos = Hora.get(Calendar.SECOND);
        HoraActualEsp = hora + 5 + ":" + minutos + ":" + segundos;
        while (true){
            try {
                System.out.println(" - Ejecutando");
                System.out.println(" - Esperando Permiso");
                S.acquire(); //Espera
                System.out.println(" - Hora Española: " + HoraActualEsp);
                S.release(); //Señal
            } catch (InterruptedException ex) {
                Logger.getLogger(RelojEsp.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    }
    
}
