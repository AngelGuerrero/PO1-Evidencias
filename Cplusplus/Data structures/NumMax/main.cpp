#include <iostream>
using namespace std;

#define SPANISH locale::global(locale("spanish"))

//Global variables
int arrayLength;
int *numbers;

//Prototype
int max(int *, int);

int main()
{
	SPANISH;

	cout << "Ingresa el máximo de números a ingresar: ";
	cin >> arrayLength;

	numbers = new int[arrayLength];

	for (int i = 0; i < arrayLength; i++)
	{
		cout << "Ingresa un valor para el índice " << i << ": ";
		cin >> numbers[i];
	}

	cout << "\nEl valor máximo de la lista es: " << max(numbers, arrayLength) << "\n" << endl;

	system("pause");

	delete numbers;

	return 0;
}

int max(int *list, int length)
{
	int max = list[0];

	for (int i = 0; i < length; i++)
	{
		if (list[i] >= max)
		{
			max = list[i];
		}
	}

	return max;
}