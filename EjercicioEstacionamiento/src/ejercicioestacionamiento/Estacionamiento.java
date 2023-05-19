package ejercicioestacionamiento;

import java.util.concurrent.Semaphore;

public class Estacionamiento {

    public static void main(String[] args) {
        Semaphore Estacionamiento = new Semaphore(10);
        Semaphore sinc = new Semaphore(0);

        int numBarreraEntrada = 2;
        int numBarreraSalida = 2;
        int i = 0;

        BarreraEntrada[] barrerasEntrada = new BarreraEntrada[numBarreraEntrada];
        BarreraSalida[] barrerasSalida = new BarreraSalida[numBarreraSalida];

        while (i < numBarreraEntrada) {
            barrerasEntrada[i] = new BarreraEntrada(Estacionamiento, sinc, i);
            barrerasEntrada[i].start();
            i++;
        }

        while (i < (numBarreraSalida + numBarreraEntrada)) {
            barrerasSalida[i - numBarreraEntrada] = new BarreraSalida(Estacionamiento, sinc, i);
            barrerasSalida[i - numBarreraEntrada].start();
        }
    }

}
