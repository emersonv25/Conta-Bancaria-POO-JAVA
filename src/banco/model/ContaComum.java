/*
 *  Autor: Emerson de Jesus Santos
 *  Mat: 16017157
 *  Formando em Analise e desenvolvimento de sistemas
 *  Centro Universitário Maurício de Nassau
 *  
 */
package banco.model;

import java.io.Serializable;

public class ContaComum extends Conta implements Serializable {
		
	// construtor default
	public ContaComum () {
		super();
	}
	// sobrecarga
	public ContaComum(int numConta, String nomeCliente)
	{
		super(numConta, nomeCliente);
		
	}
	
	public ContaComum(int numConta, String nomeCliente, double saldo)
	{
		super(numConta, nomeCliente, saldo);
		
	}

	
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
	
	public void extrato()
	{
		//System.out.println("Num Conta  Nome do Cliente                               Saldo              Tipo da Conta");
		//System.out.println("---------  ------------------------------            ----------------     --------------------");
		//System.out.println("xxxx     xxxxxxxxxxxxxxxxxxxxx              xxxx,xx ");
		System.out.printf("%5d  \t    %-40s \tR$ %-6.2f  \t \t Comum  \n\n", getNumConta(), getNome(), getSaldo());
	}
}

