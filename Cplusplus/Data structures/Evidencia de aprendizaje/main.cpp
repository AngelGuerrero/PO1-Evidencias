/**
* @Author: Luis Ángel De Santiago Guerrero
* @Date:   2017-08-01T05:08:10-05:00
* @Email:  _angelguerrero_@outlook.com
* @Filename: main.cpp
* @Last modified by:   Luis Ángel De Santiago Guerrero
* @Last modified time: 2017-08-04T16:10:45-05:00
* @License: MIT
*/


#include "rlutil.h"
#include "Stack.h"
#include "Queue.h"
#include "DoublyLinkedList.h"

#include <ctime>
#include <random>
#include <vector>
#include <string>
#include <iostream>
#include <algorithm>
using namespace std;

/*
|-------------------------------------------------------------------
| Definitions
|-------------------------------------------------------------------
*/
//     ----- Screen -----
#define SPANISH     std::locale::global(std::locale("spanish"))		// Show the tildes in spanish
#define PAUSE       system("pause")
#define WAIT        rlutil::msleep(2500)
#define CLEAR       system("cls")
#define CENTER      rlutil::locate((rlutil::tcols() / 4), rlutil::trows() / 2)
#define NORMAL_POS  rlutil::locate(0, 0);
#define HIDE_CURSOR rlutil::hidecursor()
#define SHOW_CURSOR rlutil::showcursor()
//     ----- Colors -----
#define RED      rlutil::setColor(4)
#define CYAN     rlutil::setColor(rlutil::CYAN);
#define GREEN    rlutil::setColor(2)
#define WHITE    rlutil::setColor(15)
#define YELLOW   rlutil::setColor(14)
#define MAGENTA  rlutil::setColor(5)
#define SKYBLUE  rlutil::setColor(11)
//     ----- Keyboard definitions -----
#define	KEY_ONE		  49
#define KEY_TWO		  50
#define KEY_THREE	  51
#define	KEY_FOUR	  52
#define KEY_LEFT	  16


/*
|-------------------------------------------------------------------
| Global variables
|-------------------------------------------------------------------
*/
char letters[] = { 'a', 'b', 'c', 'd', 'e', 'f',
                   'g', 'h', 'i', 'j', 'k', 'l',
                   'm', 'n', 'o', 'p', 'q', 'r',
                   's', 't', 'u', 'v', 'w', 'x',
                   'y','z','0','1','2','3', '4',
                   '5', '6', '7', '8', '9' };

char operands[] = { '+', '-', '=', '/', '*', '^' };

char separators[] = { '(', ')', '[',']','{','}' };

//
// Dynamic list and stacks are inside the namespace because, 
// if not, it would causes an ambiguous error reference.
//
namespace dynamic
{
  DoublyLinkedList<char> literals;  // Store all the characters
  DoublyLinkedList<char> prepare;   // Prepare data before insert into output

  Stack<char> symbols;              // Store the symbols
  Stack<char> output;               // Store the result of process
}


/*
|-------------------------------------------------------------------
| Prototype functions for postfix
|-------------------------------------------------------------------
*/

//
// Make the process from infix to postfix
// 
void postfix(string);

//
//  Only print the data of the output list
//
void showOutput();

//
//  Move the content of prepare list to output list
// 
void merge();

//
//  Simple demo from infix to postfix
//
void demoPrefix();

//
//  This function is a helper for get 
//  the hierarchy between symbols
//
int compare(char);

//
//  This function is where ths user
//  enter his expression
//
void newExpression();

/*
|-------------------------------------------------------------------
| Prototype functions for BurgerT.com program
|-------------------------------------------------------------------
*/

//
//  Submenu for request the food
//
void submenu();

//
//  Seve the clients
//
void serve(string);

// 
//  Simple menu for show the options
// 
void menu();

//
//  Simple function to show the author info
// 
void info();


/*
|-------------------------------------------------------------------
| main
|-------------------------------------------------------------------
*/
int main()
{
  menu();

  system("pause");

  return 0;
}




// -----------------------------------------------------------------
// Implementations for postfix program
// -----------------------------------------------------------------
void postfix(string s)
{
  char *expression = new char[s.size()];

  int separator = 0;

  for (size_t i = 0; i <= s.size(); i++)
  {
    expression[i] = s[i];

    char *separator = find(begin(separators), end(separators), expression[i]);

    char *character = find(begin(letters), end(letters), expression[i]);

    char *symbol = find(begin(operands), end(operands), expression[i]);

    // if the element is a separator
    if (separator != end(separators))
    {
      separator++;
    }
    // if the element is a symbol
    else if (symbol != end(operands))
    {
      //
      // Add the current character to wait to be compared it,
      // else if the symbol list is not empty, compare the 
      // current symbol between the symbol of the list
      // 
      if (dynamic::symbols.isEmpty())
      {
        dynamic::symbols.push(expression[i]);
      }
      else
      {
        // if separator exist
        if (separator > 0)
        {
          dynamic::symbols.push(expression[i]);
        }
        // if is mayor
        else if (compare(expression[i]) > compare(dynamic::symbols.getTop()))
        {
          dynamic::symbols.push(expression[i]);
          merge();
        }
        // if is minor
        else if (compare(expression[i]) < compare(dynamic::symbols.getTop()))
        {
          merge();
          dynamic::symbols.push(expression[i]);
        }
        // if is equal
        else if (compare(expression[i]) == compare(dynamic::symbols.getTop()))
        {
          merge();
          dynamic::symbols.push(expression[i]);
        }
      }
    }
    // find a character
    else if (character != end(letters))
    {
      dynamic::literals.add(expression[i]);
    }

    // if is the end, then make last merge
    if (expression[i] == ')' || i >= s.size())
    {
      separator--;
      merge();
    }

  }

  // move the content from prepare to output stack
  int length = dynamic::prepare.getSize();
  for (size_t i = 0; i < length; i++)
  {
    dynamic::output.push(dynamic::prepare.getLast());
    dynamic::prepare.removeLast();
  }
}

void newExpression()
{
  string enter = "";

  SPANISH;
  CLEAR;
  SHOW_CURSOR;
  WHITE;
  puts("\t\t\tNueva expresión\n\n\n");
  cout << "Ingresa la expresión a evaluar: ";
  cin >> enter;
  cout << "\nExpresión a evaluar: " << enter << endl;

  postfix(enter);

  cout << "\nExpresión postfija: "; showOutput();

  CYAN;
  rlutil::locate(1, rlutil::trows() - 2);
  PAUSE;

  ;
}

int compare(char param)
{
  switch (param)
  {
  case '+': case '-': return 4; break;
  case '*': case '/': return 3; break;
  case '^': case '=': return 2; break;
  case '(': case ')': return 1; break;
  }
}

void merge()
{
  int length = 0;

  length = dynamic::literals.getSize();
  for (size_t i = 0; i < length; i++)
  {
    dynamic::prepare.add(dynamic::literals.getFirst());
    dynamic::literals.removeFirst();
  }

  length = dynamic::symbols.getSize();
  for (size_t i = 0; i < length; i++)
  {
    dynamic::prepare.add(dynamic::symbols.pop());
  }
}

void showOutput()
{
  int length = dynamic::output.getSize();
  char *r = new char[length];

  r = dynamic::output.getAll();

  for (size_t i = 0; i < length; i++)
  {
    cout << *(r + i);
  }
  cout << endl;

  // Clear output
  dynamic::output.removeAll();
}

void demoPrefix()
{
  string str[] = {
    "((a+b)/c)*(e-f)",
    "a*b/(a+c)",
    "a+b",
    "(a+b)*(c+d)",
    "(((1+2)/(3*4))-5)"
  };
  
  int numrand = rand() % (sizeof(str) / sizeof(str[0])) + 0;

  SPANISH;
  CLEAR;
  HIDE_CURSOR;
  YELLOW;
  puts("\n\t\t\tDemo de expresión postfija\n");
  WHITE;
  cout << "Expresión infija a convertir: " << str[numrand] << endl;
  postfix(str[numrand]);
  cout << "\nExpresión postfija: "; showOutput();

  CYAN;
  rlutil::locate(1, rlutil::trows() - 2);
  PAUSE;
}


// -----------------------------------------------------------------
// Implementations for BurgerT.com program
// -----------------------------------------------------------------
void submenu()
{
  SPANISH;
  CLEAR;
  HIDE_CURSOR;
  YELLOW;
  puts("\n\t\t\tMenú de BurgerT.com\n\n");

  WHITE;
  puts("[1] \tPedir hamburguesa");
  puts("[2] \tPedir papas fritas");
  puts("[3] \tPedir refresco");
  CYAN;
  rlutil::locate(1, rlutil::trows() - 2);
  puts("<=[Tecla izquierda] Para regresar");

  switch (rlutil::getkey())
  {
  case KEY_ONE: serve("Hamburguesa sencilla");  break;

  case KEY_TWO: serve("Papas fritas"); break;

  case KEY_THREE: serve("Refresco normal"); break;

    // return the main menu
  case KEY_LEFT: menu();  break;

  default: submenu(); break;
  }
}

void serve(string product)
{
  Queue<int> queue;

  int numrand;

  int turn;

  do
  {

    numrand = rand() % 30 + 1;
    turn = rand() % 7 + 1;

  } while (turn > numrand);

  for (size_t i = 1; i < numrand; i++)
  {
    queue.add(i);
  }

  SPANISH;
  CLEAR;
  SHOW_CURSOR;
  GREEN;
  puts("\n\t\t\tSirviendo los pedidos\n\n");
  CYAN;
  cout << " Tienes el turno número: " << turn << endl << endl;
  WHITE;
  cout << " Hay " << queue.getSize() << " personas esperando" << endl << endl;

  int limit = queue.getSize();
  for (size_t i = 0; i <= limit; i++)
  {
    if (queue.getFirst() == turn)
    {
      GREEN;
      cout << " \n\t¡Tu pedido: " << product << " está servido!\n\n" << endl;
      break;
    }
    cout << "\tAtendiendo al cliente número: " << queue.process();
    for (size_t i = 0; i < (rand() % 20 + 1); i++)
    {
      Sleep(500);
      cout << ".";
    }
    cout << endl;
  }

  WHITE;
  PAUSE;
  menu();
}


// -----------------------------------------------------------------
// Implementations of other functions
// -----------------------------------------------------------------
void menu()
{

  SPANISH;
  CLEAR;
  HIDE_CURSOR;
  YELLOW;
  puts("\n\t\t\t\tMenú");

  WHITE;
  puts("[1] \tPrograma BurgerT.com");
  puts("[2] \tConversión de expresión infija a postfija");
  puts("[3] \tDemo conversion de expresiones");
  puts("[4] \tInformación");
  CYAN;
  rlutil::locate(1, rlutil::trows() - 2);
  puts("ESCAPE para salir");

  switch (rlutil::getkey())
  {
  case KEY_ONE: submenu(); break;

  case KEY_TWO: {
    newExpression();
    menu();
  } break;

  case KEY_THREE: {
    demoPrefix();
    menu();
  } break;

  case KEY_FOUR: info(); menu(); break;

  case rlutil::KEY_ESCAPE: // Exit
    CLEAR;
    SKYBLUE;
    HIDE_CURSOR;
    CENTER;
    exit(EXIT_SUCCESS);
    break;
  default:
    menu();
    break;
  }
}

void info()
{
  SPANISH;
  CLEAR;
  WHITE;
  CENTER;
  cout << "\n\tAutor: Luis Ángel De Santiago Guerrero\n" << endl;
  cout << "\tMatrícula: ES1611300455" << endl;
  cout << "\tContacto: angelguerrero@nube.unadmexico.mx" << endl;
  cout << "\tIngeniería en Desarrollo de Software" << endl;
  cout << "\tUniversidad Abierta y a Distancia de México" << endl;
  cout << "\n\n" << endl;
  PAUSE; 
}