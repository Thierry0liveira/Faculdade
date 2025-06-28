package aula;

public class Analista extends Funcionarios {
	public String funcao, squad;
	
	//metodo construtor
	public Analista() {
		super();			//super carrega o método construtor da classe pai
		this.setFuncao("");
		this.setSquad("");
	}
	public Analista(int _idade, String _nome, String _setor, String _funcao, String _squad) {
		super(_idade, _nome, _setor);
		this.setFuncao(_funcao);
		this.setSquad(_squad);
	}
	
	
	//gets
	public String getFuncao() {return this.funcao;}
	public String getSquad() {return this.squad;}
	
	//sets
	public void setFuncao(String _funcao) { this.funcao = _funcao;}
	public void setSquad(String _squad) {this.squad = _squad;}
	
	//metodo abstrato

	@Override
	public void calculaSalario() {
		// TODO Auto-generated method stub
		System.out.println("Método Calcula Salário da classe Analista");
	}
	

}
