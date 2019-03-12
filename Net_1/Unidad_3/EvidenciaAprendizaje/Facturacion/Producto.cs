using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Facturacion
{
    public class Producto
    {
        public string Id { get; private set; }

        public string Nombre { get; private set; }

        public double Precio { get; private set; }

        public string Descripcion { get; private set; }


        public Producto(string pNombre, double pPrecio, string pDescripcion = "")
        {
            Id = Path.GetRandomFileName().Replace(".", "");
            Nombre = pNombre;
            Precio = pPrecio;
            Descripcion = pDescripcion;
        }
    }
}
