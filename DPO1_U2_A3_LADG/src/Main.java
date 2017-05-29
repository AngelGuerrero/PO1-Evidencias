import java.util.Scanner;

public class Main {

    // Variables globales
    static Scanner scanner = new Scanner(System.in);
    
    static float[] valores = new float[4];
    
    static String opcion = "";
    
    public static void main(String[] args)
    {
        Dato dato = new Dato();
        
        do {
        // Establece los datos
        dato.setDatos();
        
        // Obtiene los datos del array
        valores = dato.getDatos();
        
        
        System.out.println("Los valores ingresados fueron: ");
        for (int i = 0; i < valores.length; i++) {
            System.out.println(valores[i]);
        }
        
        System.out.println("La suma de los datos es de: " +  dato.suma());
        
        System.out.println("El promedio es de: " + dato.promedio());
        
        System.out.printf("Desea volver a ingresar datos [s/n]: ");
        opcion = scanner.nextLine();
        
        } while ("s".equals(opcion) || "S".equals(opcion) || "si".equals(opcion) || "SI".equals(opcion));
    }
    
}
