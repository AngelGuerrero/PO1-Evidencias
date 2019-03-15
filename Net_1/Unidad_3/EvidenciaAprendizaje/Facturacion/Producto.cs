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

        private Random rand = new Random();


        public Producto(string pNombre, double pPrecio, string pDescripcion = "")
        {
            Id = GenerarId();
            Nombre = pNombre;
            Precio = pPrecio;
            Descripcion = pDescripcion;
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
