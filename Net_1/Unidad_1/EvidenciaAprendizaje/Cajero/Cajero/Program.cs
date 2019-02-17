using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cajero
{
  //
  // Programa para calcular la formula general
  // Autor: Luis Ángel De Santiago Guerrero
  // Semestre: Quinto semestre
  // Unidad 1, Evidencia de aprendizaje
  // Programación NET I
  // Docente: ELVIA SANCHEZ MAGADAN
  // Grupo: DS-DPRN1-1901-B1-002
  // Ingeniería en Desarrollo de Software
  //
  class Program
  {
    static void Main(string[] args)
    {
      //Realiza una instancia de la clase
      Cajero cajero = new Cajero(10_452.36);

      bool ok = true;
      int cantidad = 0;

      // Hace una validación hasta que el formato de entrada sea el correcto
      do
      {
        try
        {
          Console.Write("Ingrese la cantidad a retirar: ");
          cantidad = Int32.Parse(Console.ReadLine());
          ok = true;
        }
        catch (Exception e)
        {
          Console.WriteLine("Ingresa únicamente digitos enteros.");
          ok = false;
        }
      } while (!ok);


      // Verifica el saldo de la cuenta actual
      if (cajero.validarSaldo(cantidad))
      {
        // Verifica que la entrada de cantidades corresponda con un formato definido
        // es decir, si se ingresa 51, mostrará un mensaje y se saldrá del programa
        Dictionary<int, int> denominaciones =  cajero.retirar(cantidad);

        bool isEmpty = true;
        foreach (var item in denominaciones)
        {
          if (item.Value != 0)
          {
            isEmpty = false;
          }
        }

        if (!isEmpty)
        {
          Console.WriteLine("Retiro exitoso.");
          foreach (var item in denominaciones)
          {
            if (item.Value != 0)
            {
              Console.WriteLine($"Denominación: {item.Key} pesos, cantidad: {item.Value}\n");
            }
          }
          Console.WriteLine($"Saldo total: {cajero.Saldo}");
        }
        else
        {
          Console.WriteLine($"Ingrese denominaciones de 50, 100, 200 y 500");
        }
      }
      else
      {
        Console.WriteLine("La cantidad a retirar es mayor a lo que se dispone de fondos.");
      }

      Console.ReadLine();
    }
  }
}
