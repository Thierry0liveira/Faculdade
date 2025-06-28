package aula;

import javax.swing.JOptionPane;

public class Principal2 {

	public static void main(String[] args) {
		// criar as variáveis
				String dadosDigitados, msg;
				//criando o objeto da calsse ContaComum
				ContaEspecial conta1 = new ContaEspecial();
				
				dadosDigitados = JOptionPane.showInputDialog("Digite o saldo da conta: R$");
				conta1.setSaldo(Double.parseDouble(dadosDigitados));

				dadosDigitados = JOptionPane.showInputDialog("Digite o limite da conta: R$");
				conta1.setLimite(Double.parseDouble(dadosDigitados));
				
				JOptionPane.showMessageDialog(null, "Saldo atual: " + conta1.getSaldo());
				
				dadosDigitados = JOptionPane.showInputDialog("Digite o valor a sacar: R$");
				msg = conta1.saque(Double.parseDouble(dadosDigitados));
				JOptionPane.showMessageDialog(null, msg);
				
				JOptionPane.showMessageDialog(null, "Saldo atual: R$" + conta1.getSaldo());

			}

		}