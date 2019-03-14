namespace Biblioteca
{
    public class Libro
    {
        public string Titulo { get; set; }

        public string Autor { get; set; }

        // Ayudante para saber cuántos ejemplares se registraron inicialmente
        private readonly int EjemplaresEstablecidos;

        // Cantidad de ejemplares disponibles para éste libro
        public int Ejemplares { get; set; }

        // Cantidad de ejemplares que se han prestado
        public int EjemplaresPrestados { get; private set; }


        public Libro(string pTitulo, string pAutor, int pEjemplares)
        {
            Titulo = pTitulo;
            Autor = pAutor;
            Ejemplares = pEjemplares;
            EjemplaresPrestados = 0;

            EjemplaresEstablecidos = pEjemplares;
        }



        /// <summary>
        /// Método que incrementa el atributo: NumeroDeEjemplaresPrestados
        /// cada vez que se realice un préstamo del libro
        /// y por lo tanto disminuye el número de ejemplares de ese libro
        /// </summary>
        public void Prestamo()
        {
            if (Ejemplares <= 0)
            {
                Console.WriteLine($"No hay ejemplares disponibles de: '{Titulo}'.");
                return;
            }

            EjemplaresPrestados++;
            Ejemplares--;

            Console.WriteLine($"Préstamo de libro '{Titulo}' realizado.");
        }



        /// <summary>
        ///  Método que disminuye el atributo NumeroDeEjemplaresPrestados
        ///  cuando se produzca la devolución de un libro y por lo tanto,
        ///  incrementa el número de ejemplares de ese libro. Este método
        ///  imprime si se ha realizado la devolución o no se ha podido 
        ///  realizar en caso contrario.
        /// </summary>
        public void Devolucion()
        {
            if (Ejemplares >= EjemplaresEstablecidos)
            {
                Console.WriteLine($"Ya se han devuelto todos los títulos de: {Titulo}");
                return;
            }

            EjemplaresPrestados--;
            Ejemplares++;
            Console.WriteLine($"Devolución del libro '{Titulo}', correcto.");
        }



        /// <summary>
        /// Método que imprime los atributos del libro
        /// </summary>
        public void Datos()
        {
            System.Console.WriteLine("\n\n---------MOSTRANDO INFORMACIÓN DEL LIBRO--------");
            Console.WriteLine($"Título: {Titulo}");
            Console.WriteLine($"Autor: {Autor}");
            Console.WriteLine($"Ejemplares disponibles: {Ejemplares}");
            System.Console.WriteLine("------------------------------------------------\n\n");
        }

    }
}
