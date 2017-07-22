/**
 * @Author: Luis Ángel De Santiago Guerrero <angelguerrero>
 * @Date:   2017-07-25T22:08:41-05:00
 * @Email:  _angelguerrero_@outlook.com
 * @Filename: DynamicMemory.java
 * @Last modified by:   angelguerrero
 * @Last modified time: 2017-07-30T17:07:52-05:00
 * @License: MIT
 */



package tda;

import static java.lang.Integer.parseInt;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class DynamicMemory {

  public Scanner scanner = new Scanner(System.in);

  public DoublyLinkedList doublylist = new DoublyLinkedList();

  public Stack stack = new Stack();

  public Queue queue = new Queue();


  public static void main(String[] args) {
    DynamicMemory program = new DynamicMemory();
    program.menu();
  }

  public void menu()
  {
    int choice = 0;
    String options =
      "0.-Salir\n" +
      "1.-Estructura Lista enlazada doble\n" +
      "2.-Estructura Pila\n" +
      "3.-Estructura Cola";

    do {
      choice = input(options);
    } while (choice == -1);

    switch (choice)
    {
      case 0: System.exit(0);
      break;

      case 1: dllMenu();
      break;

      case 2: stackMenu();
      break;

      case 3: queueMenu();
      break;
    }
  }

  public void dllMenu()
  {
    int choice = 0;
    int n = 0;

    String options =
      "0.-Salir\n" +
      "1.-Agregar elemento\n" +
      "2.-Agregar al inicio\n" +
      "3.-Mostrar lista\n" +
      "4.-Mostrar de reverso\n" +
      "5.-Eliminar elemento\n" +
      "6.-Eliminar primer elemento\n" +
      "7.-Eliminar último elemento\n" +
      "8.-Eliminar la lista";

    do {
      choice = input(options);
    } while (choice < 0 && choice > 8);

    switch (choice) {
      case 0: menu(); break;

      case 1: {

        do {
          n = input("Ingresa un valor");
        } while (n == -1);

        doublylist.add(n);
        dllMenu();
      } break;

      case 2: {
        do {
          n = input("Ingresa un valor para agregar al inicio");
        } while (n == -1);

        doublylist.addFirst(n);
        dllMenu();
      } break;

      case 3: {
        JOptionPane.showMessageDialog(null, doublylist.show(), "Lista enlazada doble", JOptionPane.INFORMATION_MESSAGE);
        dllMenu();
      } break;

      case 4: {
        JOptionPane.showMessageDialog(null, doublylist.showReverse(), "Lista enlazada doble de reverso", JOptionPane.INFORMATION_MESSAGE);
        dllMenu();
      } break;

      case 5: {
        do {
          n = input("Ingresa el índice a eliminar");
        } while (n == -1);

        JOptionPane.showMessageDialog(null, doublylist.remove(n), "Borrando índice " + n, JOptionPane.INFORMATION_MESSAGE);
        dllMenu();
      } break;

      case 6: {
        JOptionPane.showMessageDialog(null, doublylist.removeFirst(), "Borrando primer elemento de la lista", JOptionPane.INFORMATION_MESSAGE);
        dllMenu();
      } break;

      case 7: {
        JOptionPane.showMessageDialog(null, doublylist.removeLast(), "Borrando el último elemento de la lista", JOptionPane.INFORMATION_MESSAGE);
        dllMenu();
      } break;

      case 8: {
        JOptionPane.showMessageDialog(null, doublylist.removeAll(), "Borrando toda la lista", JOptionPane.INFORMATION_MESSAGE);
        dllMenu();
      } break;
    }
  }

  public void stackMenu()
  {
    int choice = 0;
    int n = 0;
    String options =
    "0.- Salir\n" +
    "1.-Agregar elemento\n" +
    "2.-Mostrar elementos\n" +
    "3.-Obtener el de la cima\n" +
    "4.-Obtener tamaño\n" +
    "5.-Eliminar un elemento\n" +
    "6.-Eliminar la pila";

    do {
      choice = input(options);
    } while (choice < 0 && choice > 6);

    switch (choice)
    {
      case 0: menu(); break;

      case 1: {
        do {
          n = input("Ingrese un valor");
        } while (n == -1);

        stack.push(n);
        stackMenu();
      } break;

      case 2: {
        JOptionPane.showMessageDialog(null, stack.show());
        stackMenu();
      } break;

      case 3: {
        JOptionPane.showMessageDialog(null, stack.getTop());
        stackMenu();
      } break;

      case 4: {
        JOptionPane.showMessageDialog(null, stack.getSize());
        stackMenu();
      } break;

      case 5: {
        JOptionPane.showMessageDialog(null, stack.pop());
        stackMenu();
      } break;

      case 6: {
        JOptionPane.showMessageDialog(null, stack.removeAll());
        stackMenu();
      }
    }
  }

  public void queueMenu()
  {
    int choice = 0;
    int n = 0;
    String options =
    "0.-Salir\n" +
    "1.-Agregar a la cola\n" +
    "2.-Mostrar cola\n" +
    "3.-Obtener tamaño de la cola\n" +
    "4.-Eliminar la cola\n" +
    "5.-Procesar";

    do {
      choice = input(options);
    } while (choice < 0 && choice > 5);

    switch (choice) {
      case 0: menu(); break;

      case 1: {
        do {
          n = input("Ingresa un elemento a la cola");
        } while (n == -1);

        queue.add(n);

        queueMenu();
      } break;

      case 2: {
        JOptionPane.showMessageDialog(null, queue.show(), "Elementos de la cola", JOptionPane.INFORMATION_MESSAGE);
        queueMenu();
      } break;

      case 3: {
        JOptionPane.showMessageDialog(null, "El tamaño de la cola es: " + queue.getSize() + " elementos", "Tamaño de la cola", JOptionPane.INFORMATION_MESSAGE);
        queueMenu();
      } break;

      case 4: {
        JOptionPane.showMessageDialog(null,  queue.removeAll());
        queueMenu();
      } break;

      case 5: {
        JOptionPane.showMessageDialog(null, queue.process(), "Procesando", JOptionPane.INFORMATION_MESSAGE);
        queueMenu();
      } break;
    }
  }

  private int input(String message)
  {
    int choice = 0;
    String response;

    do {

      response = JOptionPane.showInputDialog(message);
       try
       {
         choice = parseInt(response);
       }
       catch (NumberFormatException e)
       {
         JOptionPane.showMessageDialog(null, "Ingresa sólo números");
         choice = -1;
       }

    } while (choice == -1);

    return choice;
  }
}
