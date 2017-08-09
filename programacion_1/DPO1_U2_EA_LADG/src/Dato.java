
import java.util.Scanner;

public class Dato {
    // Atributos
    static int[] numEntero = new int[10];
    int producto = 0;
    
    Scanner scanner = new Scanner(System.in);
    
    public Dato() {
    }
    
    // Métodos
    public void leerDatos()
    {
        for (int i = 0; i < numEntero.length; i++) {
            System.out.printf("Ingresa un valor para el número " + i + ": ");
            numEntero[i] = scanner.nextInt();
        }
    }
    
    public int suma()
    {
        int suma = 0;
        
        for (int i = 0; i < numEntero.length; i++) {
            suma+= numEntero[i];
        }
        
        return suma;
    }
    
    public float promedio()
    {
        float promedio = suma()/10;
        
        return promedio;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }
    
    
}
