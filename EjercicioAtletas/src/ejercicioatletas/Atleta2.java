package ejercicioatletas;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Atleta2 extends Thread{
    Semaphore S;
    String nombre;
    int Meta,TiempoInicio,TiempoCorrida,distancia;

    public Atleta2(Semaphore Carrera, String n,int ti) {
        this.S = Carrera;
        this.nombre = n;
        this.TiempoInicio= ti;
        this.TiempoCorrida= 0;
    }
    
    public void run(){
        Meta = 5000;
        while (Meta > 0){
            try {
                System.out.println(nombre + " - Ejecutando");
                System.out.println(nombre + " - Esperando Chicharra o disparo para empezar a correr");
                S.acquire(); //Espera
                System.out.println(nombre + " - Corriendo");
                TiempoCorrida = TiempoCorrida + 1; 
                Thread.sleep(TiempoInicio*1000); //Este proceso "dormira" durante un segundo, que en este caso seria que los demas atletas avancen 1 metro;
                System.out.println(nombre + " - Va corriendo : "+ TiempoCorrida);
                distancia= (int) Math.random();
                TiempoCorrida = TiempoCorrida + distancia; 
                Thread.sleep(1000); //Este proceso "dormira" durante un segundo, que en este caso seria que los demas atletas avancen 1 metro;
                System.out.println(nombre + " - Va corriendo : "+ TiempoCorrida);
                if (TiempoCorrida == Meta) {
                    System.out.println(nombre + "Llego a la meta ");
                }
                S.release(); //Señal
            } catch (InterruptedException ex) {
                Logger.getLogger(Atleta2.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
}
}