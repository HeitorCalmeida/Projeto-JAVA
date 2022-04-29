package br.com.serratec.entidadesConta;

import br.com.serratec.entidades.Pessoa;

public abstract class Conta {

	protected double saldo;
	protected String tipoConta;
	protected Pessoa pessoa;
	
	public Conta(Pessoa pessoa) {
			this.pessoa = pessoa;
		
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void deposito(double quantidade) {
		this.saldo += quantidade;
	}
	public void saque(double quantidade) {
		if(this.saldo > quantidade) {
			this.saldo -= (100 + 00.10);
		}
	}
	
	public String getTipoConta() {
		return tipoConta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	@Override
	public String toString() {
		return	
				"Dono da Conta:\n"
				+ pessoa
				+ "\nSALDO: " 
				+ saldo
				+ "\nTIPO: "
				+ tipoConta;
			
	}
}