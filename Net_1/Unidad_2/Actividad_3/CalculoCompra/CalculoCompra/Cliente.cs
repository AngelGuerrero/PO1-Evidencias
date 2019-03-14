using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CalculoCompra
{
  public class Cliente
  {
    public string Id { get; set; }

    private Random rand = new Random();

    public Cliente()
    {
      Id = GenerarId();
    }


    //
    // Genera un id para el cliente de 10 caracteres
    //
    private string GenerarId()
    {
      const string caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

      return new string(Enumerable.Repeat(caracteres, rand.Next(10, 10))
                        .Select(s => s[rand.Next(s.Length)]).ToArray());
    }
  }
}
