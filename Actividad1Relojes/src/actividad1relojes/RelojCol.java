package actividad1relojes;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RelojCol extends Thread {
    static Calendar Hora = Calendar.getInstance();
    Semaphore S;
    int hora,minutos,segundos;
    String HoraActualCol;
    
   
     public RelojCol(Semaphore S1) {
        this.S = S1;
    }
     
    
    public void run(){
        hora = Hora.get(Calendar.HOUR_OF_DAY);
        minutos = Hora.get(Calendar.MINUTE);
        segundos = Hora.get(Calendar.SECOND);
        HoraActualCol = hora - 2 + ":" + minutos + ":" + segundos;
        while (true){
            try {
                System.out.println(" - Ejecutando");
                System.out.println(" - Esperando Permiso");
                S.acquire(); //Espera
                System.out.println(" - Hora Colombiana: " + HoraActualCol);
                S.release(); //Señal
            } catch (InterruptedException ex) {
                Logger.getLogger(RelojCol.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    }
    
}
