package ejercicioatletas;

import java.util.concurrent.Semaphore;

public class Carrera {

    public static void main(String[] args) {
        Atleta A1 = new Atleta("Juan");
        Atleta A2 = new Atleta("Marcos");
        Atleta A3 = new Atleta("Julian");
        Atleta A4 = new Atleta("Matias");
        
        A1.start();
        A2.start();
        A3.start();
        A4.start();
    }
    
}
