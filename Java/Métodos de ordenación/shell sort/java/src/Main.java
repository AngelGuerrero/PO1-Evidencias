import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] lista = {78, 6, 98, 54, 47, 1, 0, 15, 3, 46, 55, 97, 100, 200, 41, 50, 634, 975, 648, 264, 66, 49, 10};
        System.out.println("Lista desordenada: \t\t\t\t\t" + Arrays.toString(lista) + "\n");

        Main app = new Main();
        app.shellSort(lista);

        System.out.println("La lista ordenada es: " + Arrays.toString(lista));
    }

    public void shellSort(int[] lista) {
        int distancia = (lista.length - 1) / 2;

        shellSort(lista, distancia);
    }

    public void shellSort(int[] lista, int distancia) {
        // Si la distancia es menor a 1, entonces termina el programa
        if (distancia < 1) {
            return;
        }

        // Establece el intervalo de separación
        int posActual = distancia;
        int posAnterior = 0;

        // Mientras la posición actual sea menor a la longitud de la lista
        while (posActual <= lista.length - 1) {
            if (lista[posActual] < lista[posAnterior]) {
                // Realizará una comparación hacia atrás de la lista
                int iterador = posActual;
                while (iterador > 0) {
                    // Verifica que el cálculo no sea menor que 0
                    if ((iterador - distancia) >= 0) {
                        int actual = lista[iterador];
                        int anterior = lista[iterador - distancia];

                        if (actual < anterior) {
                            // Se realiza el intercambio
                            int aux = actual;
                            lista[iterador] = lista[iterador - distancia];
                            lista[iterador - distancia] = actual;
                        }
                    }
                    iterador -= distancia;
                }
            }
            // Se recorren los índices
            posActual++;
            posAnterior++;
        }
        System.out.println("Ordenamiento con distancia de: " + distancia + ". \t" + Arrays.toString(lista));
        shellSort(lista, distancia / 2);
    }

}
