

/*
 * Nombre del programa: Evidencia de aprendizaje
 * Autor: Luis Ángel De Santiago Guerrero
 * Última fecha de modificación: 26 de Mayo del 2017
 */

public class Main {

    public static void main(String[] args) {
        
        // Objetos de la clase 'Person'
        Person angel;
        Person jose;
        
        // Toman la forma de su respectiva clase
        angel = new Student("Ángel");
        jose = new Professor("José");
        
        // La función recibe un parámetro de la clase 'Person'
        // y se le pasa una subclase, para que así pueda actuar
        // el polimorfismo
        showOccupation(angel);
        showOccupation(jose);

    }
    
    public static void showOccupation(Person person)
    {
        System.out.println("Occupation: " + person.getOccupation());
    }
    
}
