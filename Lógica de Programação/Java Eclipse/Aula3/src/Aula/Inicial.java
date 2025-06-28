package Aula;

import javax.swing.*;

public class Inicial {

	public static void main(String[] args) {
		String dadosDigitados;
		// Criando um objeto da classe alunos
		
		Alunos aluno1 = new Alunos();
		
		
		//Entrando com os dados
		
		dadosDigitados = JOptionPane.showInputDialog("Digite o seu RA:");
		aluno1.setRa(Integer.parseInt(dadosDigitados));
		
		dadosDigitados = JOptionPane.showInputDialog("Digite o seu Nome:");
		aluno1.setNome(dadosDigitados);
		
		dadosDigitados = JOptionPane.showInputDialog("Digite o seu E-mail:");
		aluno1.setEmail(dadosDigitados);
		
		dadosDigitados = JOptionPane.showInputDialog("Digite a nota do Portfolio:");
		aluno1.setNtPort(Float.parseFloat(dadosDigitados));
		
		dadosDigitados = JOptionPane.showInputDialog("Digite a nota dos Exercicios:");
		aluno1.setNtExerc(Float.parseFloat(dadosDigitados));
		
		dadosDigitados = JOptionPane.showInputDialog("Digite a nota da Prova:");
		aluno1.setNtProva(Float.parseFloat(dadosDigitados));
		
		aluno1.setNtMedia((aluno1.getNtPort()+aluno1.getNtExerc()+aluno1.getNtProva())/3);
		
		aluno1.ConsultaDados();
		
	}

}
