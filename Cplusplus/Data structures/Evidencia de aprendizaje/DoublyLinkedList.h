/**
* @Author: Luis Ángel De Santiago Guerrero
* @Date:   2017-08-01T05:08:10-05:00
* @Email:  _angelguerrero_@outlook.com
* @Filename: DoublyLinkedList.h
* @Last modified by:   Luis Ángel De Santiago Guerrero
* @Last modified time: 2017-08-04T16:10:45-05:00
* @License: MIT
*/



#pragma once
#include "NodeDoubly.h"

template <class T>
class DoublyLinkedList
{
  NodeDoubly<T> *_first;
  NodeDoubly<T> *_last;
  int _size;

public:
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

//
//  DoublyLinkedList Methods
//
template <class T>
DoublyLinkedList<T>::DoublyLinkedList()
{
  this->_first = nullptr;
  this->_last = nullptr;
  this->_size = 0;
}

// 
//  Add new element
//
template <class T>
bool DoublyLinkedList<T>::add(T data)
{
  bool val = false;

  NodeDoubly<T> *el = new NodeDoubly<T>(data);

  if (isEmpty())
  {
    _first = _last = el;

    val = true;
    this->_size++;
  }
  else
  {
    _last->next = el;
    el->prev = _last;
    _last = el;

    val = true;
    this->_size++;
  }

  return val;
}

//
//  Add an element to the top
// 
template <class T>
bool DoublyLinkedList<T>::addFirst(T data)
{
  bool val = false;

  NodeDoubly<T> *el = new NodeDoubly<T>(data);

  if (isEmpty())
  {
    _first = _last = el;

    val = true;
    this->_size++;
  }
  else
  {
    el->next = _first;
    _first->prev = el;
    _first = el;

    val = true;
    this->_size++;
  }

  return val;
}

//
//  Get all elements
//
template <class T>
T * DoublyLinkedList<T>::getAll()
{
  NodeDoubly<T> *iterator = _first;

  T *theArray = new T[this->_size];

  for (int i = 0; i < this->_size; i++)
  {
    theArray[i] = iterator->getData();
    iterator = iterator->next;
  }

  return theArray;
}

//
//  Get the data from the last element
// 
template <class T>
T DoublyLinkedList<T>::getLast()
{
  T el = T();

  if (! isEmpty() )
  {
    el = _last->getData();
  }
  
  return el;
}

//
//  Get the data from the first element
//
template <class T>
T DoublyLinkedList<T>::getFirst()
{
  T el = T();
  if (! isEmpty() )
  {
    el = _first->getData();
  }
  
  return el;
}

//
//  Get the size
//
template <class T>
int DoublyLinkedList<T>::getSize() { return this->_size; }

//
//  Remove everything
//
template <class T>
bool DoublyLinkedList<T>::removeAll()
{
  bool val = false;

  if ( ! isEmpty() )
  {
    while (_first != nullptr)
    {
      removeFirst();
    }
    val = true;
  }

  return val;
}

// 
//  Remove the last element
// 
template <class T>
bool DoublyLinkedList<T>::removeLast()
{
  bool val = false;

  if (! isEmpty() )
  {
    if (this->_size == 1)
    {
      _first = _last = nullptr;

      val = true;
      this->_size--;
    }
    else
    {
      NodeDoubly<T> *aux;

      aux = _last->prev;
      _last->prev = nullptr;
      _last = aux;
      aux = aux->next;
      _last->next = nullptr;

      delete aux;
      val = true;
      this->_size--;
    }
  }

  return val;
}

// 
//  Remove the first element
// 
template <class T>
bool DoublyLinkedList<T>::removeFirst()
{
  bool val = false;

  if (! isEmpty() )
  {
    if (this->_size == 1)
    {
      _first = _last = nullptr;

      val = true;
      this->_size--;
    }
    else
    {
      NodeDoubly<T> *aux;

      aux = _first->next;
      _first->next = nullptr;
      _first = aux;
      aux = aux->prev;
      _first->prev = nullptr;

      delete aux;
      val = true;
      this->_size--;
    }
  }

  return val;
}

// 
//  Check if the list is empty
// 
template <class T>
bool DoublyLinkedList<T>::isEmpty() { return this->_size == 0; }