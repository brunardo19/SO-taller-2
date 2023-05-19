package actividadimpresoras;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Impresoras_B extends Thread {
    Semaphore S;
    String nombre;
    int NumB;
    int cont = 1;

    public Impresoras_B(Semaphore S1,String nombre,int Nb) {
        this.S = S1;
        this.nombre= nombre;
        this.NumB = Nb;
    }
    
    public void run(){
        
        while (cont <= NumB){
            try {
                System.out.println(nombre + " - Ejecutando");
                System.out.println(nombre + " - Esperando Permiso");
                S.acquire(); //Espera
                System.out.println(nombre + " - Imprimiendo");
                S.release(); //Señal
                cont = cont + 1;
            } catch (InterruptedException ex) {
                Logger.getLogger(nombre + Impresoras_B.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    }
    
    
}
