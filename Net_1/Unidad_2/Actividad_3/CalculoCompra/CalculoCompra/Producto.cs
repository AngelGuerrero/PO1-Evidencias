using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CalculoCompra
{
  public class Producto
  {
    public string Nombre { get; set; }

    public decimal Precio { get; set; }

    public Producto(string pNombre, decimal pPrecio)
    {
      Nombre = pNombre;
      Precio = pPrecio;
    }
  }
}
