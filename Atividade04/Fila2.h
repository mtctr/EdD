#ifndef FILA2_H
#define FILA2_H
#include <stack>

using namespace std;

template <class T>
class Fila2{

private:
    stack<T>* pilha;


public:
    Fila2() {
        pilha = new stack<T>();

    }

    void push_back(T elem){
        T aux;
        if(pilha->empty()){
            pilha->push(elem);
        }
        else{
            aux = pilha->top();
            pilha->pop();
            push_back(elem);
            pilha->push(aux);
        }

    }

    void pop_front(){
    	pilha->pop();
    }

    void print(){
        T aux;
        aux = pilha->top();
        cout<<aux<<" ";
        pilha->pop();
        if(!pilha->empty()){
             print();
        }
        pilha->push(aux);

    }


};

#endif // FILA2_H
