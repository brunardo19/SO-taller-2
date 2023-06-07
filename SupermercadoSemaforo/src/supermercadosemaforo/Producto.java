/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermercadosemaforo;

/**
 *
 * @author bruno
 */
public class Producto {
    int stock;
    float precio;
    boolean canasta;
    String descripcion;

    public Producto(int stock, float precio, boolean canasta, String descripcion) {
        this.stock = stock;
        this.precio = precio;
        this.canasta = canasta;
        this.descripcion = descripcion;
    }
}
