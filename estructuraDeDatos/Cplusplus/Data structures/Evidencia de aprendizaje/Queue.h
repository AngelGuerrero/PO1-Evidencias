/**
* @Author: Luis Ángel De Santiago Guerrero
* @Date:   2017-08-01T05:08:10-05:00
* @Email:  _angelguerrero_@outlook.com
* @Filename: Queue.h
* @Last modified by:   Luis Ángel De Santiago Guerrero
* @Last modified time: 2017-08-04T16:10:45-05:00
* @License: MIT
*/



#pragma once
#include "Node.h"

template <class T>
class Queue
{
  Node<T> *_first;
  Node<T> *_last;
  int _size;
  T _data;

public:
  Queue() :
    _first(nullptr),
    _last(nullptr),
    _size(0),
    _data(T()) {}

  Queue(T data) :
    _data(data),
    _first(nullptr),
    _last(nullptr),
    _size(0) {}

  ~Queue() {}

  bool add(T);
  T getFirst();
  T process();
  int getSize();
  bool isEmpty();
  bool removeAll();
};


//
//  Add a new element to the queue
// 
template <class T>
bool Queue<T>::add(T data)
{
  bool val = false;

  Node<T> *el = new Node<T>(data);

  if ( isEmpty() )
  {
    _first = _last = el;

    val = true;
    _size++;
  }
  else
  {
    _last->next = el;
    _last = el;

    val = true;
    _size++;
  }

  return val;
}


//
//  Get the data from the first element without delete it
// 
template <class T>
T Queue<T>::getFirst()
{
  T val = T();

  if ( ! isEmpty() )
  {
    val = this->_first->getData();
  }

  return val;
}


//
//  Process an element
//  This function is like a pop(), first, get  the 'first' element 
//  and then remove this element
// 
template <class T>
T Queue<T>::process()
{
  T val = T();

  if (! isEmpty() )
  {
    if (this->_size == 1)
    {
      val = this->_first->getData();

      this->_first = this->_last = nullptr;

      this->_size--;
    }
    else
    {
      val = this->_first->getData();
      Node<T> *aux;

      aux = this->_first->next;
      this->_first->next = nullptr;
      this->_first = aux;
      aux = nullptr;

      delete aux;
      this->_size--;
    }
  }

  return val;
}


//
//  Remove all elements
// 
template <class T>
bool Queue<T>::removeAll()
{
  bool val = false;

  if (! isEmpty() )
  {
    while (this->_first != nullptr)
    {
      process();
    }
    val = true;
  }

  return val;
}


// 
//  Get the size of the queue
// 
template <class T>
int  Queue<T>::getSize() { return this->_size; }


//
//  Check if is empty
// 
template <class T>
bool Queue<T>::isEmpty() { return this->_size == 0; }
