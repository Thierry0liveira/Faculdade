#include <stdio.h>

int fatorial(int n){
	if (n == 1){
		return 1;
	} else {
		return n * fatorial( n - 1 );
	}
}

int main(){
	int res = fatorial(5);
	printf("O fatorial e: %d \n", res);
	return 0;
}
