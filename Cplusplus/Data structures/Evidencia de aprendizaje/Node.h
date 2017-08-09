/**
 * @Author: Luis Ángel De Santiago Guerrero
 * @Date:   2017-08-04T03:46:48-05:00
 * @Email:  _angelguerrero_@outlook.com
 * @Filename: Node.h
 * @Last modified by:   Luis Ángel De Santiago Guerrero
 * @Last modified time: 2017-08-04T03:53:04-05:00
 * @License: MIT
 */



#pragma once
template <class T>
class Node
{
  T _data;

public:
  Node<T> *next;

  Node();
  
  Node(T data) : _data(data), 
    next(nullptr) {}
  
  ~Node(){};

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
Node<T>::Node()
{
  this->_data = nullptr;
  this->next = nullptr;
}

template <class T>
T Node<T>::getData()
{
  return this->_data;
}

template <class T>
void Node<T>::setData(T data)
{
  this->_data = data;
}