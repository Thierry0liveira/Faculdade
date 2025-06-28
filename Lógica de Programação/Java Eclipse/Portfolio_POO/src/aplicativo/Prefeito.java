package aplicativo;

public class Prefeito {
	protected int prefeitoID;
    public String nome;
    protected String email;
    protected String senha;
    
    public int getPrefeitoID() {
        return this.prefeitoID;
    }

    public void setPrefeitoID(int prefeitoID) {
        this.prefeitoID = prefeitoID;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
    	return this.email;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    protected int ConsultarPrefeito() {
		System.out.println("ID Prefeito: " + this.getPrefeitoID());
		System.out.println("Nome: " + this.getNome());
		System.out.println("Email: " + this.getEmail());
		System.out.println("Senha: " + this.getSenha());
		return 0;
	}
}
