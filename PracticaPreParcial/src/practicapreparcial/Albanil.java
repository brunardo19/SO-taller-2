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
public class Albanil extends Thread {

    Semaphore s1;
    Semaphore s2;

    public Albanil(Semaphore s1, Semaphore s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Albanil: " + "Esperando balde lleno");
                s1.acquire();
                System.out.println("Albanil: " + "Bajando balde vacio");
                s2.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Albanil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
