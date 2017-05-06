
import java.util.Scanner;

/*
 * Nombre del programa: Operaciones con arreglos
 * Autor: Luis Ángel De Santiago Guerrero
 * Última fecha de modificación: 6 de Junio de 2017
 */

public class Main {
    
    public static Scanner scanner = new Scanner(System.in);
    
    public static int vendedores = 12;
    
    public static String[] semana = {"Sábado", "Domingo"};
    
    public static int[][] tabla;
    
    // Variable para saber si se ha ingresado correctamente enteros
    public static boolean pasa;
    
    public static void main(String[] args) {
        
        Ventas ventas = new Ventas(vendedores);
        
        ventas.setVentas();
        
        ventas.mostrarVentas();
        
        System.out.println("\nLa suma de las ventas es: $" + ventas.getSuma());
        
        System.out.println("El promedio de las ventas es de: " +  ventas.getPromedio() + "%");
        
        System.out.println("La venta mínima es: $" + ventas.getVentaMinima());
        
        System.out.println("La venta máxima es: $" +  ventas.getVentaMaxima());
        
        
        // Actividad 2, Operaciones con arreglos
        // Se pretende leer las ventas del día de 3 vendedores, de los días
        // Sábado y domingo
        
        vendedores = 3;
        
        tabla = new int[vendedores][semana.length];
        
        // 1. Operación de lectura
        for (int i = 0; i < tabla.length; i++) 
        {
            System.out.printf("\nIngrese las ventas para el trabajador #%d\n", i + 1);
            
            int j = 0;
            while (j < tabla[i].length)
            {
                System.out.printf("Ganancia del día %s: " , semana[j]);
                
                try 
                {
                    tabla[i][j] = scanner.nextInt();
                    pasa = true;
                } 
                catch (Exception e) 
                {
                    scanner.next();
                    System.out.println("Ingresa únicamente enteros");
                    pasa = false;
                }
                finally
                {
                    if (pasa) 
                    {
                        j++;
                    }
                }
            }
        }
        
        // 2. Operación de escritura y asignación de datos
        int suma = 0;
        System.out.println("Los datos ingresados fueron: ");
        
        for (int i = 0; i < tabla.length; i++) 
        {
            System.out.printf("\nVentas del trabajador %d\n", (i + 1));
            
            for (int j = 0; j < tabla[i].length; j++) 
            {
                System.out.printf("Día %s: $%d \n", semana[j], tabla[i][j]);
                suma += tabla[i][j];
            }
        }
        
        System.out.println("La suma de las últimas ventas fueron: " + suma);
        float promedio;
        promedio = (suma / (tabla.length * tabla[vendedores - 1].length));
        
        System.out.println("El promedio es: $" + promedio);
    }
    
}
