/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atletas;

import java.util.concurrent.Semaphore;

/**
 *
 * @author bruno
 */
public class Atletas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Semaphore g = new Semaphore(1);
        
        //Equipo 1
        Semaphore l1 = new Semaphore(1);
        Semaphore a1 = new Semaphore(0);
        Semaphore m1 = new Semaphore(0);

        Corredor C11 = new Corredor(l1, a1, 1, 1);
        Corredor C21 = new Corredor(a1, m1, 1, 2);
        Meta Meta1 = new Meta(m1, g, 1);
        C11.start();
        C21.start();
        Meta1.start();

        
        //Equipo 2
        Semaphore l2 = new Semaphore(1);
        Semaphore a2 = new Semaphore(0);
        Semaphore m2 = new Semaphore(0);

        Corredor C12 = new Corredor(l2, a2, 2, 1);
        Corredor C22 = new Corredor(a2, m2, 2, 2);
        Meta Meta2 = new Meta(m2, g, 2);
        
        C12.start();
        C22.start();
        Meta2.start();

    }

}
