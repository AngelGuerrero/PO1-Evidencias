#include <string>
#include <cmath>
#include <iostream>
using namespace std;

//Global variables
#define SPANISH locale::global(locale("spanish"))
int divider = 2;

// Prototype
void simplify(double, double);
bool isInteger(double);


int main()
{
	double num, den;

	SPANISH;

	cout << "Ingrese el numerador: ";
	cin >> num;

	cout << "Ingrese el denominador: ";
	cin >> den;

	simplify(num, den);

	system("pause");

	return 0;
}

void simplify(double numerator, double denominator)
{
	double r_num;
	double r_den;

	r_num = numerator / divider;
	r_den = denominator / divider;

	if (isInteger(r_num) && isInteger(r_den))
	{
		cout << "Simplificando: " << numerator << "/" << denominator << endl;
		simplify(r_num, r_den);
	}
	else if (numerator == divider || denominator == divider || r_num <= 1 || r_den <= 1)
	{
		cout << "La máxima expresión es: " << numerator << "/" << denominator << endl;
	}
	else
	{
		divider++;
		simplify(numerator, denominator);
	}
}

bool isInteger(double param)
{
	bool val = false;

	double integer, decimal;

	decimal = modf(param, &integer);

	//cout << "decimal: " << decimal << "\nentero: " << integer << endl;

	if (decimal > 0)
	{
		//cout << "Es un flotante" << endl;
		val = false;
	}
	else
	{
		//cout << "Es un entero" << endl;
		val = true;
	}

	return val;
}