#include <stdio.h>
#include <stdlib.h>

int main(){
	/* VARIAVEIS */
	int opcao, qtdanimaisespecie;
	float comida, preco, qtdcomidadia, qtdcomidames, precomes;
	
	/* ENTRADA DE DADOS */
	printf ("Animais do ZOO:");
	printf ("\n1 - Leao");
    printf ("\n2 - Tigre");
    printf ("\n3 - Elefante");
    printf ("\n4 - Urso pardo");
    printf ("\n5 - Zebra");
    printf ("\n6 - Girafa");
    printf ("\n7 - Chimpanze");
    printf ("\n8 - Lobo");
    printf ("\n9 - Pinguim");
    printf ("\n10 - Canguru");
    printf ("\nEscolha uma OPCAO: ");
    scanf("%i", &opcao);
    printf("Digite a quantidade de Animais Selecionada: ");
    scanf("%i", &qtdanimaisespecie);
	
	/* PROCESSAMENTO */
	if(opcao == 1){
		comida = 10.0;
		preco = 49.0;
	}
	if(opcao == 2){
		comida = 8.0;
		preco = 45.0;
	}
	if(opcao == 3){
		comida = 150.0;
		preco = 24.0;
	}
	if(opcao == 4){
		comida = 15.0;
		preco = 34.0;
	}
	if(opcao == 5){
		comida = 5.0;
		preco = 24.0;
	}
	if(opcao == 6){
		comida = 30.0;
		preco = 29.0;
	}
	if(opcao == 7){
		comida = 6.0;
		preco = 24.0;
	}
	if(opcao == 8){
		comida = 3.0;
		preco = 39.0;
	}
	if(opcao == 9){
		comida = 2.0;
		preco = 14.0;
	}
	if(opcao == 10){
		comida = 1.0;
		preco = 5.0;
	}
	/* CALCULOS	*/
	qtdcomidadia = comida * qtdanimaisespecie;
	qtdcomidames = qtdcomidadia * 30;
	precomes = qtdcomidames * preco;
	
	/* SAIDA DE DADOS */
    printf("\n\nRESULTADOS");
    printf("\nQuantidade comida ao dia: %.2f", qtdcomidadia);
    printf("\nQuantidade comida ao mes: %.2f", qtdcomidames);
    printf("\nCusto mensal: %.2f", precomes);	

	return 0;
}
