package ejerciciopeluqueria;

import java.util.concurrent.Semaphore;

public class Peluqueria {

    public static void main(String[] args) {
        Semaphore S1 = new Semaphore(1);
        
        Peluquero1 P1 = new Peluquero1(S1,"Juan");
        Peluquero2 P2 = new Peluquero2(S1,"Diego");
        Peluquero3 P3 = new Peluquero3 (S1,"Martin");
        Clientes C = new Clientes (S1,"Jose",5,true);
        P1.start();
        P2.start();
        P3.start();
        C.start();
       
    }
    
}
