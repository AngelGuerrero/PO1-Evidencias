using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VentaBoletos
{
    public class Administrador
    {

        /// <summary>
        /// Cantidad de boletos, se declara static
        /// para ser visible entre todas las instancias
        /// </summary>
        public List<Producto> Inventario { get; set; } = new List<Producto>()
        {
            { new Producto(1, new Boleto("preferente" , 2000), 2000) },
            { new Producto(2, new Boleto("cresta"     , 2500), 3000) },
            { new Producto(3, new Boleto("luneta"     , 1200), 5000) },
            { new Producto(4, new Boleto("balcón"     , 900 ), 4000) },
            { new Producto(5, new Boleto("primer piso", 700 ), 8000) }
        };


        /// <summary>
        /// Lista de artículos vendidos
        /// </summary>
        public static List<Dictionary<Boleto, int>> Vendidos { get; private set; } = new List<Dictionary<Boleto, int>>();


        /// <summary>
        /// Carrito de compra que lleva la lista de artículos seleccionados
        /// </summary>
        public static Carrito carrito { get; private set; }



        public Administrador()
        {
            carrito = new Carrito();
        }



        /// <summary>
        /// Agrega un boleto al carrito de compras si aún
        /// hay boletos disponibles en el inventario,
        /// no realiza la confirmación de la compra
        /// de inmediato, para ello es necesario confirmar
        /// la compra para ver los cambios.
        /// </summary>
        /// <param name="pLocalidad">Nombre de la localidad</param>
        /// <param name="pCantidad">Cantidad de boletos que desea comprar</param>
        /// <param name="pTotal">Parámetro de salida, el cual es el total de ésta operación</param>
        /// <returns>Retorna true si la operación se ha efectuado correctamente.</returns>
        public bool ApartarBoleto(string pLocalidad, int pCantidad, ref double pTotal, ref string pMensaje)
        {
            bool retval = false;

            Boleto boleto = null;

            try
            {
                // Verifica que exista la localidad y hayan boletos disponibles
                // en relación a la cantidad que se quieren comprar
                boleto = (from item in Inventario
                          where 1 == 1
                             && item.Boleto.Localidad == pLocalidad
                             && (item.Cantidad - pCantidad) >= 0
                          select new { Boleto = item.Boleto }).FirstOrDefault()
                                                            .Boleto;
            }
            catch (Exception)
            {
                pMensaje = "\n\n\tNO SE ENCONTRÓ LA LOCALIDAD SELECCIONADA, O YA NO EXISTEN ENTRADAS DISPONIBLES\n\n";
                return false;
            }

            //
            // Agrega el boleto al carrito de compra,
            // no se hace efectiva la compra, hasta que se confirme
            //
            carrito.Agregar(boleto, pCantidad);

            // Obtiene el total del precio de los boletos comprados
            pTotal = boleto.Precio * pCantidad;

            retval = true;

            return retval;
        }



        /// <summary>
        /// Confirma la compra de los boletos apartados,
        /// sólo que en este caso usando queries,
        /// es simplemente un método de ejemplo.
        /// 
        /// </summary>
        /// <returns>Retorna true si la operación se ha efectuado correctamente.</returns>
        public bool ConfirmarCompraUsandoQueries()
        {
            Console.WriteLine("------------------------------------------------------------------------\n");
            Console.WriteLine("\n\tSE CONFIRMÓ LA COMPRA\n\n\tDetalles de compra:\n");


            bool retval = false;

            try
            {
                // Realiza una consulta al carrito de Boletos
                var listaCompra = (from diccionario in carrito.Lista.AsQueryable()
                                   from item in diccionario
                                   from inv in Inventario
                                   where inv.Boleto == item.Key
                                   select item).ToList();


                // Actualiza el inventario
                listaCompra.ForEach(compra =>
                {
                    Console.WriteLine($"Boleto: {compra.Key.Localidad} - Unidad: {compra.Value} - Precio: {compra.Key.Precio}");

                    Inventario.Where(inv => inv.Boleto == compra.Key).ToList()
                              .ForEach(inv => inv.Cantidad -= compra.Value);
                });

                // Actualiza los artículos vendidos
                listaCompra.ForEach(x => Vendidos.Add(new Dictionary<Boleto, int>() { { x.Key, x.Value } }));

                retval = true;
            }
            catch (Exception)
            {
                retval = false;
                Console.WriteLine($"\nOCURRIÓ UN ERROR AL CONFIRMAR LA COMPRA\n");
            }

            return retval;
        }



        /// <summary>
        /// Confirma la compra de los boletos apartados
        /// </summary>
        /// <returns>Retorna true si la operación se ha efectuado correctamente.</returns>
        public bool ConfirmarCompra()
        {
            bool retval = false;

            try
            {
                Console.WriteLine("------------------------------------------------------------------------\n");
                Console.WriteLine("\n\tTICKET DE COMPRA\n\n\tDetalles de compra:\n");

                carrito.Lista.ForEach(diccionario =>
                {
                    diccionario.All(boleto =>
                    {
                        Console.WriteLine($"\tBoleto: {boleto.Key.Localidad} - Unidades: {boleto.Value} - Precio: {boleto.Key.Precio}");

                        // Agrega los carritos a la lista de productos vendidos
                        Vendidos.Add(new Dictionary<Boleto, int>() { { boleto.Key, boleto.Value } });

                        // Acutaliza restando la cantidad de boletos diponibles
                        Inventario.FindAll(item => item.Boleto == boleto.Key)
                                  .ForEach(el => el.Cantidad -= boleto.Value);

                        return true;
                    });
                });

                Console.WriteLine("------------------------------------------------------------------------\n");

                retval = true;
            }
            catch (Exception)
            {
                retval = false;
                Console.WriteLine($"\nOCURRIÓ UN ERROR AL CONFIRMAR LA COMPRA\n");
            }

            return retval;
        }



        /// <summary>
        /// Obtiene la suma de todos los boletos vendidos
        /// Realiza un cálculo de la cantidad de boletos vendidos
        /// por cada localidad y su precio
        /// </summary>
        /// <returns>Recaudación total de las ventas</returns>
        public double ObtenerRecaudacion() => Vendidos.SelectMany(vendido => vendido)
                                                      .Sum(item => (item.Key.Precio * item.Value));


        /// <summary>
        /// Obtiene el total de boletos vendidos
        /// </summary>
        /// <returns>Total de boletos vendidos</returns>
        public int ObtenerBoletosVendidos() => Vendidos.Count;


        
        /// <summary>
        /// Muestra únicamente la información de ventas
        /// </summary>
        public void MostrarInformacionDeVenta()
        {
            Console.WriteLine("\tINFORMACIÓN DE VENTA\n");
            Inventario.ForEach(item =>
            {
                Console.WriteLine($"\t{item.Id} {item.Boleto.Localidad.ToUpper()} \tPrecio: '{item.Boleto.Precio.ToString("C2")}' \tDisponibles: {item.Cantidad}");
            });
            Console.WriteLine($"\n\tLa recaudación total es: {ObtenerRecaudacion().ToString("C2")}\n\n");
        }
    }
}
