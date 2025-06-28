#include <stdio.h>

main(){
	/* Variaves*/
	float preco, porcentagem;
	
	/*Entrada de Dados*/
	printf("Digite o preco: ");
	scanf("%f", &preco);
	
	/*Condicoes*/
	if(preco <= 1000){
		porcentagem = 2.5;
	} else if(preco > 1000 && preco <= 3500){
		porcentagem = 5;
	} else{
		porcentagem = 7.5;
	}
	
	/*Calculo*/
	float 	novo_preco = preco + ((preco * porcentagem) / 100);
	
	/*Saida de Dados*/
	printf("Novo preco do produto e R$ %.2f com um aumento de %.2f\n", novo_preco, porcentagem);
	
}
