//Exemplo 1 - Subprograma como procedimento
//Enviar uma mensagem através de um procedimento (subprograma)

#include <stdio.h>		//biblioteca para entrada e saida.
#include <stdlib.h>		//biblioteca para comando "system("pause")".
#include<locale.h>		//biblioteca para usar acentos.

void imprimir_msg();	//declaração de um subprograma. É um procedimento não possui valor.

//programa principal
int main(){	

	setlocale(LC_ALL,"portuguese");		//significa que pode ter mensagem com acentos gráficos.
	imprimir_msg();		//chamnado subprograma para executar.
	system("pause");
	return 0;
}

//subprograma: procedimento -> funciona como um comando ou uma instrução.
void imprimir_msg(){
	printf("Olá pessoal, sejam bem vindos a Linguagem C Avançada!!!\n\n");	
}
