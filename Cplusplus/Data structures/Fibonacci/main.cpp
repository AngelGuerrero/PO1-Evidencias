#include <iostream>
using namespace std;

#define ESPANOL locale::global(locale("spanish"))

int main()
{
	int a = 0;
	int b = 1;
	int r = 0;
	int limit = 0;

	ESPANOL;
	cout << "Ingresa el límite: ";
	cin >> limit;

	for (int i = 0; i < limit; i++)
	{
		a = b;
		b = r;
		r = a + b;
		cout << r << ", ";
	}
	cout << "\n\n";

	system("pause");

	return 0;
}