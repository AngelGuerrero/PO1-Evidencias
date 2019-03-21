using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MetodosSiDevuelvenResultado
{
    class Program
    {
        static void Main(string[] args)
        {
            var angel = new Persona()
            {
                Nombre = "Ángel Guerrero",
                RFC = "FACDA342",
                Altura = (float)1.80,
                Edad = 25,
                Peso = 80
            };
            angel.ValidarSexo('C');
            angel.MostrarInformacion();

            var wendy = new Persona()
            {
                Nombre = "Wendy Magaña",
                RFC = "WECG323",
                Altura = (float)1.47,
                Edad = 23,
                Peso = 54
            };
            wendy.ValidarSexo('M');
            wendy.MostrarInformacion();


            var mariela = new Persona()
            {
                Nombre = "Mariela",
                RFC = "MAR2345",
                Altura = (float)1.70,
                Edad = 26,
                Peso = 40
            };
            mariela.ValidarSexo('M');
            mariela.MostrarInformacion();


            Console.ReadLine();
        }
    }
}
