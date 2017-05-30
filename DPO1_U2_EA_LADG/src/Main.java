
import java.util.Scanner;

public class Main {
    
    Scanner scanner = new Scanner(System.in);
    
    
    public static void main(String[] args) {
        Dato dato = new Dato();
        
        dato.leerDatos();
        
        System.out.println("La suma de los valores es de: " + dato.suma());
        
        System.out.println("El promedio de los valores es de: " + dato.promedio());
        
        if (dato.suma() > 1000) 
        {
            dato.setProducto(dato.suma() * 4);
        }
        else if (dato.suma() > 5000) 
        {
            dato.setProducto(dato.suma() * 3);
        }
        else if (dato.suma() > 10000) 
        {
            dato.setProducto(dato.suma() * 4);
        }
        
        System.out.println("El producto es: " + dato.getProducto());
    }
    
}
