using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace VentaBoletos
{
    class Program
    {
        static void Main(string[] args)
        {
            Administrador administrador = new Administrador();

            // Muestra la información de boletos y precios
            administrador.ObtenerInformacionDeVenta();

            // Validación hasta que el formato de entrada sea correcto
            bool error = true;
            string entrada = "";
            bool respuesta = false;
            do
            {
                try
                {
                    Console.WriteLine("¿Desea realizar una compra? [s/n]");
                    entrada = Console.ReadLine();
                    error = ValidarRespuesta(entrada, out respuesta);
                }
                catch (Exception)
                {
                    Console.WriteLine($"Ingrese únicamente opciones disponibles");
                }

                if (respuesta)
                {
                    Console.Write("\nIngrese el nombre de la localidad: ");
                    string localidad = Console.ReadLine();
                    int boletos = 0;
                    double total = 0.0;

                    try
                    {
                        Console.Write("\nIngrese la cantidad de boletos a comprar: ");
                        boletos = int.Parse(Console.ReadLine());
                    }
                    catch (Exception e)
                    {
                        Console.WriteLine($"\n{e.Message}\n");
                        error = true;
                    }

                    // Hasta este punto todo ha ido correcto
                    if (administrador.ComprarBoletoDeLocalidad(localidad.ToLower(), boletos, out total))
                    {
                        Console.WriteLine($"\n\tBoleto tipo: {localidad}\n\tCantidad: {boletos}\n");
                        Console.WriteLine($"\tEl total a pagar es de: {total.ToString("C2")}\n");
                    }
                }
                else
                {
                    administrador.ObtenerInformacionDeVenta();
                    break;
                }
            } while (error);

            Console.ReadLine();
        }

        private static bool ValidarRespuesta(string pRespuesta, out bool afirmativo)
        {
            bool retval = false;
            afirmativo = false;

            if (Regex.Match(pRespuesta, @"[$sS$iIíÍ]").Success)
            {
                afirmativo = true;
                retval = true;
            }
            else if (Regex.Match(pRespuesta, @"[$nNoO]").Success)
            {
                afirmativo = false;
                retval = true;
            }

            return retval;
        }
    }
}
