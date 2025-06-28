#include <stdio.h>

int main(){
	int inicio;
	printf("Digite o valor inicial: ");
	scanf("%d", &inicio);
	
	for (inicio; inicio >=0; inicio-- ){
		printf("%d \n", inicio);
	}
	return 0;
}
