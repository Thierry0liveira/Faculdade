package aula;

//		CLASSE FILHA
public class Juridica extends Pessoas {
	//sempre enunciar que a classe filha é uam classe de extenção
	public String CNPJ, InsEstadual;	
	
	//metodos gets (Leitura) e sets (Atribuição)
	public String getCNPJ() {
		return this.CNPJ;
	}
	
	public void setCNPJ(String _cnpj) {
		this.CNPJ = _cnpj;
	}
	
	public String getInsEstadual() {
		return this.InsEstadual;
	}
	
	public void setInsEstadual(String _ins) {
		this.InsEstadual = _ins;
	}
	
	public int Consultar_empresa() {
		this.Consultar(); // pega o Consultar() da classe pai
		System.out.println("CNPJ: " + this.getCNPJ());
		System.out.println("Inscrição Estadual: " + this.getInsEstadual());
		System.out.println("==================================");
		return 0;
	}
	
}
