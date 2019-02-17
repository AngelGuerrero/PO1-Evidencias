using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

// < 2 doble
// > 3 tripe
namespace CalculoDeHorasDeTrabajo
{
  public class Trabajador
  {
    //
    // Establece un nombre para identificar al trabajador
    public string Nombre;

    //
    // Establece las características del trabajador
    public Categoria categoria { get; set; }

    //
    // Máximo días de trabajo a la semana
    public const int MaxDiasTrabajo = 6;

    //
    // Máximo horas extra a la semana
    public const int MaxHorasExtra = 10;



    public Trabajador(string pNombre, Categoria pCategoria)
    {
      Nombre = pNombre;
      categoria = pCategoria;
    }



    //
    // Realiza el cálculo de las horas 
    // extras trabajadas en la semana
    //
    // -1 Significa que ha ocurrido un error
    //  0 Significa que todo ha salido con normalidad
    //  1 Significa que el calculo fue realizado, pero se debe de mandar un alerta
    //
    public KeyValuePair<double, int> CalcularSueldo(int pDiasTrabajo, int pHorasExtra)
    {
      double sueldo = 0;
      int estatus = 0;
      
      // 
      // Si los días son mayores a 6 no realiza el cálculo y
      // manda los valores por defecto
      if (pDiasTrabajo > MaxDiasTrabajo)
      {
        estatus = -1;
        return new KeyValuePair<double, int>(sueldo, estatus);
      }

      // Si las horas extra entran en el límite de trabajo
      if (pHorasExtra < MaxHorasExtra)
      {
        sueldo = (categoria.SueldoDia * pDiasTrabajo) + (categoria.PrecioHoraExtra * pHorasExtra);
        estatus = 0;
      }
      else
      {
        sueldo = (categoria.SueldoDia * pDiasTrabajo) + (categoria.PrecioHoraExtra * MaxHorasExtra);
        estatus = 1;
      }

      return new KeyValuePair<double, int>(sueldo, estatus);
    }
  }
}
