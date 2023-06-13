/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicapreparcial;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class Cadete extends Thread {

    Semaphore s1;
    Semaphore s2;

    public Cadete(Semaphore s1, Semaphore s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Cadete: " + "Esperando balde vacio");
                s2.acquire();
                System.out.println("Cadete: " + "Subiendo balde lleno");
                s1.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Cadete.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
