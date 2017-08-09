/**
 * @Author: Luis Ángel De Santiago Guerrero <angelguerrero>
 * @Date:   2017-07-27T13:12:34-05:00
 * @Email:  _angelguerrero_@outlook.com
 * @Filename: Queue.java
 * @Last modified by:   angelguerrero
 * @Last modified time: 2017-07-30T15:06:50-05:00
 * @License: MIT
 */



package tda;

public class Queue {
  // Attributes
  private Node first; // Nodo que apunta al primer elemento
  private Node last;  // Nodo que apunta al último elemento
  private int size;   // Longitud de la fila

  // Constructor
  public Queue ()
  {
    first = null;
    size = 0;
  }

  /**
   * Agregar un nuevo elemento a la fila
   *
   * @param  int data          elemento a agregar
   *
   * @return     boolean Devuelve true si se agrega el elemento, y
   *             false si falla.
   */
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

  /**
   * Muestra los elementos de la fila
   *
   * @return String  Devuelve los elementos en forma de String
   */
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

  /**
   * Elimina la fila completa
   *
   * @return String Devuele los elementos que han sido borrados
   */
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

  /**
   * Procesa los elementos que están al principio de la fila,
   * es decir, procesa el elemento que ha llegado primero,
   * y después lo quita de la fila
   *
   * @return String Devuelve el elemento procesado
   */
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


  /*
  |-------------------------------------------------------------------
  | Helper de clase Queue Nodo
  |-------------------------------------------------------------------
  |
  | La siguiente clase es un helper para realizar los nodos
  |
  */
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
