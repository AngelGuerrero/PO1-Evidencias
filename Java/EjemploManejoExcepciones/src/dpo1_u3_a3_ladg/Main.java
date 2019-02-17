package dpo1_u3_a3_ladg;

import java.util.Scanner;

/*
 * Nombre del programa: Manejo de excepciones
 * Autor: Luis Ángel De Santiago Guerrero
 * Última fecha de modificación: 1 de Junio de 2017
 */

public class Main {
    
    public static int idStudent = 0;
    
    // Objetos de la clase 'Person'
    public static Person angel;
    public static Person jose;
    
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
 
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
        
        // Ahora se pide que se ingrese la matricula alumno
        // Se pide que ingrese únicamente números
        System.out.printf("Ingresa la matricula del alumno: ");
        try {
            idStudent = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Ingresa únicamente números enteros");
        }
        
        // 'casting' para poder acceder a los métodos de la clase Student
        ((Student) angel).setId(idStudent);
        
        System.out.println("El identificador del estudiante es: " + ((Student) angel).getId());
    }
    
    public static void showOccupation(Person person)
    {
        System.out.println("Occupation: " + person.getOccupation());
    }
    
}
