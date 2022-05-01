package br.com.serratec.entidadesConta;

import br.com.serratec.entidades.Pessoa;
import br.com.serratec.enums.Agencia;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta {

	protected Double saldo;
	protected String tipoConta;
	protected Pessoa pessoa;
	protected List<Double> taxasPagas = new ArrayList<Double>();
	protected Double taxasPagasTotal;
	protected Agencia agencia;
	protected Integer numeroConta;
	protected Double taxa;

	public Conta(Pessoa pessoa,Agencia agencia) {
		this.pessoa = pessoa;
		this.agencia = agencia;
		this.saldo = 0.00;
		this.taxasPagasTotal = 0.00;
		this.taxa = 0.10;
		this.numeroConta = (int)Math.floor(Math.random()*(999999999-1+1)+0);

	}

	public Double getSaldo() {
		return saldo;
	}

	public Boolean deposito(Double quantidade) {
		try{
			if(quantidade > this.taxa){
				this.saldo += (quantidade - this.taxa);
				this.taxasPagasTotal = (this.taxasPagasTotal + this.taxa);
				this.taxasPagas.add(this.taxa);
				return true;
			}
			return false;
		}catch (Exception e){
			System.out.println(e);
			return false;
		}
	}

	public Boolean saque(Double quantidade) {
		try{
			if (this.saldo >= (quantidade + this.taxa)) {
				this.saldo = this.saldo - (quantidade + this.taxa);
				this.taxasPagasTotal = (this.taxasPagasTotal + this.taxa);
				this.taxasPagas.add(this.taxa);
				return true;
			}
			return false;
		}catch (Exception e){
			return false;
		}

	}

	public String getTipoConta() {
		return tipoConta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public Double getTaxasPagasTotal() {
		return taxasPagasTotal;
	}

	public List<Double> getTaxasPagas() {
		return taxasPagas;
	}

	public Double getTaxa() {
		return taxa;
	}

	public Integer getNumeroConta(){
		return numeroConta;
	}

	@Override
	public String toString() {
		return "Dono da Conta:\n" + pessoa + "\nSALDO: " + saldo + "\nTIPO: " + tipoConta + "\nNUMERO DA CONTA: " + numeroConta;

	}
}
