package ejerciciopeluqueria;

import java.util.concurrent.Semaphore;

public class Peluqueria {

    public static void main(String[] args) {
        Semaphore S1 = new Semaphore(3);
        Semaphore sillas = new Semaphore(10);

        String[] nombres = {"Cliente Juan",
            "Cliente Jorge",
            "Cliente Miguel",
            "Cliente Maria",
            "Cliente Ana",
            "Cliente Pedro",
            "Cliente Luisa",
            "Cliente Carlos",
            "Cliente Sofia",
            "Cliente Laura",
            "Cliente Gabriel",
            "Cliente Valentina"};

        for (int i = 0; i < 1000; i++) {
            Cliente C = new Cliente(sillas, S1, nombres[(int) (Math.random() * nombres.length)], 5, true);
            C.start();
        }
    }

}
