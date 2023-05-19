package ejerciciopeluqueria;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Clientes extends Thread {
    Semaphore S;
    String nombre;
    int Sillas_espera;
    boolean disponible;

    public Clientes(Semaphore S1,String nombre,int SE, boolean disp) {
        this.S = S1;
        this.nombre = nombre;
        this.Sillas_espera = SE;
        this.disponible = disp;
    }


    public void run(){
        while (true){
            try {
                System.out.println(nombre + " - Ejecutando");
                System.out.println(nombre + " - Esperando Permiso");
                S.acquire(); //Espera a saber si hay asientos dispnibles en la sala de espera
                if (Sillas_espera == 10){
                    System.out.println(nombre + " - Aun no puede pasar a la peluqueria");
                    Sillas_espera = Sillas_espera - 1;
                }else{
                    System.out.println(nombre + " - Puede pasar a la peluqueria");
                    Sillas_espera = Sillas_espera + 1;
                }
                if (disponible == true){
                    System.out.println(nombre + " - Se corta el cabello");
                    disponible = false;
                    System.out.println(nombre + " - Sale de la peluqueria");
                }else{
                    System.out.println(nombre + " - Debe esperar hasta que un peluquero este disponible ");
                    System.out.println(nombre + " - Pasa a cortarse el cabello");
                    System.out.println(nombre + " - Sale de la peluqueria");
                }        
                S.release(); //Sale de la peluqueria
              
            } catch (InterruptedException ex) {
                Logger.getLogger(nombre + Peluquero1.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
}}
