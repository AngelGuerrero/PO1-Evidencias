using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Facturacion
{
    class Program
    {
        static void Main(string[] args)
        {
            Factura factura = new Factura(new Producto("Refresco", 13), 2);

            factura.CalculoFactura();

            factura.MostrarInformacion();
        }
    }
}
