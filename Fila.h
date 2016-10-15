#ifndef FILA_H
#define FILA_H
#include <stack>

using namespace std;

template <class T>
class Fila{
private:
    stack<T>* pilha1;
    stack<T>* pilha2;
public:
    Fila<T>(){
        pilha1 = new stack<T>();
        pilha2 = new stack<T>();
    }


    void push_back(T elem){
        pilha1->push(elem);
    }

    void pop_front(){
        if (pilha2->empty()){
            while(!pilha1->empty()){
                pilha2->push(pilha1->top());
                pilha1->pop();
            }
        }
        pilha2->pop();
        while(!pilha2->empty()){
            pilha1->push(pilha2->top());
            pilha2->pop();
        }
    }

    void print(){
        string str = "";
        if(pilha2->empty()){
            while(!pilha1->empty()){
                pilha2->push(pilha1->top());
                pilha1->pop();
            }
        }
        if (pilha1->empty()){
            while(!pilha2->empty()){
                cout<<pilha2->top()<<" ";
                pilha1->push(pilha2->top());
                pilha2->pop();
            }
        }
        cout<<endl;
     }

     bool empty(){
        return (pilha1->empty()&&pilha2->empty());
    }

};

#endif // FILA_H
