#include <stdio.h>
#include <stdlib.h>

main()
{
	printf("Aula 2 Exercício \nPrograma que receba 5 nº inteiros, calcule e mostre a soma \n");
	int n1, n2, n3, n4, n5, soma;
	
	printf("Digite o valor 1:");
	scanf("%i",&n1);
	printf("Digite o valor 2: ");
	scanf("%i",&n2);
	printf("Digite o valor 3: ");
	scanf("%i",&n3);
	printf("Digite o valor 4: ");
	scanf("%i",&n4);
	printf("Digite o valor 5: ");
	scanf("%i",&n5);
	
	soma = n1+n2+n3+n4+n5;
	
	printf("Soma: %i",soma);
}
