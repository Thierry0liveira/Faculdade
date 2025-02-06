//Exemplo 2 - Subprograma como uma função.
//Faça uma função que receba um número inteiro n >= 1 e retorna o resultado da soma de todos os números 
// inteiros de 1 a n. Exemplo: se n = 6, resultado = 1+2+3+4+5+6 = 21.

#include <stdio.h>		//biblioteca para entrada e saida.
#include <stdlib.h>		//biblioteca para comando "system("pause")".
#include<locale.h>		//biblioteca para usar acentos.

int main(){
	int n;
	setlocale(LC_ALL,"portuguese");		//significa que pode ter mensagem com acentos gráficos.
	printf("Informe um número inteiro n = ");
	scanf("%d", &n);
	printf("\nO resultado da soma = %d\n\n", soma_sequencia(n));
	system("pause");
	return 0;
}

//subprograma como uma função. -> funciona como um valor.

//n - parâmetro para receber os dados.
int soma_sequencia(int n){
	int i, somar = 0;		//variáveis locais.
	for(i = 1; i <= n; i++){
		somar += i;		//somar = somar + i.
	}
	return somar;	//retornar o resultado
}
