//Este programa mostre a implementação da Fila na alocação dinamica
#include<stdio.h>
#include<stdlib.h>

struct Nodo{
       int info;
       struct Nodo *prox;
};// definição uma caixinha
typedef struct Nodo No;
// ponteios para Fila: variaveis global
No *ifila = NULL, *ffila = NULL;
//declaração de subprogramas (operações da fila)
int FilaVazia(void);
void insereNoFila(int x);
int RemoveNoFila(void);
void mostraFila(void);
void devolverFila(void);

//Um subprograma para verificar se fila está vazia
int FilaVazia(void)
{   if (ifila == NULL)
        return 1;
    else 
        return 0;
}
//Um subprograma para inserir um nó no final da lista
void insereNoFila(int x)
{  No *ptr;
   ptr = (No*)malloc(sizeof(No));
   ptr->info = x;
   ptr->prox = NULL;
   if (ifila == NULL) // Primeiro nó
   {  ifila = ptr;
      ffila = ptr;
   }
   else
   {  ffila->prox = ptr;
      ffila = ptr;
   }   
   ptr = NULL;
}
//Um subprograma para mostrar os elementos da fila
void mostraFila(void)
{
     No *aux;
     aux = ifila;
     while (aux!=NULL){
           if (aux->prox == NULL)
             printf("%d->#",aux->info);
           else 
             printf("%d->",aux->info);
           aux = aux->prox; }
     aux = NULL;
}
//Um subprograma para remover um nó no inicio da  fila
int RemoveNoFila(void)
{ 
  No *aux;
  int dado;
    
  aux = ifila; 
  dado = aux->info; 
  ifila = ifila->prox;
  aux ->prox = NULL;
  free(aux);
  aux = NULL;
  return dado;  
} 
//Um subprograma para devolver todos os nós da fila para memória livre (RAM)
void devolverFila(void)
{  No *aux;
   if (ifila)
   {  aux = ifila;
      while (aux!=NULL)
      {   ifila = ifila->prox;
          aux->prox = NULL;
          free(aux);
          aux = ifila;
      } 
   }
   aux = NULL;
   ifila = NULL; ffila = NULL;
}
