#include <stdio.h>
#include <stdlib.h>

/* 
	Montar um programa que receba dois numeros 
	e mostre a media entre eles
*/
int main(){
	float n1, n2, media;
	printf("Digite o valor de n1: ");
	scanf("%f", &n1);
	printf("Digite o valor de n2: ");
	scanf("%f", &n2);
	media = (n1+n2) / 2;
	printf("A media entre n1 e n2 e: %f", media);
	return 0;
}
