package actividadimpresoras;

import java.util.concurrent.Semaphore;

public class Imprenta {

    public static void main(String[] args) {
        Semaphore SA = new Semaphore(1);
        Semaphore SB = new Semaphore(1);
        Proceso PA = new Proceso(SA,"Proceso A");
        Proceso PB = new Proceso(SB,"Proceso B");
        ProcesoAB AB = new ProcesoAB(SA,SB,"Proceso AB");
        
        PA.start();
        PB.start();
        AB.start();
    }
    
    
}
