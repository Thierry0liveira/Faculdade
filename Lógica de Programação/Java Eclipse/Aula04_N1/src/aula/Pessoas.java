package aula;

//		CLASSE PAI
public class Pessoas {
	protected int IdPessoa;
	protected String Nome, Email, Endereco, CEP, Telefone;
	
	//metodos gets (Leitura) e sets (Atribuição)
	public int getIdPessoa() {
		return this.IdPessoa;
	}
	public void setIdPessoa(int _id) {
		this.IdPessoa = _id;
	}
	public String getNome() {
		return this.Nome;
	}
	public void setNome(String Nome) {
		this.Nome = Nome;
	}
	public String getEmail() {
		return this.Email;
	}
	public void setEmail(String Email) {
		this.Email = Email;
	}
	public String getEndereco() {
		return this.Endereco;
	}
	public void setEndereco(String Endereco) {
		this.Endereco = Endereco;
	}
	public String getCEP() {
		return this.CEP;
	}
	public void setCEP(String CEP) {
		this.CEP = CEP;
	}
	public String getTelefone() {
		return this.Telefone;
	}
	public void setTelefone(String Telefone) {
		this.Telefone = Telefone;
	}
	
	
		
	protected int Consultar() {
		System.out.println("Id Pessoa: " + this.getIdPessoa());
		System.out.println("Nome: " + this.getNome());
		System.out.println("Email: " + this.getEmail());
		System.out.println("Endereço: " + this.getEndereco());
		System.out.println("CEP: " + this.getCEP());
		System.out.println("Telefone: " + this.getTelefone());
		System.out.println("==================================");
		return 0;
	}
}
