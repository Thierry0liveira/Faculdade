package Aula;

import javax.swing.*;

public class Alunos {
	public int RA;
	public String Nome, Email;
	public float NtProva, NtExerc, NtPort, NtMedia;
	
	// métodos Gets (Leitura) e Sets (Atribuindo)
	
	public void setRa(int ra) {this.RA = ra;}
	public void setNome(String nome) { this.Nome = nome;}
	public void setEmail(String email) {this.Email = email;}
	
	public void setNtProva(float nota) {this.NtProva = nota;}
	public void setNtExerc(float nota) {this.NtExerc = nota;}
	public void setNtPort(float nota) {this.NtPort = nota;}
	public void setNtMedia(float nota) {this.NtMedia = nota;}
	
	public int getRA() {return this.RA;}
	public String getNome() {return this.Nome;}
	public String getEmail() {return this.Email;}
	public float getNtProva() {return this.NtProva;}
	public float getNtExerc() {return this.NtExerc;}
	public float getNtPort() {return this.NtPort;}
	public float getMedia() {return this.NtMedia;}
	
	public void ConsultaDados() {
		String msg = "Dados Cadastrados \n" + 
					 "\n RA:" + this.getRA() +
					 "\n Nome:" + this.getNome() +
					 "\n E-mail:" + this.getEmail() +
					 "\n Nota Portfolio:" + this.getNtPort() +
					 "\n Nota Exercicios:" + this.getNtExerc() +
					 "\n Nota Prova" + this.getNtProva() +
					 "\n Media:" + this.getMedia();
		
		JOptionPane.showMessageDialog(null, msg);
	}
	

}
