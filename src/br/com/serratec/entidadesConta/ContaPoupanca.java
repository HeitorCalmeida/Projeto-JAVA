package br.com.serratec.entidadesConta;

public class ContaPoupanca extends Conta{
		private double rendimento;

		public ContaPoupanca(String cpfTitular, double rendimento) {
			super(cpfTitular);
			this.rendimento = rendimento;
			this.tipoConta = "Conta-Poupança";
		}

		public double getRendimento() {
			return rendimento;
		}
		
		

}
