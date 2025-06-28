package aula;

public class ContaComum {
	protected double saldo;

	
	//get e set
	public void setSaldo(double _valor) {
		this.saldo = _valor;
	}
	public double getSaldo() {
		return this.saldo;
	}
	
	//metodo construtor
	public ContaComum() {
		this.setSaldo(0);
	}
	
	//método saque (não pode sacar dinheiro se o saldo ficar negativo)
	public String saque(double _valor) {
		double futuroSaldo = this.saldo - _valor;
		if(futuroSaldo < 0) {
			return "Saldo insuficiente para este saque. \n Saldo em Conta R$ " + this.getSaldo();
		}else {
			this.setSaldo(futuroSaldo);
			return "Sque realizado com Sucesso! \n Saldo em conta R$ " + this.getSaldo();
		}
	}

}
