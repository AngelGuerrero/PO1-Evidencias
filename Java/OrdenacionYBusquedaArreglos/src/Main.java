import java.util.Arrays;
import java.util.Scanner;

/*
 * Nombre del programa: Ordenación y busqueda en arreglos
 * Autor: Luis Ángel De Santiago Guerrero
 * Última fecha de modificación: 11 de Junio de 2017
 * 
 * El programa solicita la calificación de los alumnos, y hace una busqueda por
 * nombre de ellos.
 */

public class Main {

    public static Scanner scanner = new Scanner (System.in);

    // Crea simplemente un array de alumnos para establecer su calificación
    public static Alumno[] alumnos = new Alumno[]{ 
        new Alumno("Angel"), 
        new Alumno("Wendy"),
        new Alumno("Guadalupe"),
        new Alumno("Daniel"),
        new Alumno("Luis")
    };
    
    public static float calificaciones[][] = new float[2][alumnos.length]; // 2x5
    
    public static void main(String[] args) {
         
        
        // Establece las calificaciones
        establecerCalificaciones();
        
        copiarCalificaciones();
        
        ordenarCalificaciones();
        
        System.out.println("Las calificaciones sin ordenar son: ");
        mostrarCalificacionesSinOrdenar();
        
        System.out.println("Las calificaciones ordenadas son: ");
        mostrarCalificacionesOrdenadas();
        
        // Realiza una busqueda entre los alumnos por nombre
        buscarAlumno();
        
    } 
    
    public static void establecerCalificaciones()
    {
        float calificacion;
        int i = 0;
        boolean pasa = false;
        
        while (i < alumnos.length)
        {
            System.out.printf("Ingrese la calificación para el alumno %s: ", alumnos[i].getNombre());
            try 
            {
                calificacion = scanner.nextFloat();
                
                if (calificacion < 0 || calificacion > 10) 
                {
                    System.out.println("\nIngrese una calificación mayor a 0 y menor a 10\n");
                }
                else 
                {
                    alumnos[i].setCalificacion(calificacion);
                    pasa = true;
                }
            } 
            catch (Exception e) 
            {
                System.out.println("\nIngrese únicamente números\n");
                scanner.next();
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
    }
    
    public static void copiarCalificaciones()
    {
        // Simplemente copia las calificaciones de los alumnos en 
        // el primer índice del array de calificaciones
        
        float cal = 0;
        
        // Copia las calificaciones al índice 0 y al 1
        // En el índice 0 se encontrarán las calificaciones sin ordenar
        // En el índice 1 estarán las calificaciones ordenadas
        
        for (int i = 0; i < calificaciones[0].length; i++) 
        {
            calificaciones[0][i] = alumnos[i].getCalificacion();
        }
        
        for (int i = 0; i < calificaciones[1].length; i++) 
        {
            calificaciones[1][i] = alumnos[i].getCalificacion();
        }
    }
    
    public static void mostrarCalificacionesSinOrdenar()
    {   
        for (int i = 0; i < calificaciones[0].length; i++) 
        {
           System.out.println(calificaciones[0][i]);
        }
    }
    
    public static void mostrarCalificacionesOrdenadas()
    {
        for (int i = 0; i < calificaciones[1].length; i++) 
        {
           System.out.println(calificaciones[1][i]);
        }
    }
    
   public static void ordenarCalificaciones()
   {
       Arrays.sort(calificaciones[1]);   
   }
    
   public static void buscarAlumno()
   {
       System.out.printf("Ingrese el nombre del alumno a buscar: ");
       String nombre = scanner.next();
       
       int i = 0;
       
       for (; i < alumnos.length; i++) {
           if (nombre.equals(alumnos[i].getNombre())) {
               System.out.printf("El alumno %s tiene una calificación de %f\n", alumnos[i].getNombre(), alumnos[i].getCalificacion());
               break;
           }
       }
       
       if (i >= alumnos.length) {
           System.out.println("El alumno " + nombre + " no se ha encontrado\n");
       }
   }
}
