package br.com.serratec.entidadesConta;

import br.com.serratec.entidades.Pessoa;
import br.com.serratec.enums.Agencia;

public abstract class Conta {

	protected double saldo;
	protected String tipoConta;
	protected Pessoa pessoa;
	protected double valorTributo;
	protected Agencia agencia;

	public Conta(Pessoa pessoa,Agencia agencia) {
		this.pessoa = pessoa;
		this.agencia = agencia;

	}

	public double getSaldo() {
		return saldo;
	}

	public void deposito(double quantidade) {
		this.saldo += quantidade;
		this.saldo -= 00.10;
		this.valorTributo += 00.10;
	}

	public void saque(double quantidade) {
		if (this.saldo >= (quantidade + 00.10)) {
			this.saldo -= (quantidade + 00.10);
			this.valorTributo += 00.10;
		}
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public double getValorTributo() {
		return valorTributo;
	}

	@Override
	public String toString() {
		return "Dono da Conta:\n" + pessoa + "\nSALDO: " + saldo + "\nTIPO: " + tipoConta;

	}
}