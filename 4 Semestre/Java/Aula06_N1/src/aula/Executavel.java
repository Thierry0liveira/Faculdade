package aula;

public class Executavel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Funcionario obj = new Funcionari();  ERRO ( a classe funcionario é abstrata).
		Analista obj1 = new Analista(28, "Naian", "Desenvolvedor", "Programador", "Pleno");
		obj1.calculaSalario();
		Analista obj2 = new Analista(29, "Leandro", "Desenvolvedor", "Analista", "Pleno");
		obj2.calculaSalario();
		
		Lider obj3 = new Lider(48, "Abel", "Desenvolvedor", "Lider", "Naian e Leandro");
		obj3.calculaSalario();

	}

}
