using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

//
// Programa para calcular el sueldo de un trabajador
// Autor: Luis Ángel De Santiago Guerrero
// Semestre: Quinto semestre
// Unidad 2, Actividad 2
// Programación NET I
// Docente: ELVIA SANCHEZ MAGADAN
// Grupo: DS-DPRN1-1901-B1-002
// Ingeniería en Desarrollo de Software
//

namespace CalculoDeHorasDeTrabajo
{
  class Program
  {
    static void Main(string[] args)
    {
      Random rand = new Random();

      KeyValuePair<double, int> catchval;

      //
      // Establece una lista de categorías
      // que se manejarán en ésta instancia
      Categoria cat1 = new Categoria(1, 600, 200);
      Categoria cat2 = new Categoria(2, 700, 250);
      Categoria cat3 = new Categoria(3, 800, 300);
      Categoria cat4 = new Categoria(4, 900, 350);

      //
      // Se crean instancias de trabajadores
      List<Trabajador> nomina = new List<Trabajador>()
      {
        new Trabajador("Wendy",   cat1),
        new Trabajador("Luis",    cat2),
        new Trabajador("Mariela", cat3),
        new Trabajador("Angel",   cat4)
      };

      foreach (var trabajador in nomina)
      {
        int dias = rand.Next(1, 10);
        int hExtra = rand.Next(0, 12);

        catchval = trabajador.CalcularSueldo(dias, hExtra);
        double sueldo = catchval.Key;
        int estatus = catchval.Value;

        Console.WriteLine($"Empleado: {trabajador.Nombre}");
        Console.WriteLine($"Categoría: {trabajador.categoria.id}");
        Console.WriteLine($"Sueldo por día: {trabajador.categoria.SueldoDia}");
        Console.WriteLine($"Precio hora extra: {trabajador.categoria.PrecioHoraExtra}\n");
        Console.WriteLine($"Dias trabajados: {dias}");
        Console.WriteLine($"Horas extra trabajadas: {hExtra}");

        switch (estatus)
        {
          case 0:
            Console.WriteLine($"Su sueldo es de: ${catchval.Key}");
            break;

          case 1:
            Console.WriteLine($"Su sueldo es de: ${catchval.Key}");
            Console.WriteLine($"Contacte con RH para revisar más de {Trabajador.MaxHorasExtra} horas extras de trabajo");
            break;

          case -1:
            Console.WriteLine($"No se puede calcular más de {dias} días de trabajo");
            break;

          default:
            Console.WriteLine($"Ha ocurrido un error inesperado");
            break;
        }

        Console.WriteLine("------------------------------------\n");
      }

      Console.ReadLine();
    }
  }
}
