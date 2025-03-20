/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quiz2;

import javax.swing.JOptionPane;

/**
 *
 * @author Laboratorio
 */
public class Quiz2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int cantidadProductos = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de productos a registrar: "));
        Tienda tienda = new Tienda(cantidadProductos);
        tienda.resultados();
    }

}
