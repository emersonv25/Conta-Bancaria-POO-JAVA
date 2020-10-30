/*
 *  Autor: Emerson de Jesus Santos
 *  Mat: 16017157
 *  Formando em Analise e desenvolvimento de sistemas
 *  Centro Universitário Maurício de Nassau
 *  
 */
package banco.model;

import java.io.Serializable;

public class ContaEspecial extends Conta implements Serializable {
	
	private double cEspecial;
	
	// construtor default
	public ContaEspecial() {
		super();
		this.cEspecial = 0;
	}
	
	// sobrecargas
	public ContaEspecial(int numConta, String nomeCliente, double creditoEspecial)
	{
		super(numConta, nomeCliente);
		this.cEspecial = creditoEspecial;
		
	}
	
	public ContaEspecial(int numConta, String nomeCliente, double creditoEspecial, double saldo)
	{
		super(numConta, nomeCliente, saldo);
		this.cEspecial = creditoEspecial;
		this.saldo = saldo;
		
	}
	
	@Override
	public boolean saque(double valor)
	{
		if (valor > 0 && valor <= saldo + cEspecial)
		{
			
			if (this.saldo >= -cEspecial)
			{
				this.saldo -= valor;
			}
			
			if (this.saldo < 0)
			{	
				System.out.println("Será cobrado o valor de R$" + saldo + " no proximo deposito");
				return true;
			}
			return true;
			
		}
		else
		{
			System.out.println("OPS: Não foi possível efetuar o saque, saldo insuficiente ou valor negativo !");
			return false;
		}
	}
	@Override
	public void extrato()
	{
		//System.out.println("Num Conta  Nome do Cliente                               Saldo              Tipo da Conta");
		//System.out.println("---------  ------------------------------            ----------------     --------------------");
		//System.out.println("xxxx     xxxxxxxxxxxxxxxxxxxxx              xxxx,xx ");
		System.out.printf("%5d  \t    %-40s \tR$ %-6.2f  \t \t Especial - Credito: R$%.2f \n\n", getNumConta(), getNome(), getSaldo(), getCreditoEspecial());
	}
	
	// getter
	public Double getCreditoEspecial()
	{
		return this.cEspecial;
	}
	//setter
	public void setCreditoEspecial(double credito)
	{
		cEspecial = credito;
	}
	

}
