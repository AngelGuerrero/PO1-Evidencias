using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MetodosSiDevuelvenResultado
{
    public class Persona
    {
        public string RFC { get; set; }

        public string Nombre { get; set; }

        public int Edad { get; set; }

        private char _sexo;
        public char Sexo
        {
            get => _sexo;
            private set
            {
                switch (value)
                {
                    case 'M':
                        _sexo = 'M';
                        break;
                    case 'H':
                        _sexo = 'M';
                        break;
                    default:
                        _sexo = 'H';
                        break;
                }
            }
        }

        public float Peso { get; set; }

        public float Altura { get; set; }

        public Persona()
        {

        }


        /// <summary>
        /// Hace la asignación del sexo, las validaciones se hacen desde
        /// la propiedad de Sexo.
        /// </summary>
        /// <param name="pSexo">Sexo a asignar.</param>
        public void ValidarSexo(char pSexo) => Sexo = pSexo;


        /// <summary>
        /// Simplemente hace una comparación para saber si la edad 
        /// pasada como argumento es mayor a 18 o no.
        /// </summary>
        /// <param name="pEdad">Edad a comparar</param>
        /// <returns>Devuelve verdadero si es mayor a 18</returns>
        public bool MayorEdad(int pEdad) => pEdad > 18;


        /// <summary>
        /// Calcula el peso ideal aplicando la fórmula para IMC
        /// </summary>
        /// <param name="pPeso">Peso a calcular</param>
        /// <returns>Retorna un mensaje de acuerdo al cálculo para IMC</returns>
        public string CalcularIMC(float pPeso)
        {
            float resultado = pPeso / (Altura * Altura);
            string retval = "";

            if (resultado < 18)
            {
                retval = "PESO BAJO";
            }
            else if (resultado > 18 && resultado < 25)
            {
                retval = "NORMAL";
            }
            else if (resultado > 25 && resultado < 27)
            {
                retval = "SOBREPESO";
            }
            else if (resultado > 27 && resultado < 30)
            {
                retval = "OBESIDAD GRADO I";
            }
            else if (resultado > 30 && resultado < 40)
            {
                retval = "OBESIDAD GRADO II";
            }
            else if (resultado >= 40)
            {
                retval = "OBESIDAD GRADO III";
            }
            else
            {
                retval = "Ufff...";
            }

            return retval;
        }


        /// <summary>
        /// Muestra la información de la persona.
        /// </summary>
        public void MostrarInformacion()
        {
            Console.WriteLine("\n\n===========================================");
            Console.WriteLine($"Nombre: {Nombre}");
            Console.WriteLine($"El RFC de la persona es: {RFC}");

            Console.WriteLine($"Edad: {Edad}");
            string e = MayorEdad(Edad) ? "Ya es mayor de edad" : "Es menor de edad";
            Console.WriteLine($"{e}");

            Console.WriteLine($"Sexo: {Sexo}");

            Console.WriteLine($"Su peso es: {Peso} Kg");
            Console.WriteLine($"Según el cálculo de IMC su peso es: {CalcularIMC(Peso)}");

            Console.WriteLine($"Altura: {Altura} metros");
            Console.WriteLine("===========================================\n");
        }
    }
}
