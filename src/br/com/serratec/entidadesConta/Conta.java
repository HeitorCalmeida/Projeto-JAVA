package br.com.serratec.entidadesConta;

public abstract class Conta {

	protected String cpfTitular;
	protected double saldo;
	
	
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
	
	@Override
	public String toString() {
		return
				 "\nCPFtitular: " 
				+ cpfTitular 
				+ "\nsaldo: " 
				+ saldo;
	}
}