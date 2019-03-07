using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VentaBoletos
{
    public class Carrito
    {
        public double SubTotal { get; private set; }

        public List<Dictionary<Boleto, int>> Lista { get; private set; }

        public Carrito()
        {
            Lista = new List<Dictionary<Boleto, int>>();
            SubTotal = 0;
        }


        public void Agregar(Boleto pBoleto, int pCantidad)
        {
            // Establece el subtotal de ésta compra
            SubTotal = pBoleto.Precio * pCantidad;

            Lista.Add(new Dictionary<Boleto, int>() { { pBoleto, pCantidad } });
        }

        public double ObtenerTotal(double pCargos = 0.0) => SubTotal + pCargos;
    }
}
