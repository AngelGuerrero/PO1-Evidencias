/**
 * @author Luis Ángel De Santiago Guerrero
 * @description Clase de la lista enlazada simple.
 */


public class LinkedList {

  // Attributos
  private Node first; // Nodo que apunta al primer elemento
  private Node last; // Nodo que apunta al último elemento
  private int size; // Longitud de la lista

  // Constructor
  public LinkedList() {
    this.first = null;
    this.last = null;
    this.size = 0;
  }

  public LinkedList(Node first, Node last) {
    this.first = first;
    this.last = last;
    this.size = 0;
  }

  /**
   * Método para agregar nuevos elementos a la lista,
   * agrega los elementos al final por defecto.
   * 
   * @param data Es el dato que se agregará a la lista.
   * @return Boolean Retorna verdadero si se ha agregado correctamente, 
   * y false si no.
   */
  public boolean add(String data) {
    boolean val = true;

    try {
      Node el = new Node(data, null);

      if (isEmpty()) {
        first = el;
        last = el;
        size++;
      } else {
        last.next = el;
        last = el;
        size++;
      }
    } catch (StackOverflowError e) {
      val = false;
      throw new StackOverflowError("No hay espacio suficiente para crear más elementos");
    }

    return val;
  }

  /**
   * Método para obtener los datos de la lista.
   * 
   * @return String Retorna la lista si existe, y si no, retorna un mensaje 
   * diciendo que la lista está vacía.
   */
  public String getAll() {
    String list = "Lista vacía";

    if (!isEmpty()) {
      list = "";
      Node i = first;

      int c = 1;
      while (i != null) {
        list += "[" + (c++) + "]: " + i.getData() + "\n";
        i = i.next;
      }
      list += "\n";
    }

    return list;
  }

  /**
   * Agrega un nuevo elemento al inicio de la lista.
   * 
   * @param data Elemento que se va a agregar a la lista.
   * @return Boolean Retorna verdadero si se ha agregado el elemento, 
   * y falso si falla.
   */
  public boolean addFirst(String data) {
    boolean val = true;

    try {
      Node el = new Node(data, null);

      if (isEmpty()) {
        first = last = el;
        size++;
      } else {
        el.next = first;
        first = el;
        size++;
      }
    } catch (StackOverflowError err) {
      val = false;
      throw new StackOverflowError("No hay espacio suficiente para crear más elementos");
    }

    return val;
  }

  /**
   * Agrega un elemento al final de la lista.
   * 
   * @param data Elemento que se va a agregar a la lista.
   * @return Boolean Retorna verdadero si se ha agregado el elemento, 
   * y falso si falla.
   */
  public boolean addLast(String data) {
    boolean val = true;

    try {
      Node el = new Node(data, null);

      if (isEmpty()) {
        first = last = el;
        size++;
      } else {
        last.next = el;
        last = el;
        size++;
      }
    } catch (StackOverflowError err) {
      val = false;
      throw new StackOverflowError("No hay espacio suficiente para crear más elementos");
    }

    return val;
  }

  /**
   * Elimina un elemento de la lista pasando el índice del elemento.
   * 
   * @param index Índice para saber qué elemento se debe de eliminar de la lista.
   * @return String Devuelve un mensaje si el elemento se ha eliminado 
   * correctamente y otro por defecto si no.
   */
  public String remove(int index) {
    String val = "Lista vacía";
    
    // Establece el rango para el parámetro ingresado
    // El índice del elemento no puede ser menor que cero
    // Ni tampoco puede ser mayor que la longitud de la lista
    if (index < 1 || index > size) {
      return "Índice fuera de rango";
    }
    
    // Si el elemento a eliminar es corresponde al "head"
    if (index == 1) {
      return removeFirst();
    }
    
    // Si el elemento a eliminar corresponde al último elemento
    if (index == size) {
      return removeLast();
    }
    
    // Si el índice corresponde entonces a un elemento
    // entre el inicio y el final
    System.out.println("No es ni el principio ni el final");
    
    Node prev = first;
    
    for (int i = 1; i <= size; i++) {
      if ((i + 1) == index) {
        System.out.println("El elemento previo es: " + prev.getData());
        System.out.println("El elemento a eliminar es: " + prev.next.getData());
        break;
      }
      prev = prev.next;
    }
    
    // Recupera el valor para mandar un mensaje
    val = "Elemento: " + prev.next.getData() + " eliminado correctamente.";
    
    // Eliminando el elemento de la lista
    Node target = prev.next;
    prev.next = target.next;
    
    // Elimina el elemento residuo
    target.next.next = null;
    prev.next.next = null;
    target = null;
    prev = null;
    size--;
    
    return val;
  }

  /**
   * Elimina el primer elemento de la lista.
   * 
   * @return String Devuelve un mensaje si se ha eliminado, o si está vacía. 
   */
  public String removeFirst() {
    String val = "La lista está vacía";

    if (!isEmpty()) {
      Node temp = new Node();
      temp = first.next;
      val = "Elemento: " + first.getData() + " eliminado correctamente";
      first.next = null;
      first = temp;
      temp = null; // nomina el objeto para le garbage collector
      size--;
    }

    return val;
  }

  /**
   * Elimina el último elemento de la lista.
   * 
   * @return String Devuelve un mensaje si la lista está vacía, o si el elemento
   * se ha eliminado correctamente.
   */
  public String removeLast() {
    String val = "La lista está vacía";

    if (!isEmpty()) {
      if (size != 1) {

        Node myiterator = new Node();

        myiterator = first;
        try {
          while (myiterator.next != last) {
            myiterator = myiterator.next;
          }
          val = "Elemento: " + last.getData() + " eliminado correctamente";
          last = myiterator;
          last.next = null;
          myiterator = null;
          size--;
        } catch (NullPointerException err) {
          val = "El iterador se ha salido del límite";
        }
      } else {
        val = "Elemento: " + last.getData() + " eliminado correctamente.";
        first = last = null;
        size--;
      }
    }

    return val;
  }

  /**
   * Elimina la lista completa.
   * 
   * @return String Devuelve un mensaje si la lista se ha eliminado o si está vacía.
   */
  public String removeAll() {
    String val = "La lista está vacía";

    if (!isEmpty()) {
      while (size > 0) {
        removeLast();
      }
      val = "Lista eliminada correctamente";
    }

    return val;
  }

  // Clase para saber si la lista está vacía
  public boolean isEmpty() {
    return size == 0;
  }

  private class Node {

    // Atributos
    private String data;
    public Node next;

    // Constructor
    public Node() {
      this.data = "";
      this.next = null;
    }

    public Node(String data, Node next) {
      this.data = data;
      this.next = next;
    }

    // Obtiene los datos del nodo
    public String getData() {    
      return data;
    }

    // Establece los datos para el nuevo nodo

    public void setData(String data) {
      this.data = data;
    }
    
  }

}
