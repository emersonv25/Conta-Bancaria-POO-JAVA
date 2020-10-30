/*
 *  Autor: Emerson de Jesus Santos
 *  Mat: 16017157
 *  Formando em Analise e desenvolvimento de sistemas
 *  Centro Universitário Maurício de Nassau
 *  
 */

package banco.model;

import java.io.Serializable;

public abstract class Conta  implements Serializable
{

	protected int numConta;
	protected String nomeCliente;
	protected double saldo;

	//Construtor default
	public Conta() {
	}
	
	public Conta(int numConta, String nomeCliente)
	{
		this.numConta = numConta;
		this.nomeCliente = nomeCliente;
		this.saldo = 0;
		//this.cDevedor = 0;
		
	}
	
	// SOBRECARGAS
	public Conta(int numConta, String nomeCliente, double saldo)
	{
		this.numConta = numConta;
		this.nomeCliente = nomeCliente;
		this.saldo = saldo;
		
	}
	
	public abstract boolean saque(double v);
	
	public boolean deposito (double valor)
	{
		if (valor > 0)
		{
			this.saldo += valor;
			return true;
		}
		else
		{
			return false;
		}
	}
		
	
	// GETTERS
	public double getSaldo()
	{
		return saldo;
	}
	
	public int getNumConta()
	{
		return this.numConta;
	}
	
	public String getNome()
	{
		return this.nomeCliente;
	}


	
	
	public abstract void extrato();
	
	
}
