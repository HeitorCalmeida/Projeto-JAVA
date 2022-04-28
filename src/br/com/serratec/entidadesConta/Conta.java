package br.com.serratec.entidadesConta;

import br.com.serratec.entidades.Pessoa;

public abstract class Conta {

	protected String cpfTitular;
	protected double saldo;
	protected String tipoConta;
	protected Pessoa pessoa;
	
	public Conta(String cpfTitular) {
		if(cpfTitular.length() == 11) {
			this.cpfTitular = cpfTitular;
		}
	}
	
	public String getCpfTitular() {
		return cpfTitular;
	}

	public double getSaldo() {
		return saldo;
	}
	
	public void deposito(double quantidade) {
		this.saldo += quantidade;
	}
	public void saque(double quantidade) {
		if(this.saldo > quantidade) {
			this.saldo -= quantidade;
		}
	}
	
	public String getTipoConta() {
		return tipoConta;
	}

	@Override
	public String toString() {
		return
				 "\nCPFtitular: " 
				+ cpfTitular 
				+ "\nsaldo: " 
				+ saldo;
	}
}