#include <stdio.h>
#include <stdlib.h>

/* Permitir que o usuario entre com um  numero e mostre se o numero e
negativo, neutro ou positivo. */

int main()
{
	int numero;
	printf("Digite um numero: ");
	scanf("%i",&numero);
	
	if(numero < 0){
		printf("O numero %d e negativo\n\n", numero);
	} else if(numero ==0){
		printf("O numero %d e neutro\n\n",numero);
	} else{
		printf("O numero %d e positivo\n\n", numero);
	}
	return 0;
}
