/*
 *  Autor: Emerson de Jesus Santos
 *  Mat: 16017157
 *  Formando em Analise e desenvolvimento de sistemas
 *  Centro Universitário Maurício de Nassau
 *  
 */

package banco.main;

import java.util.ArrayList;
//import java.util.Scanner;

import banco.model.Conta;
import banco.model.ContaComum;
import banco.model.ContaEspecial;
import banco.model.ContaPoupanca;
import banco.util.Keyboard;

public class Menu {
	//private static Scanner input; // inicializia o teclado
	private static int indice; // cria uma variavel para armazenar o indice retornado na função existe()
	private static int numConta1;
	private static int numConta2;
	
	// CADASTRA UMA CONTA COMUM
	public void cadastrarContaComum(ArrayList <Conta> contas)
	{
		boolean repetir = true;
		while (repetir)
		{
			String nome = Keyboard.readString("Digite o nome do cliente: ");
			
			int num = Keyboard.readInt("Digite o número da conta: ");
			
			if (num > 999 && num < 9999)
			{
				if (existe(contas, num) == false)
				{
					contas.add(new ContaComum(num, nome));
					println("Conta cadastrada com sucesso ! ");
					repetir = false;
				}
				
				else 
				{
					println("Número de conta já existente.");
				}
			}
			else
			{
				println("Número da conta precisa ter 4 digitos!");
			}
		}
	}
		
	// CADASTRO CONTA POUPANÇA
	public void cadastrarContaPoupanca(ArrayList <Conta> contas)
	{
		boolean repetir = true;
		while (repetir)
		{
			String nome = Keyboard.readString("Digite o nome do cliente: ");
			
			int num = Keyboard.readInt("Digite o número da conta: ");
			
			if (num > 999 && num < 9999)
			{
				if (existe(contas, num) == false)
				{
					contas.add(new ContaPoupanca(num, nome));
					println("Conta cadastrada com sucesso ! ");
					repetir = false;
				}
				
				else 
				{
					println("Número de conta já existente.");
				}
			}
			else
			{
				println("Número da conta precisa ter 4 digitos!");
			}
		}
		
	}
	// CADASTRO CONTA ESPECIAL
	public void cadastrarContaEspecial(ArrayList <Conta> contas)
	{
		boolean repetir = true;
		while (repetir)
		{
			String nome = Keyboard.readString("Digite o nome do cliente: ");
			
			int num = Keyboard.readInt("Digite o número da conta: ");
			
			if (num > 999 && num < 9999)
			{
				if (existe(contas, num) == false)
				{
					double credito;
					do {credito = Keyboard.readInt("Digite o valor do crédito especial: ");} while(credito < 0);
					contas.add(new ContaEspecial(num, nome, credito));
					println("Conta cadastrada com sucesso ! ");
					repetir = false;
				}
				
				else 
				{
					println("Número de conta já existente.");
				}
			}
			else
			{
				println("Número da conta precisa ter 4 digitos!");
			}
		}
		
		
	}
	
	
	// LISTA TODAS AS CONTAS DO ARRAY
	public  void listar(ArrayList <Conta> contas)
	{
		printExtrato();
		//println("xxxx     xxxxxxxxxxxxxxxxxxxxx              xxxx,xx ");
		for(int i=0; i < contas.size(); i++ )
		{
			contas.get(i).extrato();
		}
	}
	
	// Excluir uma conta
	public void excluir(ArrayList <Conta> contas)
	{
		int num = Keyboard.readInt("Digite o número da conta: ");
		
		if (existe(contas, num) == true)
		{
			contas.remove(indice);
			println("Conta excluida com sucesso! ");
		}
		else
		{
			println("Conta inexistente !");
		}
	}
	
	// DEPOSITOS
	public void depositos(ArrayList <Conta> contas)
	{
		int num = Keyboard.readInt("Digite o número da conta: ");
		
		if (existe(contas, num) == true)
		{
			printExtrato();
			contas.get(indice).extrato();
			double valor = Keyboard.readDouble("Digite o valor do Deposito: R$ ");
			
			if (valor > 0)
			{
				if (contas.get(indice).deposito(valor))
				{
					System.out.printf("Deposito de: R$%.2f Efetuado com sucesso !\n", valor);
					println("Novo Saldo: R$" + contas.get(indice).getSaldo());
				}
				else
				{
					println("OPS: Algo deu errado, Deposito não realizado! ");
				}

			}
			else
			{
				println("Valor Negativo !");
			}
			
		}	
		else
		{
			println("Conta inexistente !");
		}
	}
	
	// SAQUE
	public void saques(ArrayList <Conta> contas)
	{
		int num = Keyboard.readInt("Digite o número da conta: ");
		

		if (existe(contas, num) == true)
		{
			printExtrato();
			contas.get(indice).extrato();
			
			Double valor = Keyboard.readDouble("Digite o valor do Saque: R$ ");
			if (valor > 0)
			{
				if (contas.get(indice).saque(valor) == true)
				{	
					//contas.get(indice).saque(valor);
					println("Novo Saldo: R$" + contas.get(indice).getSaldo());
					System.out.printf("Saque de: R$%.2f Efetuado com sucesso !\n", valor);
					
				}	
			}
			else
			{
				println("Valor Negativo !");
			}
			
		}
		else
		{
			println("Conta não encontrada !");
		}
		
	}
	
	// TRANSFERÊNCIA ENTRE CONTAS
	public void transferir(ArrayList <Conta> contas)
	{
		//GAMBIARRA PARA PEDI NOVAMENTE O NUMERO DA CONTA CASO NÃO EXISTA, POIS LI ESSA EXIGENCIA NA ATIVIDADE QUANDO O PROGRAMA JÁ ESTAVA PRONTO
		boolean repetir = true;
		int indice1;
		int indice2;
		
		while (repetir)
		{
			numConta1 = Keyboard.readInt("Número da conta do remetente: ");
			numConta2 = Keyboard.readInt("Digite o número da conta do destinatario: ");	
			
			
			if (existe(contas, numConta1) == true && existe(contas, numConta2) == true && numConta1 != numConta2)
			{
				repetir = false;
			}
			else{println("OPS: Umas das contas não foi encontrada, tente novamente!");}
			
		}
		existe(contas, numConta1);
		indice1 = indice;
		existe(contas, numConta2);
		indice2 = indice;
		
		Double valor = Keyboard.readDouble("Digite o valor da Transferência: R$ ");
		if (valor > 0)
		{
			if (contas.get(indice1).saque(valor) && contas.get(indice2).deposito(valor))
			{
				System.out.printf("Transferencia de: R$%.2f Efetuado com sucesso !\n", valor);
			}
			else
			{
				println("Ops: Algo deu errado, transferencia não realizada! ");
			}
			
			
		}
		else {println("Valor Negativo !");}	
		
	}
	// credita todas as contas poupança
	public void creditar(ArrayList <Conta> contas)
	{
		double juros = Keyboard.readDouble("Digite o valor da taxa de juros em porcentagem: ");
		Conta conta;
		for(int i=0; i < contas.size(); i++ )
		{
			conta = contas.get(i);
			if(conta instanceof ContaPoupanca) {
				 ((ContaPoupanca) conta).creditar(juros);
			}
		}
		
		System.out.println("Rendimento da poupança creditado com sucesso!!!");
		
	}
	// consulta e imprime o extrato de uma conta
	public void consultar(ArrayList <Conta> contas)
	{
		int num = Keyboard.readInt("Digite o número da conta: ");
		
		if (existe(contas, num) == true)
		{
			printExtrato();
			contas.get(indice).extrato();
		}
		else
		{
			println("Conta inexistente !");
		}
	}
	
	// verifica se a conta existe e retorna true ou false e armazena o indice numa variavel global
	
	// ESTUDAR FOREACH E O METODO CONTAIN
	public static boolean existe(ArrayList <Conta> contas, int num)
	{
		boolean consulta = false;
		for (int i = 0; i < contas.size(); i++)
		{
			if (contas.get(i).getNumConta() == num)
			{	
				consulta = true;
				indice = i;
			}
		}
		return consulta;
	}
	
	
	static void println(Object text)
	{
		System.out.println(text);
	}
	static void print(Object text)
	{
		System.out.print(text);
	}
	static void printExtrato()
	{
		println("Num Conta  Nome do Cliente                               Saldo                      Tipo de Conta");
		println("---------  ------------------------------               --------------            -------------------");
	}
	

}
