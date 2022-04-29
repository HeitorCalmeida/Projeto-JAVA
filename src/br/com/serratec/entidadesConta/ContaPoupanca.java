package br.com.serratec.entidadesConta;

import br.com.serratec.entidades.Pessoa;

public class ContaPoupanca extends Conta{
		private double rendimento;

		public ContaPoupanca(Pessoa pessoa, double rendimento) {
			super(pessoa);
			this.rendimento = rendimento;
			this.tipoConta = "Conta-Poupança";
		}

		public double getRendimento() {
			return rendimento;
		}
		
		

}
