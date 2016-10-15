#include <iostream>
#include "Fila2.h"

using namespace std;

int main()
{
    Fila2<int>* x = new Fila2<int>();

    for(int i = 0; i<=10; i++){
        x->push_back(i);
    }

    x->print();
    cout<<endl;
    x->pop_front();
    x->print();
    cout<<endl;
    x->pop_front();
    x->pop_front();
    x->print();
    cout<<endl;
    x->push_back(7);
    x->print();
    cout<<endl;

}

