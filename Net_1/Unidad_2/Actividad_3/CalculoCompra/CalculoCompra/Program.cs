using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

//
// Programa para calcular el total de compras
// Autor: Luis Ángel De Santiago Guerrero
// Semestre: Quinto semestre
// Unidad 2, Actividad 3
// Programación NET I
// Docente: ELVIA SANCHEZ MAGADAN
// Grupo: DS-DPRN1-1901-B1-002
// Ingeniería en Desarrollo de Software
//

namespace CalculoCompra
{
  class Program
  {
    static void Main(string[] args)
    {
      bool continuar = true;
      bool formatoOk = false;
      string respuesta = "s";
      string concepto = "";
      decimal precio = 0;

      Cliente cliente = new Cliente();
      Factura factura = new Factura(cliente);

      do
      {
        Console.Write("\nAgrega el nombre del producto: ");
        concepto = Console.ReadLine();

        //Trata de leer un formato correcto para el precio del producto
        do
        {
          try
          {
            Console.Write($"\nIngresa el precio del producto {concepto}: ");
            precio = Convert.ToDecimal(Console.ReadLine());
            formatoOk = true;
          }
          catch (Exception)
          {
            Console.WriteLine("\nEl formato ingresado no ha sido el correcto");
          }
        } while (!formatoOk);

        // Captura los datos ingresados para las instancias correspondientes
        factura.productos.Add(new Producto(concepto, precio));

        // Pregunta al usuario si desea seguir agregando
        bool valido = true;
        do
        {
          Console.Write("\n¿Desea seguir agregando productos? [s/n]: ");
          respuesta = Console.ReadLine();

          if (respuesta.Equals("s") || respuesta.Equals("S") || respuesta.Equals("si") || respuesta.Equals("SI"))
          {
            continuar = true;
            valido = true;
          }
          else if (respuesta.Equals("n") || respuesta.Equals("N") || respuesta.Equals("no") || respuesta.Equals("No"))
          {
            continuar = false;
            valido = true;
          }
          else
          {
            Console.WriteLine("\nNo se ha ingresado una opción válida.");
            valido = false;
          }
        } while (!valido);


      } while (continuar);

      factura.ImprimirRecibo();

      Console.ReadLine();
    }
  }
}
