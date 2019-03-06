using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VentaBoletos
{
    public class Boleto
    {
        public double Precio
        {
            get;
            private set;
        }

        public string Localidad
        {
            get;
            private set;
        }

        public Boleto(string pLocalidad, double pPrecio)
        {
            Localidad = pLocalidad;
            Precio = pPrecio;
        }
    }
}
