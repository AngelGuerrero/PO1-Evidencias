/*
 * Nombre del programa: Evidencia de aprendizaje
 * Autor: Luis Ángel De Santiago Guerrero
 * Última fecha de modificación: 26 de Mayo de 2017
 */



public class Student extends Person {

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
