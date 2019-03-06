using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VentaBoletos
{
    public class Administrador
    {
        //
        // Cantidad de boletos, se declara static
        // para ser visible entre todas las instancias
        //
        public List<Producto> Boletos { get; set; } = new List<Producto>()
        {
            { new Producto(1, new Boleto("preferente" , 2000), 2000) },
            { new Producto(2, new Boleto("cresta"     , 2500), 3000) },
            { new Producto(3, new Boleto("luneta"     , 1200), 5000) },
            { new Producto(4, new Boleto("balcón"     , 900 ), 4000) },
            { new Producto(5, new Boleto("primer piso", 700 ), 8000) }
        };

        public static double Total { get; private set; }

        public static List<Dictionary<Producto, int>> Vendidos { get; private set; } = new List<Dictionary<Producto, int>>();

        public Administrador()
        {
        }

        public bool ComprarBoletoDeLocalidad(string pLocalidad, int pCantidad, out double pTotal)
        {
            bool retval = false;
            pTotal = 0;

            // Verifica que exista la localidad y hayan boletos disponibles
            // en relación a la cantidad que se quieren comprar
            var boleto = (from b in Boletos
                          where 1 == 1
                             && b.Boleto.Localidad == pLocalidad
                             && (b.Cantidad - pCantidad) > 0
                          select b).FirstOrDefault();

            if (boleto != null)
            {
                // Obtiene el total del precio de los boletos comprados
                pTotal = boleto.Boleto.Precio * pCantidad;

                // Actualiza la cantidad de boletos
                Boletos.Where(x => x.Boleto.Localidad == pLocalidad)
                       .First()
                       .Cantidad -= pCantidad;

                // Agrega la cantidad de boletos que se han vendido
                Vendidos.Add(new Dictionary<Producto, int>() { { boleto, pCantidad } });

                retval = true;
            }

            return retval;
        }

        public int ObtenerCantidadBoletoPorLocalidad(string pLocalidad)
        {
            int total = (from producto in Boletos
                         where producto.Boleto.Localidad == pLocalidad
                         select producto
                         ).First().Cantidad;

            return total;
        }

        public double ObtenerRecaudacionTotal()
        {
            // Obtiene la suma de todos los boletos vendidos
            // cantidad de boletos vendidos por su precio
            return Vendidos.SelectMany(vendido => vendido)
                           .Sum(item => (item.Key.Boleto.Precio * item.Value));
        }

        public void ObtenerInformacionDeVenta()
        {
            Console.WriteLine("\tINFORMACIÓN DE VENTA\n");
            Boletos.ForEach(item =>
            {
                Console.WriteLine($"\t{item.Id} {item.Boleto.Localidad} \tPrecio: '{item.Boleto.Precio.ToString("C2")}' \tDisponibles: {item.Cantidad}");
            });
            Console.WriteLine($"\n\tLa recaudación total es: {ObtenerRecaudacionTotal().ToString("C2")}\n\n");
        }
    }
}
