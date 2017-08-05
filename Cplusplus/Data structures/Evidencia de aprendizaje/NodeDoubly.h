/**
* @Author: Luis Ángel De Santiago Guerrero
* @Date:   2017-08-01T05:08:10-05:00
* @Email:  _angelguerrero_@outlook.com
* @Filename: NodeDoubly.h
* @Last modified by:   Luis Ángel De Santiago Guerrero
* @Last modified time: 2017-08-04T16:10:45-05:00
* @License: MIT
*/



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