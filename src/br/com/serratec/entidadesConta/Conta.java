package br.com.serratec.entidadesConta;

import br.com.serratec.entidades.Pessoa;
import br.com.serratec.enums.Agencia;

public abstract class Conta {

	protected double saldo;
	protected String tipoConta;
	protected Pessoa pessoa;
	protected double valorTributo;
	protected Agencia agencia;
	protected Integer numeroConta;

	public Conta(Pessoa pessoa,Agencia agencia) {
		this.pessoa = pessoa;
		this.agencia = agencia;
		this.numeroConta = (int)Math.floor(Math.random()*(999999999-1+1)+0);

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

	public Integer getNumeroConta(){
		return numeroConta;
	}

	@Override
	public String toString() {
		return "Dono da Conta:\n" + pessoa + "\nSALDO: " + saldo + "\nTIPO: " + tipoConta + "\nNUMERO DA CONTA: " + numeroConta;

	}
}