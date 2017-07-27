
public class DoublyLinkedList {

  // Attributes
  private int size;
  private Node first;
  private Node last;
  private Node iterator;

  // Constructor
  public DoublyLinkedList() {
    this.size = 0;
    this.first = null;
    this.last = null;
  }

  // Methods
  public boolean add(int data) {
    boolean val = false;

    try {

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

    } catch (OutOfMemoryError e) {
      System.out.println("Error: insufficient space to allocate the object: " + e.getMessage());
      val = false;
    }

    return val;
  }

  public boolean addFirst(int data)
  {
    boolean val = false;

    try {

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
        size++;
      }
      val = true;

    } catch (OutOfMemoryError e) {
      System.out.println("Error: insufficient space to allocate the object: " + e.getMessage());
      val = false;
    }

    return val;
  }

  public boolean show()
  {
    boolean val = false;

    if (size != 0)
    {
      iterator = first;

      while (iterator != null)
      {
        System.out.print(iterator.getData() + ",");
        iterator = iterator.next;
      }
      System.out.println();

      val = true;
    }

    return val;
  }

  public boolean showReverse()
  {
    boolean val = false;

    if (size > 0)
    {
      iterator = last;
      while (iterator != null)
      {
        System.out.print(iterator.getData() + ",");
        iterator = iterator.prev;
      }
      System.out.println();

      val = true;
    }

    return val;
  }

  public boolean remove(int index)
  {
    boolean val = false;

    if (index >= 0 && index <= size)
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
        iterator = first;
        for (int i = 0; i < index; i++)
        {
          iterator = iterator.next;
        }

        Node temp = iterator.prev;
        iterator.next.prev = temp;
        temp.next = iterator.next;
        temp = iterator = iterator.prev = iterator.next = null;
        size--;

        val = true;
      }
    }

    return val;
  }

  public boolean removeFirst()
  {
    boolean val = false;

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
        val = true;
      }
      size--;
    }

    return val;
  }

  public boolean removeLast()
  {
    boolean val = false;

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
        val = true;
      }
      size--;
    }

    return val;
  }

  public boolean removeAll()
  {
    boolean val = false;

    if (size > 0)
    {
      while (first != null && last != null)
      {
        first = first.next;
        last = last.prev;
      }
      size = 0;
      val = true;
    }

    return val;
  }

  public int getSize() { return size; }

  public int getFirst() { return first.getData(); }

  public int getLast() { return last.getData(); }

  public boolean isEmpty() { return size == 0; }


  /**
   * Helper class Node
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
