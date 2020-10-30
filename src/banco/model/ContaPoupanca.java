/*
 *  Autor: Emerson de Jesus Santos
 *  Mat: 16017157
 *  Formando em Analise e desenvolvimento de sistemas
 *  Centro Universitário Maurício de Nassau
 *  
 */
package banco.model;

import java.io.Serializable;

public class ContaPoupanca extends Conta implements Serializable{
	
	
	// construtor default
	public ContaPoupanca()
	{
		super();
	}
	//sobre carga
	public ContaPoupanca(int numConta, String nomeCliente)
	{
		super(numConta, nomeCliente);
	}
	public ContaPoupanca(int numConta, String nomeCliente, double saldo)
	{
		super(numConta, nomeCliente, saldo);
		this.saldo = saldo;
	}
	
	@Override
	public boolean saque(double valor) {
		if (valor > 0 && valor <= saldo)
		{
			this.saldo -= valor;
			return true;
			
		}
		else
		{
			System.out.println("OPS: Não foi possível efetuar o saque, saldo insuficiente ou valor negativo !");
			return false;
		}
		
	}
	
	// rendimento conta poupança
	public void creditar(double juros)
	{
		saldo = saldo + ((juros/100)*saldo);
	}
	
	
	public void extrato()
	{
		//System.out.println("Num Conta  Nome do Cliente                               Saldo              Tipo da Conta");
		//System.out.println("---------  ------------------------------            ----------------     --------------------");
		//System.out.println("xxxx     xxxxxxxxxxxxxxxxxxxxx              xxxx,xx ");
		System.out.printf("%5d  \t    %-40s \tR$ %-6.2f  \t \t Poupança  \n\n", getNumConta(), getNome(), getSaldo());
	}

}
