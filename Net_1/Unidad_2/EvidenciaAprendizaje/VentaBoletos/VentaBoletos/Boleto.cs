using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VentaBoletos
{
    public class Boleto
    {
        private double _precio;
        public double Precio
        {
            get => _precio;
            private set => _precio = value;
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
