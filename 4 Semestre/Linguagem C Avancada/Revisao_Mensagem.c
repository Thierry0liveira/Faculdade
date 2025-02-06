//Exemplo 1 - Subprograma como procedimento
//Enviar uma mensagem atrav�s de um procedimento (subprograma)

#include <stdio.h>		//biblioteca para entrada e saida.
#include <stdlib.h>		//biblioteca para comando "system("pause")".
#include<locale.h>		//biblioteca para usar acentos.

void imprimir_msg();	//declara��o de um subprograma. � um procedimento n�o possui valor.

//programa principal
int main(){	

	setlocale(LC_ALL,"portuguese");		//significa que pode ter mensagem com acentos gr�ficos.
	imprimir_msg();		//chamnado subprograma para executar.
	system("pause");
	return 0;
}

//subprograma: procedimento -> funciona como um comando ou uma instru��o.
void imprimir_msg(){
	printf("Ol� pessoal, sejam bem vindos a Linguagem C Avan�ada!!!\n\n");	
}
