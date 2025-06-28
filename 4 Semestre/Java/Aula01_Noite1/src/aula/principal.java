package aula;

public class principal {

	public static void main(String[] args) {
		// criando um objeto da classe veiculos
		veiculos fusca = new veiculos();
		
		//definindo as caracteristicas
		fusca.marca = "Volkswagem";
		fusca.modelo = "Fuscão 1600";
		fusca.placa = "AAA-1234";
		fusca.cor = "Azul";
		fusca.ano = 1975;
		
		//executando funções
		fusca.ligar();
		fusca.acelerar();
		fusca.frear();
		fusca.desligar();
		
		veiculos brasilia = new veiculos();
		brasilia.ligar();

	}

}
