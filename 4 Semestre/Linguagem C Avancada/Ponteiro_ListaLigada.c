#include<stdio.h>
#include<stdlib.h>
#include<locale.h>//para usar acento nas mensagens
//criamos uma caixinha como dois campos
struct Nodo{
	int id_aluno; //armazenar ra do aluno (informa��o)
	struct Nodo *prox; //ponteiro para armazenar o endere�o do proximo Nodo
};
//definir essa estrutura como No
typedef struct Nodo No;
No *P = NULL; //um ponteiro para receber o endere�o da primeira caixinha da lista
//Declara��o de subprogramas
void insereNofinal(int);
void removerNoincio();
void mostrarLista(No *);
void menu();
//programa principal
int main(){
	
	system("pause");
	return 0;
}
//subprograma para inserir o n� no final da lista
void insereNofinal(int id){
	No *aux, *ptr; //dois ponteiros auxiliares
	/* Alocar uma caixinha do tipo No na memoria RAM 
	   e atribuir o endere�o desta caixinha para ponteiro ptr */
	ptr = (No *)malloc(sizeof(No));
	
	if (P == NULL){//N�o temos lista ainda
	   P = ptr;
	   ptr->id_aluno = id;
	   ptr->prox = NULL;		
	}
	else{//j� temos uma lista, inserir essa caixinha no final da lista
	   aux = P;
	   while (aux->prox!=NULL){ 
	       aux = aux->prox;	//percorrer a lista at� ultima caixinha   	
	   }
	   ptr->prox = NULL;
	   ptr->id_aluno = id;
	   aux->prox = ptr;
	   aux = NULL;
	}
	ptr = NULL;	
}
