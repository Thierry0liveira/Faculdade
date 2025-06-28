#include <stdio.h>

int main(){
	int contador = 1;
	int soma = 0;
	while (contador <= 50){
		soma = contador + soma;							
		contador++;		
	}
	printf("A soma dos numeros: %i \n", soma);
	return 0;
} 
