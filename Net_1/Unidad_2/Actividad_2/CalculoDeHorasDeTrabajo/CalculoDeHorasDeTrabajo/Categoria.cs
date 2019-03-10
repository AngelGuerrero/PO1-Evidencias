namespace CalculoDeHorasDeTrabajo
{
  public class Categoria
  {
    public int    id              { get; set; }
    public double SueldoDia       { get; set; }
    public double PrecioHoraExtra { get; set; }

    public Categoria (int pId, double pSueldoDia, double pPrecioHoraExtra)
    {
      id = pId;
      SueldoDia = pSueldoDia;
      PrecioHoraExtra = pPrecioHoraExtra;
    }
  }
}
