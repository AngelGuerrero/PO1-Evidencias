using System;
using System.Collections.Generic;
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

        public Producto producto { get; private set; }


        public Factura(Producto pProducto, int pCantidad)
        {
            producto = producto;
            NumeroPieza = producto.Id;
            PrecioArticulo = producto.Precio;
            DescripcionPieza = producto.Descripcion;

            CantidadArticulosCompra = pCantidad;
        }



        /// <summary>
        /// Devuelve la cantidad de productos a comprar
        /// </summary>
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
        /// <returns></returns>
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
        public Producto MostrarInformacion() => producto;
    }
}
