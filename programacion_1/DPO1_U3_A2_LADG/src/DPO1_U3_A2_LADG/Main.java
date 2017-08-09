package DPO1_U3_A2_LADG;

/*
 * Nombre del programa: Herencia y polimorfismo fase 2
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
        
        // Se muestra el salario del profesor
        System.out.println("Professor's Salary: " + Professor.salary);
    }
    
    public static void showOccupation(Person person)
    {
        System.out.println("Occupation: " + person.getOccupation());
    }
    
}
