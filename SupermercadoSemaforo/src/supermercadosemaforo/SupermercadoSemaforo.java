/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package supermercadosemaforo;

import java.util.concurrent.Semaphore;

/**
 *
 * @author bruno
 */
public class SupermercadoSemaforo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Semaphore s = new Semaphore(1);
        Producto[] prods = {new Producto(50, 500, true, "Producto A"),
            new Producto(20, 300, false, "Producto B"),
            new Producto(7, 200, true, "Producto C"),
            new Producto(3, 150, false, "Producto D"),
            new Producto(0, 600, true, "Producto E")};

        Distribuidor D1 = new Distribuidor(prods, s);
        Caja C1 = new Caja(prods, 1, s);
        Caja C2 = new Caja(prods, 2, s);
        Caja C3 = new Caja(prods, 3, s);

        D1.start();
        C1.start();
        C2.start();
        C3.start();
    }

}
