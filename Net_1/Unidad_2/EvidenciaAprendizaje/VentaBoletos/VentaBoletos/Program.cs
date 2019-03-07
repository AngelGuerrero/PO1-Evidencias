using System;

//
// Programa para la simulación de venta de boletos
// Autor: Luis Ángel De Santiago Guerrero
// Semestre: Quinto semestre
// Unidad 2, Evidencia de aprendizaje
// Programación NET I
// Docente: ELVIA SANCHEZ MAGADAN
// Grupo: DS-DPRN1-1901-B1-002
// Ingeniería en Desarrollo de Software
//

namespace VentaBoletos
{
    class Program
    {
        public delegate void DelFuncion();

        public static Administrador administrador = new Administrador();

        static void Main(string[] args)
        {

            // Muestra la información de los boletos disponibles
            administrador.MostrarInformacionDeVenta();

            // Si es afirmativo va a la fución ComprarBoleto
            // si es negativa entonces llama la función confirmarCompra
            ModalPregunta("¿Desea realizar una compra? [s/n]: ", ComprarBoleto, ConfirmarCompra);

            Console.ReadLine();
        }


        /// <summary>
        /// Función modal para validar únicamente respuestas de si o no
        /// de acuerdo a ello, llama a las funciones que se le pasan como parámetros
        /// </summary>
        /// <param name="pPregunta">Pregunta que se desea realizar</param>
        /// <param name="pCallback1">Función que se ejecuta si la respuesta es afirmativa"/></param>
        /// <param name="pCallback2">Función que se ejecuta si la respuesta es negativa</param>
        private static void ModalPregunta(string pPregunta, DelFuncion pCallback1, DelFuncion pCallback2 = null)
        {
            Console.Write(pPregunta);
            switch (Console.ReadLine())
            {
                case "s":
                case "S":
                case "si":
                case "SI":
                    if (pCallback1 != null)
                    {
                        pCallback1();
                    }
                    break;
                case "n":
                case "N":
                case "no":
                case "NO":
                    if (pCallback2 != null)
                    {
                        pCallback2();
                    }
                    break;
                default:
                    ModalPregunta(pPregunta, pCallback1, pCallback2);
                    break;
            }
        }


        /// <summary>
        /// Función vacía para controlar el flujo de trabajo para el usuario
        /// en esta etapa es donde seleccionará el boleto a comprar
        /// </summary>
        public static void ComprarBoleto()
        {
            Console.Write("\nIngrese el nombre de la localidad: ");
            string localidad = Console.ReadLine();

            int cantidadBoletos = 0;

            bool ioError = false;

            try
            {
                Console.Write("\nIngrese la cantidad de boletos a comprar: ");
                cantidadBoletos = int.Parse(Console.ReadLine());
            }
            catch (Exception e)
            {
                ioError = true;
                Console.WriteLine($"\n{e.Message}\n");
            }

            if (ioError)
            {
                ComprarBoleto();
            }

            // Procede a cargar los articulos a su carrito
            double total = 0.0;
            string mensaje = "";
            if (administrador.ApartarBoleto(localidad.ToLower(), cantidadBoletos, ref total, ref mensaje))
            {
                Console.WriteLine($"\n\tBoleto tipo: {localidad}\n\tCantidad: {cantidadBoletos}\n");
                Console.WriteLine($"\tEl total a pagar es de: {total.ToString("C2")}\n");
                Console.WriteLine("------------------------------------------------------------------------\n");
            }
            else
            {
                Console.WriteLine(mensaje);
            }

            Main(null);
        }


        /// <summary>
        /// Función vacía para controlar el flujo de trabajo para el usuario
        /// en esta etapa el usuario confirma o no la transacción de la compra
        /// </summary>
        public static void ConfirmarCompra()
        {
            ModalPregunta("¿Desea confirmar la transacción? [s/n]: ", () => { administrador.ConfirmarCompra();
                                                                              administrador.MostrarInformacionDeVenta(); });
        }
    }
}
