package tda;

public class Stack {
  // Attributes
  private Node top;
  private int size;

  // Stack Constructor
  public Stack()
  {
    top = null;
    size = 0;
  }

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

  public String getTop()
  {
    String val = "Pila vacía";

    if (!isEmpty())
    {
      val = "El elemento de la cima es: " + top.getData();
    }

    return val;
  }

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
