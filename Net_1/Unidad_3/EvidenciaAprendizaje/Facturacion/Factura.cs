using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Facturacion
{
    public class Factura
    {
        private string NumeroPieza { get; set; }


        private string DescripcionPieza { get; set; }


        private int CantidadArticulosCompra { get; set; }


        public double PrecioArticulo { get; private set; }


        /// <summary>
        /// Al crearse una factura solicita se cree
        /// un producto, al crearse el producto, se
        /// toman los datos de éste para usarlos
        /// dentro de la clase Factura.
        /// </summary>
        /// <param name="pProducto">Producto a facturar</param>
        /// <param name="pCantidad">Cantidad de productos a comprar</param>
        public Factura(Producto pProducto, int pCantidad)
        {
            NumeroPieza = pProducto.Id;
            PrecioArticulo = pProducto.Precio;
            DescripcionPieza = pProducto.Descripcion;

            CantidadArticulosCompra = pCantidad;
        }



        /// <summary>
        /// Devuelve la cantidad de productos a comprar
        /// </summary>
        /// 
        /// <returns></returns>
        public int PedirCompra() => CantidadArticulosCompra;



        /// <summary>
        /// CalculoFactura que calcule el monto
        /// de la factura(cantidad por precio) y
        /// después devuelva ese monto como
        /// un valor double. 
        /// 
        /// Si la cantidad no es positiva, debe 
        /// establecerse en 0, si el precio por artículo 
        /// no es positivo debe establecerlo en 0.0
        /// </summary>
        /// 
        /// <returns>Devuelve el monto de la factura</returns>
        public double CalculoFactura()
        {
            double montoFactura = CantidadArticulosCompra * PrecioArticulo;

            if (CantidadArticulosCompra < 0)
            {
                montoFactura = 0;
            }
            else if (montoFactura < 0)
            {
                montoFactura = 0.0;
            }

            return montoFactura;
        }



        /// <summary>
        /// Devuelve la información del objecto producto
        /// </summary>
        /// <returns></returns>
        public void MostrarInformacion()
        {
            Console.WriteLine("\n");
            Console.WriteLine($"----INFORMACIÓN DEL ARTÍCULO----");
            Console.WriteLine($"Id del producto {NumeroPieza}");
            Console.WriteLine($"Descripción: {DescripcionPieza}");
            Console.WriteLine($"Precio: ${PrecioArticulo.ToString("F")}");
            Console.WriteLine($"--------------------------------");
            Console.WriteLine($"Cantidad de artículos: {PedirCompra()}");
            Console.WriteLine($"Monto de la factura: ${CalculoFactura().ToString("F")}");
            Console.WriteLine($"--------------------------------");
            Console.WriteLine("\n");
        }
    }
}
