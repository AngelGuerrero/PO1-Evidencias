package tda;

public class DoublyLinkedList {

  // Attributes
  private int size;       // Longitud de la lista
  private Node first;     // Apunta el primer elemento
  private Node last;      // Apunta al último elemento
  private Node iterator;  // Usado para recorrer los elementos

  // Constructor
  public DoublyLinkedList() {
    this.size = 0;
    this.first = null;
    this.last = null;
  }

  /*
  |-------------------------------------------------------------------
  | Métodos
  |-------------------------------------------------------------------
  |
  | Los siguientes son métodos pertenecientes a DoublyLinkedList
  |
  */
  public boolean add(int data) {
    boolean val = false;

    try
    {
      Node el = new Node(data, null, null);

      if (isEmpty())
      {
        first = last = el;
      }
      else
      {
        el.prev = last;
        last.next = el;
        last = el;
      }

      size++;
      val = true;

    }
    catch (OutOfMemoryError e)
    {
      System.out.println("Error: insufficient space to allocate the object: " + e.getMessage());
    }

    return val;
  }

  /**
   * Agrega un elemento al inicio de la lista
   *
   * Devuelve true si el elemento se ha almacenado y false si no.
   *
   * @param  int data          nuevo elemento a almacenar
   *
   * @return     boolean
   */
  public boolean addFirst(int data)
  {
    boolean val = false;

    try
    {
      Node el = new Node(data, null, null);

      if (isEmpty())
      {
        first = last = el;
      }
      else
      {
        el.next = first;
        first.prev = el;
        first = el;
      }
      size++;
      val = true;

    }
    catch (OutOfMemoryError e)
    {
      System.out.println("Error: insufficient space to allocate the object: " + e.getMessage());
      val = false;
    }

    return val;
  }

  /**
   * Muestra la lista
   *
   * Devuelve un mensaje con los elementos de la lista o si la lista
   * está vacía.
   *
   * @return String
   */
  public String show()
  {
    String val = "";

    if (size != 0)
    {
      iterator = first;

      while (iterator != null)
      {
        val += iterator.getData() + ", ";
        iterator = iterator.next;
      }
    }
    else
    {
      val = "Lista vacía";
    }

    return val;
  }

  /**
   * Muestra la lista de forma que el último elemento agregado
   * se muestre el principio
   *
   * Devuelve un mensaje con el resultado de la lista o si la lista
   * se encuentra vacía
   *
   * @return String
   */
  public String showReverse()
  {
    String val = "";

    if (size > 0)
    {
      iterator = last;
      while (iterator != null)
      {
        val += iterator.getData() + ", ";
        iterator = iterator.prev;
      }
    }
    else
    {
      val = "Lista vacía";
    }

    return val;
  }

  /**
   * Elimina un elemento de la lista
   *
   * Devuelve un mensaje indicando el resultado de la operación.
   *
   * @param  int index         índice del elemento a eliminar
   *
   * @return     String
   */
  public String remove(int index)
  {

    String val = "";

    if ( isEmpty() )
    {
      val = "Lista vacía";
    }
    else
    {
      if (index >= 1 && index <= size)
      {
        // Remove first element
        if (index == 0)
        {
          val = removeFirst();
        }
        // Remove last element
        else if (index == size)
        {
          val = removeLast();
        }
        // Remove another element
        else
        {
          /*
          |-------------------------------------------------------------------
          | El iterador se posiciona bajo el elemento a buscar,
          | cuando lo encuentra hace que los punteros previos y siguientes
          | salten a este mismo elemento.
          |-------------------------------------------------------------------
          */

          iterator = first;
          for (int i = 0; i < index; i++)
          {
            iterator = iterator.next;
          }

          iterator.prev.next = iterator.next;
          iterator.next.prev = iterator.prev;

          val = "Elemento: " + iterator.getData() + " eliminado";
          iterator = iterator.prev = iterator.next = null;
          size--;
        }
      }
      else
      {
        val = "El índice no coincide con ningún elemento";
      }
    }

    return val;
  }

  /**
   * Elimina el primer elemento de la lista
   *
   * Devuelve un mensaje si el elemento ha sido eliminado o no

   * @return String
   */
  public String removeFirst()
  {
    String val = "La lista está vacía";

    if (!isEmpty())
    {
      if (size == 1)
      {
        first = last = null;
      }
      else
      {
        Node temp = first;
        first = first.next;
        first.prev = null;
        temp = temp.next = null;
      }
      val = "Elemento eliminado";
      size--;
    }

    return val;
  }

  /**
   * Elimina el último elemento de la lista
   *
   * Devuelve un mensaje si el elemento ha sido eliminado o no
   *
   * @return String
   */
  public String removeLast()
  {
    String val = "La lista está vacía";

    if (!isEmpty())
    {
      if (size == 1)
      {
        first = last = null;
      }
      else
      {
        Node temp = last;
        last = last.prev;
        last.next = null;
        temp = temp.prev = null;
      }
      val = "Elemento eliminado";
      size--;
    }

    return val;
  }

  /**
   * Elimina todos los elementos de la lista
   *
   * Devuelve un mensaje indicando que la lista
   * ha sido eliminada.
   *
   * @return String
   */
  public String removeAll()
  {
    String val = "Lista vacía";

    if (size > 0)
    {
      while (first != null && last != null)
      {
        first = first.next;
        last = last.prev;
      }
      size = 0;
      val = "Lista eliminada";
    }

    return val;
  }

  public int getSize() { return size; }

  public int getFirst() { return first.getData(); }

  public int getLast() { return last.getData(); }

  public boolean isEmpty() { return size == 0; }


  /*
  |-------------------------------------------------------------------
  | Helper de clase DoublyLinkedList Nodo
  |-------------------------------------------------------------------
  |
  | La siguiente clase es un helper para realizar los nodos
  |
  */
  private class Node {
    // Attributes
    private int data;
    public Node prev;
    public Node next;

    // Constructor
    public Node()
    {
      this.prev = null;
      this.next = null;
    }

    public Node(int data, Node prev, Node next)
    {
      this.data = data;
      this.prev = prev;
      this.next = next;
    }

    // Node methods
    public int getData() { return data; }

    public void setData(int data) { this.data = data; }
  }

}
