

/*
 * Nombre del programa: Ordenación y busqueda en arreglos
 * Autor: Luis Ángel De Santiago Guerrero
 * Última fecha de modificación: 11 de Junio de 2017
 */

public class Alumno {
    private String nombre;
    private float calificacion;

    public Alumno() {
        this.nombre = "";
        this.calificacion = 0;
    }

    public Alumno(String nombre)
    {
        this.nombre = nombre;
        this.calificacion = 0;
    }
    public float getCalificacion() {
        return calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
