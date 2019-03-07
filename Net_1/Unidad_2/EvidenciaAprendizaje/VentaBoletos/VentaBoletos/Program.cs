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

            administrador.MostrarInformacionDeVenta();

            // Validación hasta que el formato de entrada sea correcto
            bool error = true;
            string entrada = "";
            bool respuestaAfirmativa = false;
            do
            {
                try
                {
                    Console.WriteLine("¿Desea realizar una compra? [s/n]");
                    entrada = Console.ReadLine();
                    error = ValidarRespuesta(entrada, out respuestaAfirmativa);
                }
                catch (Exception)
                {
                    Console.WriteLine($"Ingrese únicamente opciones disponibles");
                }

                if (respuestaAfirmativa)
                {
                    Console.Write("\nIngrese el nombre de la localidad: ");
                    string localidad = Console.ReadLine();
                    int cantidadBoletos = 0;
                    double total = 0.0;

                    try
                    {
                        Console.Write("\nIngrese la cantidad de boletos a comprar: ");
                        cantidadBoletos = int.Parse(Console.ReadLine());
                    }
                    catch (Exception e)
                    {
                        Console.WriteLine($"\n{e.Message}\n");
                        error = true;
                    }

                    // Hasta este punto todo ha ido correcto
                    if (administrador.ApartarBoleto(localidad.ToLower(), cantidadBoletos, out total))
                    {
                        Console.WriteLine($"\n\tBoleto tipo: {localidad}\n\tCantidad: {cantidadBoletos}\n");
                        Console.WriteLine($"\tEl total a pagar es de: {total.ToString("C2")}\n");
                    }
                }
                else
                {
                    if (!administrador.ConfirmarCompra())
                    {
                        Console.WriteLine("No se pudo efectuar la compra");
                    }

                    administrador.MostrarInformacionDeVenta();
                    break;
                }
            } while (error);

            Console.ReadLine();
        }

        private static bool ValidarRespuesta(string pRespuesta, out bool afirmativo)
        {
            bool retval = false;
            afirmativo = false;

            switch (pRespuesta)
            {
                case "s":
                case "S":
                case "si":
                case "SI":
                    afirmativo = true;
                    retval = true;
                    break;
                case "n":
                case "N":
                case "no":
                case "NO":
                    afirmativo = false;
                    retval = true;
                    break;
                default:
                    afirmativo = false;
                    retval = false;
                    break;
            }

            return retval;
        }
    }
}
