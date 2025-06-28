package aula;

//		CLASSE FILHA
public class Fisica extends Pessoas {
	//sempre enunciar que a classe filha é uam classe de extenção
	public String CPF, RG;	

	//metodos gets (Leitura) e sets (Atribuição)
	public String getCPF() {
		return this.CPF;
	}

	public void setCPF(String _cpf) {
		this.CPF = _cpf;
	}

	public String getRG() {
		return this.RG;
	}

	public void setInsEstadual(String _rg) {
		this.RG = _rg;
	}

	public int Consultar_fisica() {
		this.Consultar(); // pega o Consultar() da classe pai
		System.out.println("CPF: " + this.getCPF());
		System.out.println("RG: " + this.getRG());
		System.out.println("==================================");
		return 0;
	}
	
}