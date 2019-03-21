using System;

//
// Programa Evidencia de aprendizaje,
// programa para facturar un artículo vendido
//
// Autor: Luis Ángel De Santiago Guerrero
// Semestre: Quinto semestre
// Unidad 3, Evidencia de aprendizaje
// Programación NET I
// Docente: ELVIA SANCHEZ MAGADAN
// Grupo: DS-DPRN1-1901-B1-002
// Ingeniería en Desarrollo de Software
//

namespace Facturacion
{
    class Program
    {
        public static Producto producto;

        public static Factura factura;

        public delegate void DelFuncion();

        static void Main(string[] args)
        {
            Inicio();
            Console.ReadLine();
        }



        /// <summary>
        /// Es donde inicia el proceso para crear nuevos productos
        /// </summary>
        public static void Inicio()
        {
            ModalPregunta("¿Desea crear un producto? [s/n]: ", ValNombreProducto);

            ModalPregunta("¿Desea facturar? [s/n]: ", Facturar);
            
            ModalPregunta("¿Desea volver a comenzar? [s/n]: ", Inicio);
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
        /// Función para validar el nombre del producto ingresado
        /// 
        /// Utiliza la recursividad si es que ha ocurrido un error,
        /// si todo ha salido bien, pasa a la siguiente validación.
        /// </summary>
        public static void ValNombreProducto()
        {
            producto = new Producto();

            Console.Write($"Ingresa el nombre del producto: ");
            producto.Nombre = Console.ReadLine();

            if (String.IsNullOrEmpty(producto.Nombre))
            {
                Console.WriteLine($"No se puede ingresar un producto vacío");
                ValNombreProducto();
                return;
            }

            // Valida ahora el precio de producto
            ValPrecioProducto();
        }




        /// <summary>
        /// Función para validar el precio del producto.
        /// 
        /// Utiliza la recursividad si es que ha ocurrido un error,
        /// si todo ha salido bien, pasa a la siguiente validación.
        /// </summary>
        public static void ValPrecioProducto()
        {
            try
            {
                Console.Write("Ingresa el precio del producto: ");
                producto.Precio = double.Parse(Console.ReadLine());
                ValDescripcionProducto();
            }
            catch (Exception)
            {
                Console.WriteLine($"Ingresa un valor válido para el precio");
                ValPrecioProducto();
            }
        }



        /// <summary>
        /// Función para validar la descripción del producto.
        /// 
        /// Utiliza la recursividad si es que ha ocurrido un error, 
        /// si todo sale bien, pasa a la siguiente función.
        /// </summary>
        private static void ValDescripcionProducto()
        {
            Console.Write("Ingresa una descripción para el producto: ");
            producto.Descripcion = Console.ReadLine();
        }



        /// <summary>
        /// Función para facturar el producto que se está capturando.
        /// </summary>
        private static void Facturar()
        {
            int cantidad = 0;
            try
            {
                Console.Write($"Ingrese la cantidad de productos para {producto.Nombre}: ");
                cantidad = int.Parse(Console.ReadLine());
                factura = new Factura(producto, cantidad);
                factura.MostrarInformacion();
            }
            catch (Exception)
            {
                Console.WriteLine("Ingrese una cantidad válida para la cantidad de productos");
                Facturar();
            }
        }
    }
}
