package br.com.serratec.entidadesConta;

import br.com.serratec.entidades.Pessoa;

public abstract class Conta {

	protected double saldo;
	protected String tipoConta;
	protected Pessoa pessoa;
	protected Double valorTributo;

	public Conta(Pessoa pessoa) {
		this.pessoa = pessoa;

	}

	public double getSaldo() {
		return saldo;
	}

	public void deposito(double quantidade) {
		this.saldo += quantidade;
		this.saldo -= (quantidade + 00.10);
		
	}
	

	public void saque(double quantidade) {
		if (this.saldo > quantidade) {
			this.saldo -= (quantidade + 00.10);
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
		return "Dono da Conta:\n" + pessoa + "\nSALDO: " + saldo + "\nTIPO: " + tipoConta;

	}
}