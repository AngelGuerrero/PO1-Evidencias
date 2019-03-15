using System;

//
// Programa Evidencia de aprendizaje,
// programa para facturar un artículo vendido
//
// Autor: Luis Ángel De Santiago Guerrero
// Semestre: Quinto semestre
// Unidad 3, Evidencia de aprendizaje
// Programación NET I
// Docente: ELVIA SANCHEZ MAGADAN
// Grupo: DS-DPRN1-1901-B1-002
// Ingeniería en Desarrollo de Software
//

namespace Facturacion
{
    class Program
    {
        static void Main(string[] args)
        {
            Factura fac1 = new Factura(new Producto("Refresco", 13.5, "Bebida azucarada"), 2);
            fac1.CalculoFactura();
            fac1.MostrarInformacion();

            Factura fac2 = new Factura(new Producto("Jugo", 18.50, "Jugo de naranja natural"), 5);
            fac2.MostrarInformacion();

            Factura fac3 = new Factura(new Producto("Pan", 3, "Pan de dulce"), -5);
            fac3.MostrarInformacion();

            Console.ReadLine();
        }
    }
}
