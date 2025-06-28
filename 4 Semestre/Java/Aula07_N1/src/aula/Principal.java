package aula;

public class Principal implements Contrato, Contrato2 {		// podemos implementar(implements) quantas interfaces forem necessarias diferente de herança (extends) que é somente uma

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Código : " + codigo);
		System.out.println("Código2 : " + codigo2);

	}
	
	// e OBRIGATÓRIO implementar o método declarado na interface no caso a clausula1 e clausula2
	
	// implementou o método da INTERFACE CONTRATO
	@Override
	public void clausula1() {
		// TODO Auto-generated method stub
		
	}
	
	// implementou o método da INTERFACE CONTRATO
	@Override
	public void clausula2() {
		// TODO Auto-generated method stub
		
	}
	
	// implementou o método da INTERFACE CONTRATO2
	@Override
	public void clausula51() {
		// TODO Auto-generated method stub
		
	}

}
