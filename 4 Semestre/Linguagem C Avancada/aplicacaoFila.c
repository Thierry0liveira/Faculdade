/*
Simulamos uma situa��o que nos permita determinar qual o tempo m�dio que um
cliente aguarda numa fila de uma ag�ncia banc�ria para realizar uma transa��o no
caixa eletr�nico:
*/
#include<stdio.h>
#include<stdlib.h>
#include<time.h> //recurso para gerar um n�mero aleat�rio
#include "filaDinamica2.h" //inlcuir o recurso da fila implementado usa-se "" quando a biblioteca voc� mesmo criou
#define fim 21600 // 6 horas de expediente em segundos

/*	Na nossa simula��o, dois eventos que podem ocorrer:
	1)	Um cliente chega � ag�encia e entra na fila.
	2)	Um caixa � liberado, algu�m sai da fila e o utiliza. */
	
int ClienteChegou();
int transacao();

//Programa Principal
int main(){
	int caixaEle[3], crono, n_cliente, i;
	float t_espera;
	
	srand(time(NULL)); //semente para gerar um n�mero aleat�rio
	crono = 0; n_cliente = 0; t_espera = 0.0;
	
	for (i = 0; i < 3; i++) //inicializar os caixas eletr�nicos
		caixaEle [i] = 0;
		
	//Enquanto n�o terminar o expediente ou tem algu�m na fila
	while ((crono < fim) || (!FilaVazia())){
		if (ClienteChegou() && (crono < fim)){
			insereNoFila(crono);
		}
		for(i=0; i<3; i++){
			//se h� caixa livre e a fila n�o est� vazia, cliente sai da fila
			//vai ser atendido
			if ((caixaEle[i] == 0) && (!FilaVazia())){
				t_espera = t_espera + (crono - RemoveNoFila())/60;
				caixaEle[i] = transacao(); //realizar a opera��o de transa��o
				n_cliente++;
			}			
		}
		for (i=0; i<3; i++){ //decrementar o tempo de uso de cada caixa
			if (caixaEle[i]>0)
				caixaEle[i]--; //decrementar o tempo
		}
		crono++;
	}
	printf("Total de clientes atendidos: %d\n", n_cliente);
	printf("Tempo medio de espera na fila: %.2f min.\n", (t_espera/n_cliente));
	printf("Tempo extra de expediente..: %.2f min.\n", (float)(crono-fim)/60);
	
	system ("pause");
	return ;
}

//Subprograma ClienteChegou()
int ClienteChegou(){
	int num;
	num = rand()%30; //gera um n�mero inteiro entre 0 a 29
	if (num == 0) //probabilidade de um cliente chegar � 1/30
		return 1;
	else
		return 0;
}

//Subprograma transacao()
//3 opera��es: Saque; Dep�sito; Pagamento
int transacao(){
	int num, trans;
	num = rand()%3; //gerar um n�mero inteiro entre 0 a 2
	if (num == 0)
		trans = 60; // 60 segundos - efetuar um saque
	else if (num == 1)
			trans = 90; //90 segundos - dep�sito
		else if (num == 2)
				trans = 120; // 120 segundos - pagamento
	return trans;	
}

