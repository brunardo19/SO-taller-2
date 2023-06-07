/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermercadosemaforo;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruno
 */
public class Caja extends Thread {

    Producto[] prodLista;
    int cajaID;
    Semaphore s;

    public Caja(Producto[] prodLista, int cajaID, Semaphore s) {
        this.prodLista = prodLista;
        this.cajaID = cajaID;
        this.s = s;
    }

    public void cobrar(float monto, Producto tar) {
        if (tar.stock >= 0) {
            tar.stock -= 1;
            System.out.println("Caja" + cajaID + ": Se cobro " + monto);
            System.out.println("Por el producto " + tar.descripcion);
        } else {
            System.out.println("No hay Stock del producto " + tar.descripcion);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep((long) (1000 + Math.random() * 10000));
                s.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(Caja.class.getName()).log(Level.SEVERE, null, ex);
            }
            Producto tarProd = prodLista[(int) (prodLista.length * Math.random())];
            if (tarProd.canasta) {
                cobrar(((float) (tarProd.precio * 0.9)), tarProd);
            } else {
                cobrar(tarProd.precio, tarProd);
            }
            s.release();
        }
    }
}
