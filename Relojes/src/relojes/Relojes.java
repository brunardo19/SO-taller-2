/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relojes;

public class Relojes {
    
    public static void main(String[] args) {
        Reloj r1 = new Reloj(-2,"Colombia");
        Reloj r2 = new Reloj(0,"Argentina");
        Reloj r3 = new Reloj(-7,"Espania");
        r1.start();
        r2.start();
        r3.start();
    }
    
}
