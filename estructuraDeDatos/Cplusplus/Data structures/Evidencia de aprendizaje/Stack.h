/**
 * @Author: Luis Ángel De Santiago Guerrero
 * @Date:   2017-08-02T06:42:02-05:00
 * @Email:  _angelguerrero_@outlook.com
 * @Filename: Stack.h
 * @Last modified by:   Luis Ángel De Santiago Guerrero
 * @Last modified time: 2017-08-04T06:19:51-05:00
 * @License: MIT
 */



#pragma once
#include "Node.h"

template <class T>
class Stack
{
  int _size;

public:
  Node<T> *top;

  Stack() : top(nullptr), _size(0) {}

  ~Stack() {}

	bool push(T);
	
  T pop();
	T getTop();
	T *getAll();
	int getSize();

	bool isEmpty();
	bool removeAll();
};


// Push element
template <class T>
bool Stack<T>::push(T data)
{
	bool val = false;

	Node<T> *el = new Node<T>(data);

	if (isEmpty())
	{
		top = el;
	}
	else
	{
		el->next = top;
		top = el;
	}
	this->_size++;
	val = true;

	return val;
}

// Pop method
template <class T>
T Stack<T>::pop()
{
	T val = T();

	if ( ! isEmpty() )
	{
		Node<T> *el = top;

		top = top->next;
		val = el->getData();

		el->next = nullptr;
		delete el;

		this->_size--;
	}

	return val;
}

// Get elements
template <class T>
T * Stack<T>::getAll()
{
	Node<T> *iterator = top;

	static T *theArray = new T[getSize()];

	for (int i = 0; i < getSize(); i++)
	{
		theArray[i] = iterator->getData();
		iterator = iterator->next;
	}

	return theArray;
}

// Get top
template <class T>
T Stack<T>::getTop()
{
	T val = T();

	if ( ! isEmpty() )
	{
		val = top->getData();
	}

	return val;
}

// Get the this._size
template <class T>
int Stack<T>::getSize() { return this->_size; }

// check if is empty
template <class T>
bool Stack<T>::isEmpty() { return this->_size == 0; }

// Remove all elements
template <class T>
bool Stack<T>::removeAll()
{
	bool val = false;

	if ( ! isEmpty() )
	{
		while (top != nullptr)
		{
			pop();
		}

		val = true;
	}

	return val;
}
