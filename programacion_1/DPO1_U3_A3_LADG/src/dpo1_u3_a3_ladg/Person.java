/*
 * Nombre del programa: Manejo de excepciones
 * Autor: Luis Ángel De Santiago Guerrero
 * Última fecha de modificación: 1 de Junio de 2017
 */
package dpo1_u3_a3_ladg;


/**
 * Abstract class Person
 */
public abstract class Person {
    // Attributes
    public String name;
    public String occupation;
    
    // Design
    // -------------------------------------------------------------------------
    
    // Constructor
    public Person(String name) 
    {
        this.name = name;
    }

    public abstract String getName();

    public abstract void setName(String name);

    public abstract String getOccupation();

    public abstract void setOccupation(String occupation);
}
