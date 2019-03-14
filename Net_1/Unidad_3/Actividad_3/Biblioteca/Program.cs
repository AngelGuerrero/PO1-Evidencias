namespace Biblioteca
{
    //
    // Programa que utiliza métodos que no devuelven resultado
    //
    // Autor: Luis Ángel De Santiago Guerrero
    // Semestre: Quinto semestre
    // Unidad 3, Actividad 3
    // Programación NET I
    // Docente: ELVIA SANCHEZ MAGADAN
    // Grupo: DS-DPRN1-1901-B1-002
    // Ingeniería en Desarrollo de Software
    //
    class Program
    {
        static void Main(string[] args)
        {
            // Se agregan los libros diponibles a la bilioteca
            Libro PedroParamo            = new Libro("Pedro Páramo", "Juan Rulfo", 2);
            Libro MujerQueSabeLatin      = new Libro("Mujer que sabe latín", "Rosario Castellanos", 2);
            Libro ElLaberintoDeLaSoledad = new Libro("El laberinto de la soledad", "Octavio Paz", 1);

            //
            // Solicita préstamos, válidos e inválidos
            // no puede solicitar más de los que tiene
            // en existencia
            //
            MujerQueSabeLatin.Datos();
            MujerQueSabeLatin.Prestamo();
            MujerQueSabeLatin.Prestamo();
            MujerQueSabeLatin.Prestamo();
            MujerQueSabeLatin.Datos();
            
            //
            // Devuelve un préstamo, válidos e inválidos
            // no se puede devolver más de lo que se prestaron
            //
            MujerQueSabeLatin.Devolucion();
            MujerQueSabeLatin.Devolucion();
            MujerQueSabeLatin.Devolucion();

            System.Console.ReadLine();
        }
    }
}
