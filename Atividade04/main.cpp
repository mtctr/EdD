#include <iostream>
#include "Fila.h"
#include "Fila2"

using namespace std;

int main()
{
    Fila<int>* x = new Fila<int>();

    for(int i = 0; i<=10; i++){
        x->push_back(i);
    }

    x->print();

    x->pop_front();
    x->print();

    x->pop_front();
    x->pop_front();
    x->print();

    x->push_back(7);
    x->print();


}
