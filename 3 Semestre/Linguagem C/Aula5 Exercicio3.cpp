#include <stdio.h>
/*
main(){
	int diaSemana;
	printf("Digite o dia da Semana: ");
	scanf("%i", &diaSemana);
	
	if(diaSemana == 2){
		printf("Segunda-feira");
	} else if(diaSemana == 3){
		printf("Terca-feira");
	} else if(diaSemana == 4){
		printf("Quarta-feira");
	} else if(diaSemana == 5){
		printf("Quinta-feira");
	} else if(diaSemana == 6){
		printf("Sexta-feira");
	} else if(diaSemana == 7){
		printf("Sabado");
	} else if(diaSemana == 1){
		printf("Domingo");
	} else{
		printf("Dia incorreto");
	}
} 
Tudo isso pode ser substituido pelo codigo a seguir
*/
main(){
	int diaSemana;
	printf("Digite o dia da Semana: ");
	scanf("%i", &diaSemana);
	switch(diaSemana)
	{
		case 2:
			printf("Segunda-feira");
			break;
		case 3:
			printf("Terca-feira");
			break;
		case 4:
			printf("Quarta-feira");
			break;
		case 5:
			printf("Quinta-feira");
			break;
		case 6:
			printf("Sexta-feira");
			break;
		case 7:
			printf("Sabado-feira");
			break;
		case 1:
			printf("Domingo");
			break;
		default:
			printf("Dia incorreto");
			break;
	}}
