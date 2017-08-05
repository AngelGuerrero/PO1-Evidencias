#pragma once
#include "NodeDoubly.h"

template <class T>
class DoublyLinkedList
{
  int _size;

public:
  NodeDoubly<T> *first;
  NodeDoubly<T> *last;

  DoublyLinkedList();
  ~DoublyLinkedList() {};

  bool add(T);
  bool addFirst(T);

  T *getAll();
  T getLast();
  T getFirst();
  int getSize();

  bool removeAll();
  bool removeLast();
  bool removeFirst();

  bool isEmpty();
};

//DoublyLinkedList Methods
template <class T>
DoublyLinkedList<T>::DoublyLinkedList()
{
  this->first = nullptr;
  this->last = nullptr;
  this->_size = 0;
}

// Add new element
template <class T>
bool DoublyLinkedList<T>::add(T data)
{
  bool val = false;

  NodeDoubly<T> *el = new NodeDoubly<T>(data);

  if (isEmpty())
  {
    first = last = el;

    val = true;
    this->_size++;
  }
  else
  {
    last->next = el;
    el->prev = last;
    last = el;

    val = true;
    this->_size++;
  }

  return val;
}

// Add an element to the top
template <class T>
bool DoublyLinkedList<T>::addFirst(T data)
{
  bool val = false;

  NodeDoubly<T> *el = new NodeDoubly<T>(data);

  if (isEmpty())
  {
    first = last = el;

    val = true;
    this->_size++;
  }
  else
  {
    el->next = first;
    first->prev = el;
    first = el;

    val = true;
    this->_size++;
  }

  return val;
}

// Get all elements
template <class T>
T * DoublyLinkedList<T>::getAll()
{
  NodeDoubly<T> *iterator = first;

  T *theArray = new T[this->_size];

  for (int i = 0; i < this->_size; i++)
  {
    theArray[i] = iterator->getData();
    iterator = iterator->next;
  }

  return theArray;
}

// Get the data from the last element
template <class T>
T DoublyLinkedList<T>::getLast()
{
  T el = T();

  if (! isEmpty() )
  {
    el = last->getData();
  }
  
  return el;
}

// Get the data from the first element
template <class T>
T DoublyLinkedList<T>::getFirst()
{
  T el = T();
  if (! isEmpty() )
  {
    el = first->getData();
  }
  
  return el;
}

// Get the size
template <class T>
int DoublyLinkedList<T>::getSize() { return this->_size; }

// Remove everything
template <class T>
bool DoublyLinkedList<T>::removeAll()
{
  bool val = false;

  if ( ! isEmpty() )
  {
    while (first != nullptr)
    {
      removeFirst();
    }
    val = true;
  }

  return val;
}

// Remove the last element
template <class T>
bool DoublyLinkedList<T>::removeLast()
{
  bool val = false;

  if (! isEmpty() )
  {
    if (this->_size == 1)
    {
      first = last = nullptr;

      val = true;
      this->_size--;
    }
    else
    {
      NodeDoubly<T> *aux;

      aux = last->prev;
      last->prev = nullptr;
      last = aux;
      aux = aux->next;
      last->next = nullptr;

      delete aux;
      val = true;
      this->_size--;
    }
  }

  return val;
}

// Remove the first element
template <class T>
bool DoublyLinkedList<T>::removeFirst()
{
  bool val = false;

  if (! isEmpty() )
  {
    if (this->_size == 1)
    {
      first = last = nullptr;

      val = true;
      this->_size--;
    }
    else
    {
      NodeDoubly<T> *aux;

      aux = first->next;
      first->next = nullptr;
      first = aux;
      aux = aux->prev;
      first->prev = nullptr;

      delete aux;
      val = true;
      this->_size--;
    }
  }

  return val;
}

// Check if the list is empty
template <class T>
bool DoublyLinkedList<T>::isEmpty() { return this->_size == 0; }