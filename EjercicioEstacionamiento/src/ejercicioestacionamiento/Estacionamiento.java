package ejercicioestacionamiento;

import java.util.concurrent.Semaphore;

public class Estacionamiento {

    public static void main(String[] args) {
        Semaphore Estacionamiento = new Semaphore(2);
        Semaphore sinc = new Semaphore(0);

        int numBarreraEntrada = 5;
        int numBarreraSalida = 3;
        int i = 0;
        Semaphore[] entradaSinc = new Semaphore[numBarreraEntrada + 1];

        //Array de barreras
        BarreraEntrada[] barrerasEntrada = new BarreraEntrada[numBarreraEntrada];
        BarreraSalida[] barrerasSalida = new BarreraSalida[numBarreraSalida];

        //Crear Semaforos de sincronizacion
        for (int j = 0; j < numBarreraEntrada + 1; j++) {
            entradaSinc[j] = new Semaphore(0); // Inicia con 0 permits
        }

        //Crear las barreras
        while (i < numBarreraEntrada) {
            barrerasEntrada[i] = new BarreraEntrada(Estacionamiento, sinc, entradaSinc, i);
            barrerasEntrada[i].start();
            i++;
        }

        while (i < (numBarreraSalida + numBarreraEntrada)) {
            barrerasSalida[i - numBarreraEntrada] = new BarreraSalida(Estacionamiento, sinc, i);
            barrerasSalida[i - numBarreraEntrada].start();
            i++;
        }
        
    }

}
