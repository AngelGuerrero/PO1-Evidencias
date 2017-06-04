/*
 * Nombre del programa: Evidencia de aprendizaje
 * Autor: Luis Ángel De Santiago Guerrero
 * Última fecha de modificación: 26 de Mayo de 2017
 */



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
