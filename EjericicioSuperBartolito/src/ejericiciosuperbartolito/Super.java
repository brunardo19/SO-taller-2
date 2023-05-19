package ejericiciosuperbartolito;

import java.util.concurrent.Semaphore;

public class Super {

    public static void main(String[] args) {
         Semaphore Canasta = new Semaphore(1);
         Caja C = new Caja(Canasta);
         Distribuidor D = new Distribuidor(Canasta);
         
         C.start();
         D.start();
    }
    
}
