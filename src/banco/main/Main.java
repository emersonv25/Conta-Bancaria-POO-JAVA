/*
 *  Autor: Emerson de Jesus Santos
 *  Mat: 16017157
 *  Formando em Analise e desenvolvimento de sistemas
 *  Centro Universitário Maurício de Nassau
 *  
 */


package banco.main;

import java.util.ArrayList;

import banco.util.ObjectFile;
import banco.model.*;
import banco.util.Keyboard;


public class Main {
	
	// variaveis globais
	static String nome;
	static int num;
	static ArrayList<Conta> contas = new ArrayList<>(); // cria um arraylist do objeto contas
	static Menu menu = new Menu(); // cria um objeto da classe Menu para usar os metodos não-estaticos
	static ObjectFile arquivo = new ObjectFile("Contas.dat");	

	public static void main(String[] args) 
	{
		leiaArquivo();


		int opcao = 0;
		while (opcao != 9)
		{
			
			//Menu.printMenu(); // printa o MENU de opções
		
			opcao = Keyboard.menu("Cadastrar Contas/Listar Contas/Excluir Contas/Efetuar Depósitos/"
					+ "Efetuar Saques/Consultar Conta/Efetuar transferência entre contas/Creditar Rendimento/Sair e Salvar");
			
			
			
			// switch de opções
			switch(opcao)
			{
				case 1:		
					cadastro();
					break;
				// caso 2, listará o número de contas
				case 2:
					menu.listar(contas);	
					enter();
					break;
				case 3:
					menu.listar(contas);
					menu.excluir(contas);
					enter();
					break;
				case 4:
					menu.depositos(contas);
					enter();
					break;
				case 5:
					menu.saques(contas);
					enter();
					break;
				case 6:
					menu.consultar(contas);
					enter();
					break;
				case 7:
					menu.transferir(contas);
					break;
				case 8:
					menu.creditar(contas);
					break;
				case 9:
					sair();
					break;
				default:
					print("Opção Inválida!");
					break;
			}
			
			
		} 
		graveArquivo();
		
	}
	
	// Uma função para organizar o print
	static void print(Object text)
	{
		System.out.println(text);
	}
	//	
	static void sair () 
	{ 
		graveArquivo();
		System.out.println("Programa Encerrado.");
		System.exit(0);
	}
	//
	static void enter()
	{
		Keyboard.waitEnter();
	}
	//
	private static void cadastro() 
	{
		int tipo = 0;
		
		while (tipo != 4)
		{
			//Keyboard.clrscr();
			tipo = Keyboard.menu("Conta Comum/Conta Poupança/Conta Especial/Sair");		
			switch(tipo) 
			{			   
			   case 1:		
				   menu.cadastrarContaComum(contas);
				   break;
			   case 2:	
				   menu.cadastrarContaPoupanca(contas);
				   break;
			   case 3:
				   menu.cadastrarContaEspecial(contas);
				   break;
			   
			}
		}
	}
	// GRAVAÇÃO E LEITURA NO ARQUIVO DAT
    private static void graveArquivo()
    {
		 arquivo.rewrite();
		 for(int i=0; i < contas.size(); i++ )
		 {
			 arquivo.write(contas.get(i));
		 }
		 arquivo.closeFile();
		 System.out.println("Dados salvo com sucesso."); 	
	}

	private static void leiaArquivo(){
		if (arquivo.reset()){
			Conta conta = (Conta) arquivo.read();
			while (conta != null){
				contas.add(conta);
				conta = (Conta) arquivo.read();
			}
			arquivo.closeFile();
		}
	}
	

}
