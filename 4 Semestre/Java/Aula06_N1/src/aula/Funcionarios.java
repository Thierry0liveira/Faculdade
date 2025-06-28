package aula;

public abstract class Funcionarios {
	public int idade;
	public String nome, setor;
	
	//método construtor
	public Funcionarios() {
		this.setIdade(0);
		this.setNome("");
		this.setSetor("");
	}
	public Funcionarios(int _idade, String _nome, String _setor) {
		this.setIdade(_idade);
		this.setNome(_nome);
		this.setSetor(_setor);
	}
	
	//get
	public int getIdade() {	return this.idade;	}
	public String getNome() { return this.nome;}
	public String getSetor() {	return this.setor; }
	
	//set
	public void setIdade(int _idade)	{	this.idade = _idade;}
	public void setNome (String _nome) {this.nome = _nome;}
	public void setSetor (String _setor) { this.setor = _setor;}
	
	//outros métodos
	public abstract void calculaSalario(); // abstract n tem codigo.... ele sera programadao na classe filha

}
