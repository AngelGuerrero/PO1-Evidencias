
import java.util.Scanner;

public class Dato 
{   
    // Atributos
    private float[] datos = new float[4];
    
    Scanner scanner = new Scanner(System.in);
    
    // Constructor
    public Dato(){
        
    }
    
    // Métodos
    public float[] getDatos() {
        return datos;
    }

    public void setDatos() {
        for (int i = 0; i < 4; i++) {
            System.out.printf("Ingresa un valor para el dato " + i + ": ");
            datos[i] = scanner.nextFloat();
        }
        System.out.println("Ingreso de datos correcto");
    }
    
    public float suma(){
        float suma = 0;
        for (int i = 0; i < datos.length; i++) {
            suma = suma + datos[i];
        }
        
        return suma;
    }
    
    public float promedio()
    {
        float promedio =  suma()/datos.length;
        
        return promedio;
    }
    
}
