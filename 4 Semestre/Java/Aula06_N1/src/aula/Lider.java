package aula;

public class Lider extends Funcionarios {
	public String tribo;
	
	//construtor
	public Lider() {
		super();
		this.setTribo("");
	}
	public Lider(int _idade, String _nome, String _setor, String _funcao, String _tribo) {
		super(_idade, _nome, _setor);
		this.setTribo(_tribo);
	}
	
	//set
	public void setTribo(String _tribo) { this.tribo = _tribo;}
	
	//get
	public String getTribo() {return this.tribo;}

	@Override
	public void calculaSalario() {
		// TODO Auto-generated method stub
		System.out.println("Método Calcula Salário da classe Lider");
		
	}
	
	public void adicionaLiderados() {
		// TODO Auto-generated method stub
		System.out.println("Método Adiciona Liderados da classe Lider");
		
	}

}
