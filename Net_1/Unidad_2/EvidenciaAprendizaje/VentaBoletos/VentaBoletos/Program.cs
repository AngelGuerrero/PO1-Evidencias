using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VentaBoletos
{
    class Program
    {
        static void Main(string[] args)
        {
            Administrador administrador = new Administrador();

            int restantes = administrador.ObtenerCantidadBoletoPorLocalidad("Preferente");

            Console.WriteLine($"Restan {restantes} boletos para la localidad Preferente");

            administrador.ComprarBoletoDeLocalidad("Preferente", 100);
            Console.ReadLine();
        }
    }
}
