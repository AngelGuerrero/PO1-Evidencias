package tda;

public class Queue {
  private Node first;
  private Node last;
  private int size;

  public Queue ()
  {
    first = null;
    size = 0;
  }

  public boolean add(int data)
  {
    boolean val = false;

    try
    {
      Node el = new Node(data);

      if ( isEmpty() )
      {
        first = last = el;
      }
      else
      {
        last.next = el;
        last = el;
      }
      val = true;
      size++;
    }
    catch (OutOfMemoryError e)
    {
      System.out.println("Error: insufficient space to allocate the object: " + e.getMessage());
    }

    return val;
  }

  public String show()
  {
    String val = "Cola vacía";

    if ( ! isEmpty() )
    {
      val = "";
      Node iterator = first;
      while (iterator != null)
      {
        val += iterator.getData() + ",";
        iterator = iterator.next;
      }
      System.out.println();
    }

    return val;
  }

  public String removeAll()
  {
    String val = "Cola vacía";

    if ( ! isEmpty() )
    {
      val = "";
      while (first != null)
      {
        val += process() + "\n";
      }
    }
    return val;
  }

  public String process()
  {
    String val = "Cola vacía";

    if ( ! isEmpty() )
    {
      if (size == 1)
      {
        val = "Elemento: " + first.getData() + " procesado";
        first = null;
      }
      else
      {
        Node temp = first;
        val = "Elemento: " + first.getData() + " procesado";
        first = first.next;
        temp.next = null;
      }
      System.out.println(size);
      size--;
    }
    return val;
  }

  public int getSize() { return size; }

  public boolean isEmpty() { return size == 0; }


  private class Node {
    private int data;
    public Node next;

    // Node constructor
    public Node(int data) {
      this.data = data;
      this.next = null;
    }

    public int getData() { return data; }

    public void setData(int data) { this.data = data; }
  }
}
