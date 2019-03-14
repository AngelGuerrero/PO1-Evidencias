using System.Threading;

namespace Biblioteca
{
    public class Console
    {
        public static void WriteLine(object pObject)
        {
            System.Console.WriteLine(pObject);
            Thread.Sleep(1000);
        }
    }
}
