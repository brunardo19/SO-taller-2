/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermercadosemaforo;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.Semaphore;

/**
 *
 * @author bruno
 */
public class Distribuidor extends Thread {

    Producto[] prodLista;
    Semaphore s;

    public Distribuidor(Producto[] prodLista, Semaphore s) {
        this.prodLista = prodLista;
        this.s = s;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(10000);
                s.acquire();
                Producto tarProd = prodLista[(int) (prodLista.length * Math.random())];
                tarProd.stock += (int) (Math.random() * 20);
                s.release();
                System.out.println("Se repuso stock del producto " + tarProd.descripcion);
            } catch (InterruptedException ex) {
                Logger.getLogger(Distribuidor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
