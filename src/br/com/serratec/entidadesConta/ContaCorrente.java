package br.com.serratec.entidadesConta;

import br.com.serratec.entidades.Pessoa;
import br.com.serratec.enums.Agencia;

public class ContaCorrente extends Conta {

	private double limiteEmprestimo;

	public ContaCorrente(Pessoa pessoa,Agencia agencia, double limiteEmprestimo) {
		super(pessoa,agencia);
		this.limiteEmprestimo = limiteEmprestimo;
		this.tipoConta = "Conta-Corrente";
	}

	public double getLimiteEmprestimo() {
		return limiteEmprestimo;
	}

	public void setLimiteEmprestimo(double limiteEmprestimo) {
		this.limiteEmprestimo = limiteEmprestimo;
	}
	
	public void pedirEmprestimo(double valor){
		if(this.limiteEmprestimo >= valor) {
			this.limiteEmprestimo -= valor;	
			this.saldo += valor;
		}
	}
	
	@Override
	public String toString() {
		return 
				"Dono da Conta:\n"
				+ pessoa
				+ "\nSALDO: " 
				+ saldo
				+ "\nTIPO: "
				+ tipoConta
				+"\nLIMITE EMPRESTIMO: " 
				+ limiteEmprestimo;
				
	}
}