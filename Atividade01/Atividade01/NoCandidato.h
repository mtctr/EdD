#ifndef _NOCANDIDATO_H
#define _NOCANDIDATO_H
#include <cstring>
#include "Candidato.h"


using namespace std;

class NoCandidato {

public:
	Candidato* conteudo;
	NoCandidato* next;

	

	NoCandidato(Candidato* c, NoCandidato* n) {
		this->conteudo = c;
		this->next = n;
	}

	
	string toString() {
		string str;
		str = this->conteudo->toString() + " -> "; 				
		
		if (this->next) {
			str += this->next->toString();
		}
		else
			str += "0";

		return str;
	}

};
#endif

