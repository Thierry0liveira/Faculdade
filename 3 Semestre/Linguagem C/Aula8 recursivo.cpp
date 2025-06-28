#include <stdio.h>

int somadez(int n){
	if (n == 1){
		return 1;
	} else {
		return n + somadez( n - 1 );
	}
}

int main(){
	int res = somadez(40);
	printf("A soma e: %d \n", res);
	return 0;
}
