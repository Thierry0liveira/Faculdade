#include <stdio.h>

int soma(int num1 , int num2){
	int somatoria = num1 + num2;
	return somatoria;
}

int main(){
	int n1, n2;
	printf("Digite um valor: ");
	scanf("%d", &n1);
	
	printf("Digite outro valor: ");
	scanf("%d", &n2);
	
	int res = soma(n1, n2);
	printf("A soma e: %d \n", res);
	return 0;
}
