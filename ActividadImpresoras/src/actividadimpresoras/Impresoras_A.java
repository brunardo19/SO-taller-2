package actividadimpresoras;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Impresoras_A extends Thread {
    Semaphore S;
    String nombre;
    int NumA;
    int cont = 1;

    public Impresoras_A(Semaphore S1,String nombre,int Na) {
        this.S = S1;
        this.nombre = nombre;
        this.NumA = Na;
    }
    
    public void run(){
        
        while (cont <= NumA){
            try {
                System.out.println(nombre + " - Ejecutando");
                System.out.println(nombre + " - Esperando Permiso");
                S.acquire(); //Espera
                System.out.println(nombre + " - Imprimiendo");
                S.release(); //Señal
                cont = cont + 1;
            } catch (InterruptedException ex) {
                Logger.getLogger(nombre + Impresoras_A.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    }
    
    
}
