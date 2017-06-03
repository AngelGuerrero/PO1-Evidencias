/*
 * Nombre del programa: Manejo de excepciones
 * Autor: Luis Ángel De Santiago Guerrero
 * Última fecha de modificación: 1 de Junio de 2017
 */
package dpo1_u3_a3_ladg;

/**
 * Clase final donde no se puede derivar a partir de ésta
 */
public class Student extends Person {
    
    // Attributes
    private int id;

    // Constructor
    public Student(String name)
    {
        super(name);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getName() 
    {
        return name;
    }
    
    @Override
    public void setName(String name)
    {
        this.name = name;
    }
    
    @Override
    public String getOccupation()
    {
        return "Student";
    }
    
    @Override
    public void setOccupation(String occupation)
    {
        this.occupation = occupation;
    }
    
}
