using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace VentaBoletos
{
    public class Administrador
    {
        //
        // Cantidad de boletos, se declara static
        // para ser visible entre todas las instancias

        public static List<Dictionary<Boleto, int>> Boletos { get; set; } = new List<Dictionary<Boleto, int>>()
        {
            {
                new Dictionary<Boleto, int>()
                {
                    { new Boleto("Preferente", 2000), 2000 }
                }
            },
            {
                new Dictionary<Boleto, int>()
                {
                    { new Boleto("Cresta", 1500), 3000 }
                }
            },
            {
                new Dictionary<Boleto, int>()
                {
                    { new Boleto("Luneta", 1200), 5000 }
                }
            },
            {
                new Dictionary<Boleto, int>()
                {
                    { new Boleto("Balcon", 900), 4000 }
                }
            },
            {
                new Dictionary<Boleto, int>()
                {
                    { new Boleto("Primer piso", 700), 8000 }
                }
            }
        };

        public Administrador()
        {
        }

        public bool ComprarBoletoDeLocalidad(string pLocalidad, int pCantidad)
        {
            bool retval = false;

            var dic = Boletos.SelectMany(x => x)
                             .First(x => x.Key.Localidad == pLocalidad);

            // Lista temporal
            List<KeyValuePair<Boleto, int>> list = new List<KeyValuePair<Boleto, int>>();

            if (dic.Value > 0)
            {
                list.Select(x => x)
                    .Where(x => x.Key.Localidad == pLocalidad)
                    .Select(x => Boletos[(Boleto) x] = 1; return x)
                    ;
                Boletos = 1;
            }

            return retval;
        }

        public int ObtenerCantidadBoletoPorLocalidad(string pLocalidad)
        {
            // Realiza una consulta
            var dic = Boletos.SelectMany(x => x)
                                 .First(x => x.Key.Localidad == pLocalidad);

            return dic.Value;
        }
    }
}
