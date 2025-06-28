#include <stdio.h>

main(){
	/* Variaves*/
	float preco, porcentagem;
	
	/*Entrada de Dados*/
	printf("Digite o preco: ");
	scanf("%f", &preco);
	printf("Digite a procentagem de aumento: ");
	scanf("%f", &porcentagem);
	
	/*Calculo*/
	float novo_preco = preco + ((preco * porcentagem) / 100);
	
	/*Saida de Dados*/
	printf("Novo preco do produto e R$ %.2f \n", novo_preco);
	
}
