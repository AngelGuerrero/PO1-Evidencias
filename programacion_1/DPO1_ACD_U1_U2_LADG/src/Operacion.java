/*
 * Nombre del programa: Asignación a cargo del docente unidad 1
 * Autor: Luis Ángel De Santiago Guerrero
 * Última fecha de modificación: 
 */

public class Operacion {
    // Atributos
    private float x = 0;
    private float y = 0;

    // Constructor
    public Operacion(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    // Métodos
    
    public void suma()
    {
        System.out.printf("La suma de %f + %f es: %f \n", this.x, this.y, (this.x + this.y));
    }
    
    public void resta()
    {
        System.out.printf("La resta de %f - %f es: %f \n", this.x, this.y, (this.x - this.y));
    }
    
    public void multiplicacion()
    {
        System.out.printf("La multiplicación de %f * %f es: %f \n", this.x, this.y, (this.x * this.y));
    }
    
    public void division()
    {
        System.out.printf("La división de %f / %f es: %f \n", this.x, this.y, (this.x / this.y));
    }
}
