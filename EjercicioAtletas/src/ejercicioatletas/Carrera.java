package ejercicioatletas;

import java.util.concurrent.Semaphore;

public class Carrera {

    public static void main(String[] args) {
        Semaphore Carrera = new Semaphore(1);
        Atleta1 A1 = new Atleta1(Carrera, "Juan",0);
        Atleta2 A2 = new Atleta2(Carrera, "Marcos",0);
        Atleta3 A3 = new Atleta3(Carrera,"Julian",0);
        Atleta4 A4 = new Atleta4(Carrera,"Matias",0);
        
        A1.start();
        A2.start();
        A3.start();
        A4.start();
    }
    
}
