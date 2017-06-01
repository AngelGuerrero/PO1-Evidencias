/*
 * Nombre del programa:
 * Autor: Luis Ángel De Santiago Guerrero
 * Última fecha de modificación: 26 de Mayo de 2017
 */
package DPO1_U3_A2_LADG;

/**
 * Clase final donde no se puede derivar a partir de ésta
 */
final public class Student extends Person {

    // Constructor
    public Student(String name)
    {
        super(name);
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
