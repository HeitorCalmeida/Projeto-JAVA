package br.com.serratec.entidadesConta;

public class ContaCorrente extends Conta {

	private double limiteEmprestimo;

	public ContaCorrente(String cpfTitular, double limiteEmprestimo) {
		super(cpfTitular);
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
		if(this.limiteEmprestimo > valor) {
			this.limiteEmprestimo -= valor;			
		}
	}
	
	@Override
	public String toString() {
		return "Limite de Emprestimo: " 
				+ limiteEmprestimo
				+ "\ncPFtitular: "
				+ cpfTitular
				+ "\nsaldo: "
				+ saldo;
	}
}