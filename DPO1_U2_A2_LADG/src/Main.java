
import java.util.Scanner;

public class Main {

    // Variables globales
    static Scanner scanner = new Scanner(System.in);
    
    // Variable para pasar como parámetro
    static double valor = 0;
    
    public static void main(String[] args) 
    {
        Figura figura = new Figura();
        
        System.out.println("Introducir la base y la altura del triángulo \n");
        System.out.printf("Ingresar la base: ");
        valor = scanner.nextDouble();
        figura.setBase(valor);
        
        System.out.printf("Ingresar la altura: ");
        valor = scanner.nextDouble();
        figura.setAltura(valor);
        
        System.out.println("El área del triángulo es: " + figura.getArea() + " unidades cuadradas");
    }
    
}
