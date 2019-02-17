using System;
using System.Collections.Generic;
using System.Linq;

namespace CalculoGeneral
{
  //
  // Programa para calcular la formula general
  // Autor: Luis Ángel De Santiago Guerrero
  // Semestre: Quinto semestre
  // Unidad 1, Actividad 3
  // Programación NET I
  // Docente: ELVIA SANCHEZ MAGADAN
  // Grupo: DS-DPRN1-1901-B1-002
  // Ingeniería en Desarrollo de Software
  //
  class Program
  {
    //Variables estática para simplificar fracción decimal
    public static int divisor = 2;

    static void Main(string[] args)
    {
      // Coeficientes de entrada
      Dictionary<String, int> coeficientes = new Dictionary<string, int>()
      {
        // Inicializa los coeficientes a cero
        { "a", 0 },
        { "b", 0 },
        { "c", 0 }
      };
      // Lista temporal
      List<KeyValuePair<String, int>> list = new List<KeyValuePair<string, int>>(coeficientes);

      foreach (KeyValuePair<String, int> item in list)
      {
        bool ok = true;

        do
        {
          try
          {
            Console.Write($"Ingresa el valor para la variable {item.Key}: ");
            int val = Int32.Parse(Console.ReadLine());

            coeficientes[item.Key] = val;

            ok = true;
          }
          catch (Exception)
          {
            Console.WriteLine($"\nEl formato ingresado no es el correcto.\n");
            ok = false;
          }
        } while (!ok);
      }

      //
      // Proceso
      //
      // Realiza primero la raíz de la operación
      double raiz = Math.Sqrt(Math.Pow(coeficientes["b"], 2) - (4 * coeficientes["a"] * coeficientes["c"]));

      // Numerador de x_1
      double x_1_num = (((-1) * coeficientes["b"]) + raiz);

      // Numerador de x_2
      double x_2_num =  (((-1) * coeficientes["b"]) - raiz);
      
      // Denominador
      int den = (2 * coeficientes["a"]);


      // Muestra el resultado para la primera X
      if (x_1_num == den)
      {
        Console.WriteLine($"\nEl resultado para x_1: {x_1_num / den}\n");
      }
      else
      {
        KeyValuePair<String, String> r_1 = simplificarFraccion(x_1_num, den);
        Console.WriteLine($"\nEl resultado para x_1: {r_1.Key}/{r_1.Value}\n");
      }


      //Muestra el resultado para la segunda X
      if (x_2_num == den)
      {
        Console.WriteLine($"El resultado para x_2: {x_2_num / den}\n");
      }
      else
      {
        KeyValuePair<String, String> r_2 = simplificarFraccion(x_2_num, den);
        Console.WriteLine($"El resultado para x_2 es: {r_2.Key}/{r_2.Value}\n");
      }

      Console.ReadLine();
    }


    // 
    // Desc Realiza una simplificación de las fracciones
    // 
    // @param double numerador Recibe para simplificar a máxima expresión
    // @param double denominador Recibe un número para simplificar a máxima expresión
    //
    // @return Regresa un clave-valor el cual es el numerador y el denominador
    //
    public static KeyValuePair<String, String> simplificarFraccion(double numerador, double denominador)
    {
      bool isNegative = numerador < 1 ? true : false;

      numerador = Math.Abs(numerador);

      double res_num = numerador / divisor;
      double res_den = denominador / divisor;

      String string_res_num = res_num.ToString();
      String string_res_den = res_den.ToString();

      //
      // Verifica si tiene punto decimal, 
      // del resultado de la anterior división
      //
      if (!string_res_num.Contains('.') && !string_res_den.Contains('.'))
      {
        simplificarFraccion(res_num, res_den);
      }
      else if (divisor == numerador || divisor == denominador || res_num <= 1 || res_den <= 1)
      {
        string_res_num = isNegative ? "-" + string_res_num : string_res_num;
        return new KeyValuePair<String, String>(string_res_num, string_res_den);
      }
      else
      {
        // Se le suma 1 al divisor
        divisor += 1;

        simplificarFraccion(numerador, denominador);
      }

      string_res_num = isNegative ? "-" + string_res_num : string_res_num;
      divisor = 2;

      return new KeyValuePair<string, String>(string_res_num, string_res_den);
    }
  }
}
