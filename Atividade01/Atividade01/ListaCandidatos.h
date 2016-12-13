#ifndef _LISTACANDIDATO_H
#define _LISTACANDIDATO_H
#include <cstring>
#include <iostream>
#include <fstream>
#include "Candidato.h"
#include "NoCandidato.h"

using namespace std;

class ListaCandidatos {

public:
	NoCandidato* head;
	int size;


	 ListaCandidatos() {
		this->head = NULL;
		this->size = 0;
	}

	 ListaCandidatos(string nomeDoArquivo) {
		 this->size = 0;

		 ifstream fcin(nomeDoArquivo);

		 string dados;
		 getline(fcin, dados);
		 cout << "criacao da lista de candidatos de: " << dados << endl;

		 while (getline(fcin, dados)) {

			this->adicioneComoHead(new Candidato(dados));

		 }
	}

	 int tamanho() {
		 return this->size;
	 }

	 void adicioneComoHead(Candidato* c) {
		this->head = new NoCandidato(c, head);
		this->size++;
	}

	 void filtrarCandidatos(int nota) {
		 NoCandidato* it = head;
				 
		 if (it != NULL) {
			 if (head->conteudo->nota < nota) {
				 head = head->next;
				 this->size--;
			 }
			 
			 while (it->next != NULL) {
				 if (it->next->conteudo->nota < nota) {
					 it->next = it->next->next;
					 this->size--;
				 }
				 else
					 it = it->next;
			 }			
		 }
	 }

	 void concatena(ListaCandidatos* l) {
		 NoCandidato* aux = head;
		 while (aux->next != NULL) {
			 aux = aux->next;
		 }
		 aux->next = l->head;
	 }

	bool remove(string nome, string sobrenome){
		NoCandidato* it = head;
		bool r = false;

		if (it != NULL) {
			if (it->conteudo->nome.compare(nome)!=0 && it->conteudo->sobrenome.compare(sobrenome)!=0) {
				head = it->next;
				delete it;
				r = true;
				this->size--;
			}
			else {
				while (it->next != NULL) {
					if (it->next->conteudo->nome.compare(nome)!=0 && it->next->conteudo->sobrenome.compare(sobrenome)!=0) {
						delete (it->next);
						it->next = it->next->next;
						r = true;
						this->size--;
						break;
					}
					else
						it = it->next;
				}
			}

		}
		return r;
	}

	bool estaVazia() {
		return this->size == 0;
	}

	string toString() {
		string str;
		if (this->estaVazia())
			str += "0";
		else
			str = this->head->toString();

		return str;
	}
};
#endif
