package actividadimpresoras;

import java.util.concurrent.Semaphore;

public class Imprenta {

    public static void main(String[] args) {
        Semaphore S1 = new Semaphore(1);
        Impresoras_A IA = new Impresoras_A(S1,"Impresora A",5);
        Impresoras_B IB = new Impresoras_B(S1,"Impresora B",4);
        
        
        IA.start();
        IB.start();
     
    }
    
    
}
