using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cajero
{
  class Cajero
  {
    // Denominaciones de dinero permitidas
    public Dictionary<int, int> denominaciones { get; } = new Dictionary<int, int>()
      {
        { 500, 0 },
        { 200, 0 },
        { 100, 0 },
        { 50,  0 },
      };

    private double saldo { get; set; }

    public double Saldo { get => saldo; }

    public Cajero(double saldo)
    {
      this.saldo = saldo;
    }

    public Dictionary<int, int> retirar(int cantidad)
    {
      // Lista temporal
      List<KeyValuePair<int, int>> list = new List<KeyValuePair<int, int>>(denominaciones);

      int sum = 0;
      int restante = cantidad - sum;
      int total = 0;

      foreach (var actual in list)
      {   
        while ((sum + actual.Key) <= restante)
        {
          denominaciones[actual.Key]++;
          sum += actual.Key;
          total += actual.Key;
        }
        
        restante -= sum;
        sum = 0;
      }

      // Verifica si el total de las denominaciones que da
      // corresponden a la cantidad que se desea retirar
      if (total != cantidad)
      {
        return new Dictionary<int, int>();
      }

      this.saldo -= total;
      return denominaciones;
    }

    public bool validarSaldo(double retiro)
    {
      bool retval = true;

      if (retiro > saldo)
      {
        retval = false;
      }

      return retval;
    }

    
  }
}
