package aula;

public class Inicial {

	public static void main(String[] args) {
		// criando os objetos
		//declaro o objeto da classe
		Pessoas objPes = new Pessoas();
		//atribuo os objetos
		objPes.setIdPessoa(1);
		objPes.setNome("Pessoa 1");
		objPes.setEmail("pessoa1@gmail.com");
		objPes.setEndereco("Rua xxxxx");
		objPes.setTelefone("55 (11) 1234-56789");
		objPes.setCEP("07000-000");
		//mando consultar
		objPes.Consultar();
		
		
		Juridica objJur = new Juridica();
		objJur.setIdPessoa(2);
		objJur.setNome("Empresa");
		objJur.setEmail("empresa@gmail.com");
		objJur.setEndereco("Rua zzzzz");
		objJur.setTelefone("55 (11) 1234-12345");
		objJur.setCEP("07010-000");
		objJur.setCNPJ("12.123.456/0001-78");
		
		objJur.setInsEstadual("Isento");
		objJur.Consultar_empresa();
		
		
	}

}
