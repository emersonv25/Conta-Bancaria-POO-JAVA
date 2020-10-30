/*
 *  Autor: Emerson de Jesus Santos
 *  Mat: 16017157
 *  Formando em Analise e desenvolvimento de sistemas
 *  Centro Universitário Maurício de Nassau
 *  
 */
package banco.main;

import banco.model.ContaComum;
import banco.model.ContaEspecial;
import banco.model.ContaPoupanca;
import banco.util.Keyboard;

public class Cadastro {
	public ContaComum cadastrarContaComum() {
		String nome = Keyboard.readString("Digite o nome do cliente: ");
		int num = Keyboard.readInt("Digite o número da conta: ");
		ContaComum contac = new ContaComum(num, nome);
		return contac;
	}
	
	public ContaEspecial cadastrarContaEspecial() {
		String nome = Keyboard.readString("Digite o nome do cliente: ");
		int num = Keyboard.readInt("Digite o número da conta: ");
		double credito = Keyboard.readInt("Digite o valor do credito: ");
		ContaEspecial contae = new ContaEspecial(num, nome, credito);
		return contae;
	}
	
	public ContaPoupanca cadastrarContaPoupanca() {
		String nome = Keyboard.readString("Digite o nome do cliente: ");
		int num = Keyboard.readInt("Digite o número da conta: ");
		ContaPoupanca contap = new ContaPoupanca(num, nome);
		return contap;
	}
}
