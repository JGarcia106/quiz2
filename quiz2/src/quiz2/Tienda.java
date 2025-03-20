/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz2;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Laboratorio
 */
public class Tienda {

    private String[] productos;
    private int[][] ventas;
    private static int dias_semana = 7;

    public Tienda(int cantidadProductos) {
        productos = new String[cantidadProductos];
        ventas = new int[dias_semana][cantidadProductos];
        ingresarProductos();
        generarVentasRandom();
    }

    private void ingresarProductos() {
        for (int i = 0; i < productos.length; i++) {
            productos[i] = JOptionPane.showInputDialog("Ingrese el nombre del prodcuto " + (i + 1) + ":");
        }
    }

    private void generarVentasRandom() {
        Random random = new Random();
        for (int i = 0; i < dias_semana; i++) {
            for (int j = 0; j < productos.length; j++) {
                ventas[i][j] = random.nextInt(10);
            }
        }
    }

    public int[] totalVentasPorProducto() {
        int[] totalVentas = new int[productos.length];
        for (int j = 0; j < productos.length; j++) {
            for (int i = 0; i < dias_semana; i++) {
                totalVentas[j] += ventas[i][j];
            }
        }
        return totalVentas;
    }

    public int diaMayorVentas() {
        int maxVentas = 0, dia = 0;
        for (int i = 0; i < dias_semana; i++) {
            int sumaVentasDia = 0;
            for (int j = 0; j < productos.length; j++) {
                sumaVentasDia += ventas[i][j];
            }
            if (sumaVentasDia > maxVentas) {
                maxVentas = sumaVentasDia;
                dia = i;
            }
        }
        return dia;
    }

    public String productoMasVendido() {
        int[] totalVentas = totalVentasPorProducto();
        int maxVentas = 0, producto = 0;
        for (int j = 0; j < totalVentas.length; j++) {
            if (totalVentas[j] > maxVentas) {
                maxVentas = totalVentas[j];
                producto = j;
            }
        }
        return productos[producto];
    }

    public void resultados() {

        int[] totalVentas = totalVentasPorProducto();
        String mensaje = "Total de ventas por producto:\n";
        for (int i = 0; i < productos.length; i++) {
            mensaje = mensaje + productos[i] + ": " + totalVentas[i] + "\n";
        }

        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        int diaMayorVentas = diaMayorVentas();
        String productoMasVendido = productoMasVendido();

        mensaje = mensaje + "\nDía con mayores ventas: " + dias[diaMayorVentas] + "\n";
        mensaje = mensaje + "Producto más vendido: " + productoMasVendido;

        JOptionPane.showMessageDialog(null, mensaje);
    }
}
