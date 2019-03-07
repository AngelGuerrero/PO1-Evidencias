using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CalculoCompra
{
  public class Factura
  {
    public List<Producto> productos { get; set; }

    public Cliente Cliente { get; set; }

    private decimal Total { get; set; }

    private decimal Subtotal { get; set; }


    public Factura(Cliente pCliente)
    {
      productos = new List<Producto>();
      Cliente = pCliente;
      Subtotal = 0;
      Total = 0;
    }

    
    public KeyValuePair<string, decimal> Facturar()
    {
      string mensaje = "";

      // Realiza la suma de los productos
      Total = productos.Aggregate(Total, (x, y) => x + y.Precio);

      Subtotal = Total;

      // Verifica el total de la compra para aplicar descuentos
      if (Total >= 1500 && Total <= 3000)
      {
        mensaje = "Se le aplicó un descuento del 8%";

        Total = AplicarDescuento(Total, 8);
      }
      else if (Total > 3000 && Total <= 5000)
      {
        mensaje = "Se le aplicó un descuento del 16%";

        Total = AplicarDescuento(Total, 16);
      }
      else if (Total > 5000)
      {
        mensaje = "Se le aplicó un descuento del 20%";

        Total = AplicarDescuento(Total, 20);
      }

      return new KeyValuePair<string, decimal>(mensaje, Total);
    }


    //
    // Aplica un descuento al total actual, estableciendo un porcentaje
    // como parámetro, y devuelve el total con el descuento aplicado
    //
    private decimal AplicarDescuento(decimal Total, decimal porcentaje)
    {
      decimal retval = 0;

      decimal descuento = 0;

      descuento = (Total * porcentaje) / 100;

      retval = Total - descuento;

      return retval;
    }


    //
    // Imprime únicamente los datos del cliente y su información
    //
    public void ImprimirRecibo()
    {
      Console.WriteLine("----------------------");
      Console.WriteLine($"Cliente: {Cliente.Id}\n");
      Console.WriteLine("Lista de productos:");
      foreach (var producto in productos)
      {
        Console.WriteLine($"Producto: {producto.Nombre}, Precio: {producto.Precio}");
      }
      KeyValuePair<string, decimal> fact = Facturar();

      Console.WriteLine($"Subtotal: ${Subtotal}");
      Console.WriteLine($"\n{fact.Key}");
      Console.WriteLine($"\nTotal: ${fact.Value}\n");
    }
  }
}
