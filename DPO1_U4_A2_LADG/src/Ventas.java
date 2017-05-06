import java.util.Arrays;
import java.util.Scanner;

/*
 * Nombre del programa: Operaciones con arreglos
 * Autor: Luis Ángel De Santiago Guerrero
 * Última fecha de modificación: 4 de Junio de 2017
 */

public class Ventas {
    
    // Atributos privados
    private final Scanner scanner = new Scanner(System.in);
    
    private int vendedores = 0;
    
    private final int[] ventas;
    
    
    // Constructor
    public Ventas(int total_vendedores) 
    {
        this.vendedores = total_vendedores;
        
        this.ventas = new int[this.vendedores];
    }

    // Métodos
    public void setVentas()
    {
        // Iterador para recorrer el array
        int i = 0;
        
        // Variable para saber si se ha ingresado correctamente enteros
        boolean pasa;
        
        while(i < this.ventas.length)
        {
            System.out.printf("Ingresa el total de venta para el vendedor #%d: ", i+1);
            pasa = true;
            
            try 
            {
                this.ventas[i] = scanner.nextInt();
            }
            catch (Exception e)
            {
                scanner.next();
                System.out.println("Ingresa únicamente números enteros");
                pasa = false;
            }
            finally
            {
                if (pasa)
                {
                    i++;
                }
            }
        }
        
        System.out.println("\n");
    }

    public int[] getVentas() {
        return this.ventas;
    }
    
    public void mostrarVentas()
    {
        for (int i = 0; i < this.ventas.length; i++) 
        {
            System.out.printf("El vendedor #%d hizo $%d\n", (i + 1), this.ventas[i]);
        }
    }
    
    public int getSuma()
    {
        int suma = 0;
        
        for (int i = 0; i < this.ventas.length; i++) 
        {
            suma += this.ventas[i];
        }
        
        return suma;
    }
    
    public float getPromedio()
    {
        float promedio;
        
        promedio = (getSuma() / this.ventas.length);
        
        if (promedio > 5000) 
        {
            System.out.println("El promedio de ventas a superado los $5000");
        }
        
        return promedio;
    }
    
    public void ordenar()
    {
        Arrays.sort(this.ventas);
    }
    
    public int getVentaMinima()
    {
        ordenar();
        
        int minimo;
        
        minimo = this.ventas[0];
        
        return minimo;
    }
    
    public int getVentaMaxima()
    {
        ordenar();
        
        int maxima;
        
        maxima = this.ventas[vendedores - 1];
        
        return maxima;
    }
}
