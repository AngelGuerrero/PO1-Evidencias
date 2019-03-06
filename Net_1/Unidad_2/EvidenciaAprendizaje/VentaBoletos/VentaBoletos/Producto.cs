using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VentaBoletos
{
    public class Producto
    {
        private int _id;
        public int Id { get => _id; set => _id = value; }

        private Boleto _boleto;
        public Boleto Boleto { get => _boleto; set => _boleto = value; }

        private int _cantidad;
        public int Cantidad { get => _cantidad; set => _cantidad = value; }

        public Producto(int pId, Boleto pBoleto, int pCantidad)
        {
            this.Id = pId;
            this.Boleto = pBoleto;
            this.Cantidad = pCantidad;
        }
    }
}
