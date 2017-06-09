
import java.util.Scanner;

/*
 * Nombre del programa: Asignación a cargo del docente, unidad 1
 * Nombre del programa: Asignación a cargo del docente, unidad 2
 *
 * Autor: Luis Ángel De Santiago Guerrero
 * Última fecha de modificación: 1 de Junio de 2017
 */

public class Main {

    // Objeto para ingresar datos del teclado
    public static Scanner scanner = new Scanner(System.in);
    
    // variables para almacenar los datos de entrada
    public static float a = 0;
    public static float b = 0;
    
    public static int c = 0;
    
    public static void main(String[] args) {
        
    // Ejercicio que solicita la unidad 1 --------------------------------------
        System.out.println("Ingresa un valor para a: ");
        a = ingresarDatos();
        scanner.nextLine();
        
        System.out.println("Ingresa un valor para b: ");
        b = ingresarDatos();
        scanner.nextLine();
        
        Operacion operacion = new Operacion(a, b);
        
        operacion.suma();
        operacion.resta();
        operacion.multiplicacion();
        operacion.division();
        
        
    // Ejercicio que solicita de la unidad 2 -----------------------------------
    
        System.out.println("\nIngresa un número entero:  ");
        try {
            
            c = scanner.nextInt();
            
        } catch (Exception e) {
            
            System.out.println("Ingresa únicamente enteros");
            
        }
        
        for (int i = 0; i < c; i++) 
        {
            System.out.print("*");
        }
    }
    
    public static float ingresarDatos()
    {
        float x = 0;
        float temp = 0;
        
        try {
            
            x = scanner.nextFloat();
            temp = x;
            
        } catch (Exception e) {
            
            System.out.println("Ingresa únicamente caracteres");
            
        } 
        
        return temp;
    }
}
