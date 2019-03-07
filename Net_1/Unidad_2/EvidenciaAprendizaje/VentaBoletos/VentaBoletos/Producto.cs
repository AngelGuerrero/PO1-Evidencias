namespace VentaBoletos
{
    public class Producto
    {
        public int Id { get; set; }

        public Boleto Boleto { get; set; }

        public int Cantidad { get; set; }

        public Producto(int pId, Boleto pBoleto, int pCantidad)
        {
            Id = pId;
            Boleto = pBoleto;
            Cantidad = pCantidad;
        }
    }
}
