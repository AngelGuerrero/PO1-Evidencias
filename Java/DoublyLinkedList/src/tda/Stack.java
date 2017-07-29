package tda;

public class Stack {
  // Attributes
  private Node top;   // Obtiene el elemento de la cima
  private int size;   // Obtiene la longitud de la pila

  // Stack Constructor
  public Stack()
  {
    top = null;
    size = 0;
  }

  /**
   * Apila un nuevo elemento
   *
   * Devuelve true si el elemento fue agregado, y false si falla
   *
   * @param  int data          Elemento para agregar a la pila
   *
   * @return     boolean
   */
  public boolean push(int data)
  {
    boolean val = false;

    try
    {

      Node el = new Node(data);
      el.next = top;
      top = el;

      size++;
      val = true;

    }
    catch (OutOfMemoryError e)
    {
      System.out.println("Error: insufficient space to allocate the object");
    }

    return val;
  }

  /**
   * Saca un elemento de la pila
   *
   * Específicamente el elemento de la cima
   *
   * @return String     Devuelve el elemento que ha sacado
   */
  public String pop()
  {
    String val = "Pila vacía";

    if ( size > 0 )
    {
      Node temp;

      val = "Se ha sacado el elemento: " + top.getData();
      temp = top;
      top = top.next;
      size--;
    }

    return val;
  }

  /**
   * Muestra la pila
   *
   * @return String     Devuelve el contenido de la pila
   */
  public String show()
  {
    String val = "Pila vacía";

    if ( !isEmpty() )
    {
      val = "";
      Node iterator = top;
      while ( iterator != null )
      {
        val += iterator.getData() + ",";
        iterator = iterator.next;
      }
    }

    return val;
  }

  /**
   * Obtiene el elemento de la cima
   *
   * @return String
   */
  public String getTop()
  {
    String val = "Pila vacía";

    if (!isEmpty())
    {
      val = "El elemento de la cima es: " + top.getData();
    }

    return val;
  }

  /**
   * Elimina toda la lista
   *
   * @return String Devuelve un mensaje si la lista ha sido eliminada
   */
  public String removeAll()
  {
    String val = "Pila vacía";

    if ( !isEmpty() )
    {
      val = "";
      while ( top != null )
      {
        val += pop() + "\n";
      }
    }

    return val;
  }

  public boolean isEmpty() { return top == null; }

  public int getSize() { return size; }


  /*
  |-------------------------------------------------------------------
  | Helper de clase Stack Nodo
  |-------------------------------------------------------------------
  |
  | La siguiente clase es un helper para realizar los nodos
  |
  */
  private class Node {
    // Attributes
    private int data;
    public Node next;

    // Node Constructor
    public Node(int data)
    {
      this.data = data;
      this.next = null;
    }

    public int getData() { return this.data; }

    public void setData(int data) { this.data = data; }
  }
}
