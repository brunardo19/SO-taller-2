/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package relojes;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDateTime;

/**
 *
 * @author bruno
 */
public class Reloj extends Thread {

    int hh;
    int mm;
    int ss;
    String pais;

    public Reloj(int huso, String pais) {
        this.hh = java.time.LocalDateTime.now().getHour() + huso;
        this.mm = java.time.LocalDateTime.now().getMinute();
        this.ss = java.time.LocalDateTime.now().getSecond();
        this.pais = pais;
    }

    private void mostrarHora() {
        try {
            sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Reloj.class.getName()).log(Level.SEVERE, null, ex);
        }
        ss += 1;
        if (ss >= 60) {
            mm += 1;
            ss = 0;
        }

        if (mm >= 60) {
            hh += 1;
            mm = 0;
        }

        if (hh >= 24) {
            hh = 0;
        }
        System.out.println(pais + ": " + hh + " : " + mm + " : " + ss);
    }

    @Override
    public void run() {
        while (true) {
            mostrarHora();
        }
    }
}
