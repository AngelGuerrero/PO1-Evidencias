/*
 * Nombre del programa: Arreglos unidimensionales y multidimensionales
 * Autor: Luis Ángel De Santiago Guerrero
 * Última fecha de modificación: 4 de Junio de 2017
 */

public class Main {
    
    public static final int VENDEDORES = 12;
    
    public static void main(String[] args) {
        
        Ventas ventas = new Ventas(VENDEDORES);
        
        ventas.setVentas();
        
        ventas.mostrarVentas();
        
        System.out.println("\nLa suma de las ventas es: $" + ventas.getSuma());
        
        System.out.println("El promedio de las ventas es de: " +  ventas.getPromedio() + "%");
        
        System.out.println("La venta mínima es: $" + ventas.getVentaMinima());
        
        System.out.println("La venta máxima es: $" +  ventas.getVentaMaxima());
    }
    
}
