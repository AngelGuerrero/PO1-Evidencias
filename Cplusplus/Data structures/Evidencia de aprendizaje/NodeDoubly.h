#pragma once
#include "Node.h"

template <class T>
class NodeDoubly
{
  T _data;

public:
  NodeDoubly<T> *next;
  NodeDoubly<T> *prev;

  NodeDoubly();
  
  NodeDoubly(T data) : _data(data), 
    next(nullptr), 
    prev(nullptr) {}
  
  ~NodeDoubly() {}

  T getData();
  void setData(T);
};

/*
|-------------------------------------------------------------------
| Node Methods
|-------------------------------------------------------------------
|
*/
template <class T>
NodeDoubly<T>::NodeDoubly()
{
  this->_data = nullptr;
  this->next = nullptr;
  this->prev = nullptr;
}


template <class T>
T NodeDoubly<T>::getData()
{
  return this->_data;
}

template <class T>
void NodeDoubly<T>::setData(T data)
{
  this->_data = data;
}